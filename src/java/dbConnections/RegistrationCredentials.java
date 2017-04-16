package dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationCredentials {
    
    private String name, password, repeatPassword, acc_number, PrimaryContactNumber, email, acc_type, gender, DateOfBirth, city; 

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setAcc_number(String acc_number) {
        this.acc_number = acc_number;
    }

    public void setPrimaryContactNumber(String PrimaryContactNumber) {
        this.PrimaryContactNumber = PrimaryContactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAcc_type(String acc_type) {
        if(acc_type.equalsIgnoreCase("current account"))
            this.acc_type="C";
        else
            this.acc_type="S";
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("male"))
            this.gender="m";
        else
            this.gender="f";
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int register() throws SQLException
    {
        ResultSet rs;
        int m=0;
        int n=0;
           
        if(!password.equals(repeatPassword))
        {
            return -10;
        }
        
        else
        {
            /*
            System.out.println("Form ki details:");
            System.out.println(name);
            System.out.println(password);
            System.out.println(acc_number);
            System.out.println(acc_type);
            System.out.println(PrimaryContactNumber);
            System.out.println(email);
            System.out.println(gender);
            System.out.println(DateOfBirth);
            System.out.println(city);
            
            check();
            */
            Connection con=null;
            try
            {
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
                Statement st=con.createStatement();
                rs=st.executeQuery("select * from UserDetails where acc_number="+Integer.parseInt(acc_number));
                if(rs.next())
                {
                    if(rs.getString("E_BANKING").equalsIgnoreCase("Y"))
                    {
                        return -5;
                    }
                    
                    int detailsCheck=-10;
                    if(rs.getString(1).equalsIgnoreCase(name))
                        if(rs.getInt(2)==Integer.parseInt(acc_number))
                            if(rs.getString(3).equalsIgnoreCase(acc_type))
                                if(rs.getInt(4)==Integer.parseInt(PrimaryContactNumber))
                                    if(rs.getString(5).equals(email))
                                        if(rs.getString(6).equalsIgnoreCase(gender))
                                            if(rs.getString(7).equalsIgnoreCase(city))
                                                detailsCheck=10;
                    
                    if(detailsCheck==10)
                    {
                        Statement st1=con.createStatement();
                        m=st1.executeUpdate("update userdetails set e_banking='Y' where acc_number="+acc_number);
                        PreparedStatement st2=con.prepareStatement("insert into logintable values(?,?,?)");
                        st2.setInt(1, Integer.parseInt(acc_number));
                        st2.setString(2, password);
                        st2.setString(3, name);
                        n=st2.executeUpdate();
                    }
                    else
                    {
                        return detailsCheck;
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                if(con!=null)
                    con.close();
            }
        }
        if(m!=0 && n!=0)
            return 1;
        else
        {
            return 0;
        }
    }
    /*
    public void check()
    {
            try
            {
                DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from UserDetails where acc_number=10001");
                if(rs.next())
                {
                    System.out.println("Database se result:");
                    System.out.println(rs.getString(1));
                    System.out.println(rs.getInt(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getInt(4));
                    System.out.println(rs.getString(5));
                    System.out.println(rs.getString(6));
                    System.out.println(rs.getString(7));
                    System.out.println(rs.getString(8));
                    System.out.println(rs.getString(9));
                    System.out.println(rs.getInt(10));
                }
            }
            catch(Exception e)
            {
                
            }
    }
    */
}

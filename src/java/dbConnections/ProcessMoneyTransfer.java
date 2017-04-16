package dbConnections;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NIMISH
 */
public class ProcessMoneyTransfer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessMoneyTransfer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessMoneyTransfer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        int amount=Integer.parseInt(request.getParameter("amount"));
        int sender=Integer.parseInt(request.getParameter("sender"));
        int receiver=Integer.parseInt(request.getParameter("receiver"));
        
        Cookie[] cookie=request.getCookies();
        for(int i=0;i<cookie.length;i++)
            if(cookie[i].getName().equalsIgnoreCase("acc_number"))
                if(Integer.parseInt(cookie[i].getValue())==sender)
                    ; //Sender account matches session account
                else
                {
                    response.sendRedirect("senderAccNumNotMatching.jsp");
                    return;
                }    
    
        int m=10;
        ResultSet rs=null;
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
            Statement st=con.createStatement();
            rs=st.executeQuery("select * from UserDetails where acc_number=" + sender);
            rs.next();
            int senderBalance=rs.getInt(10);
            if(amount>senderBalance)
                m=-5;
            
            
            if(m!=-5)
            {
               st.executeUpdate("update UserDetails set amount=amount-" + amount + " where acc_number=" + sender);
               m=st.executeUpdate("update UserDetails set amount=amount+" + amount + " where acc_number=" + receiver);
            }
            
            if(m==-5)
            {
                response.sendRedirect("insufficientBalance.jsp");
                return;
            }
            else
                if(m==0)
                {
                    response.sendRedirect("noSuchReceiver.jsp");
                    return;
                }
            else
                    if(m==1)
                    {
                        response.sendRedirect("successfulMoneyTransfer.jsp");
                        return;
                    }
            else
                    {
                        response.sendRedirect("technicalProblem.html");
                        return;
                    }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
//out.println("Something's wrong");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

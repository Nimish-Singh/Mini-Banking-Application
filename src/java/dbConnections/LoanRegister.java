package dbConnections;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class LoanRegister extends HttpServlet {

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
            out.println("<title>Servlet LoanRegister</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanRegister at " + request.getContextPath() + "</h1>");
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
        
        int acc_number=0, amount=0, contact_num=0;
        String type="", vendor="", job_desc="", status="";
        
        Cookie[] cookie=request.getCookies();
        for(int i=0;i<cookie.length;i++)
            if(cookie[i].getName().equalsIgnoreCase("acc_number"))
                acc_number=Integer.parseInt(cookie[i].getValue());
        
        amount=Integer.parseInt(request.getParameter("estimatedAmount"));
        contact_num=Integer.parseInt(request.getParameter("contactNum"));
        vendor=request.getParameter("vendor");
        job_desc=request.getParameter("job");
        
        if(request.getParameter("loan_type").equalsIgnoreCase("Education loan"))
            type="E";
        else
            if(request.getParameter("loan_type").equalsIgnoreCase("Home loan"))
               type="H";
        else
                type="C";
        
        int m=0;
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
            PreparedStatement st=con.prepareStatement("insert into LoanTable values(?,?,?,?,?,?,?)");
            st.setInt(1, acc_number);
            st.setString(2, type);
            st.setInt(3, amount);
            st.setString(4, vendor);
            st.setString(5, job_desc);
            st.setInt(6, contact_num);
            st.setString(7, "P");
            m=st.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        if(m!=0)
        {
            response.sendRedirect("loanApplicationSuccessful.jsp");
            return;
        }
        else
        {
            response.sendRedirect("technicalProblem.html");
            return;
        }
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

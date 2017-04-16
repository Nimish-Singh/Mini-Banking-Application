package sessionManagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NIMISH
 */
public class LoanStatus extends HttpServlet {

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
            out.println("<title>Servlet LoanStatus</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanStatus at " + request.getContextPath() + "</h1>");
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
        
        Cookie[] cookies=request.getCookies();
        Boolean foundCookie=false;
        int acc_number=-1;
        if(cookies!=null)
        {
            for(int i=0;i<cookies.length;i++)
                if(cookies[i].getName().equalsIgnoreCase("vistaarUsername"))
                {
                    foundCookie=true;
                    break;
                }
        }
        else
        {
            response.sendRedirect("login.html");
            return;
        }
        
        if(foundCookie)
        {
            for(int i=0;i<cookies.length;i++)
                if(cookies[i].getName().equalsIgnoreCase("acc_number"))
                {
                    acc_number=Integer.parseInt(cookies[i].getValue());
                    break;
                }
        }
        else
        {
            response.sendRedirect("login.html");
            return;
        }
        
        if(acc_number>0)
        {
            response.sendRedirect("LoanDetailsDisplay");
            return;
        }
        else
        {
            response.sendRedirect("technicalProblem.html");
            return;
        }

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
        processRequest(request, response);
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

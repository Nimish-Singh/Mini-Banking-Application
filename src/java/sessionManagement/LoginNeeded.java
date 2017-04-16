package sessionManagement;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginNeeded extends HttpServlet {

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
            out.println("<title>Servlet LoginNeeded</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginNeeded at " + request.getContextPath() + "</h1>");
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
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Cookie[] cookies=null;
        cookies=request.getCookies();
        Boolean found=false;
        String user=null;
        if(cookies!=null)
        {    
            int i;
            for(i=0;i<cookies.length;i++)
            {
                if(cookies[i].getName().equalsIgnoreCase("vistaarUsername"))
                   {
                       user=cookies[i].getValue();
                       found=true;
                       //System.out.println("Servlet cookie:"+cookies[i].getValue());
                       break;
                   }
            }
            
            /*
            RequestDispatcher rd=request.getRequestDispatcher("alreadyLoggedIn.jsp");
            rd.forward(request, response);
            */
        }
        if(found)
        {
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"	<title>Vistaar Bank</title>\n" +
"	<meta charset=\"utf-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"	<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
"	<link href=\"http://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"http://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
"	<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n" +
"\n" +
"	<style>\n" +
"	.navbar {\n" +
"		margin-bottom: 0;\n" +
"		background-color: #0066ff;\n" +
"		z-index: 9999;\n" +
"		border: 0;\n" +
"		font-size: 12px !important;\n" +
"		line-height: 1.42857143 !important;\n" +
"		letter-spacing: 4px;\n" +
"		border-radius: 0;\n" +
"		font-family: Montserrat, sans-serif;\n" +
"	}\n" +
"\n" +
"	.navbar li a, .navbar .navbar-brand {\n" +
"		color: #fff !important;\n" +
"	}\n" +
"\n" +
"	.navbar-nav li a:hover, .navbar-nav li.active a {\n" +
"		color: #0066ff !important;\n" +
"		background-color: #fff !important;\n" +
"	}\n" +
"\n" +
"	.navbar-default .navbar-toggle {\n" +
"		border-color: transparent;\n" +
"		color: #fff !important;\n" +
"	}\n" +
"\n" +
"	.dropdown-menu {\n" +
"		color: #fff;\n" +
"		background-color: #0066ff;\n" +
"	}\n" +
"\n" +
"	.carousel-control.right, .carousel-control.left {\n" +
"		background-image: none;\n" +
"		color: #fff;\n" +
"	}\n" +
"\n" +
"	.carousel-indicators li {\n" +
"		border-color: #0066ff;\n" +
"	}\n" +
"	\n" +
"	.carousel-indicators li.active {\n" +
"		background-color: #6699ff;\n" +
"	}\n" +
"\n" +
"	.item span {\n" +
"		font-style: normal;\n" +
"	}\n" +
"\n" +
"	.carousel {\n" +
"		background-color: #6699ff;\n" +
"	}\n" +
"\n" +
"	.carousel-caption {\n" +
"		color: #fff;\n" +
"		background-color: #6699ff;\n" +
"		position: relative;\n" +
"		left: auto;\n" +
"		right: auto;\n" +
"	}\n" +
"\n" +
"	h2 {\n" +
"		font-size: 24px;\n" +
"		text-transform: uppercase;\n" +
"		font-weight: 600;\n" +
"                margin-top: 100px;\n" +
"                color: #000;\n" +
"	}\n" +
"\n" +
"	.standard-formatting-light {\n" +
"		color:#fff;\n" +
"		background-color: #6699ff;\n" +
"	}\n" +
"	\n" +
"	.standard-formatting-dark {\n" +
"		color:#fff;\n" +
"		background-color: #0066ff;\n" +
"	}\n" +
"\n" +
"\n" +
"	p {\n" +
"		color: #d9d9d9;\n" +
"	}\n" +
"\n" +
"	.carousel-indicators li {\n" +
"		background: #ff6;\n" +
"	}\n" +
"\n" +
"	.carousel-indicators .active {\n" +
"		background: #f00;\n" +
"	}\n" +
"\n" +
"	footer .glyphicon {\n" +
"		font-size: 20px;\n" +
"		margin-bottom: 20px;\n" +
"		color: #009;\n" +
"	}\n" +
"\n" +
"	.panel {\n" +
"		border: 1px solid #6699ff;\n" +
"		border-radius: 0;\n" +
"		transition: box-shadow 0.5s;\n" +
"	}\n" +
"	\n" +
"	.panel:hover {\n" +
"		box-shadow: 5px 0px 40px rgba(0,0,0, .2);\n" +
"	}\n" +
"\n" +
"	.panel-heading {\n" +
"		color: #fff !important;\n" +
"		background-color: #6699ff !important;\n" +
"		padding: 25px;\n" +
"		border-bottom: 1px solid transparent;\n" +
"		border-top-left-radius: 0px;\n" +
"		border-top-right-radius: 0px;\n" +
"		border-bottom-left-radius: 0px;\n" +
"		border-bottom-right-radius: 0px;\n" +
"	}\n" +
"\n" +
"	.panel-footer {\n" +
"		background-color: #6699ff;\n" +
"	}\n" +
"	\n" +
"	.panel-body p {\n" +
"		color: #06f;\n" +
"	}		\n" +
"	\n" +
"	@media screen and (max-width: 768px) {\n" +
"		.col-sm-4 {\n" +
"			text-align: center;\n" +
"			margin: 25px 0;\n" +
"		}\n" +
"	}\n" +
"</style>\n" +
"\n" +
"</head>\n");
            out.println("<body id=\"loggedIn\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">\n" +
"\n" +
"<nav class=\"navbar navbar-default navbar-fixed-top\">\n" +
"	<div class=\"container\">\n" +
"		<div class=\"navbar-header\">\n" +
"			<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n" +
"				<span class=\"icon-bar\"></span>\n" +
"				<span class=\"icon-bar\"></span>\n" +
"				<span class=\"icon-bar\"></span>\n" +
"			</button>\n" +
"			<img src=\"images/Vistaar logo.jpg\" width=\"80\" height=\"50\"/>\n" +
"			<a class=\"navbar-brand\" href=\"index.html#myPage\">Vistaar Bank Pvt. Ltd.</a>\n" +
"		</div>\n" +
"		<div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n" +
"			<ul class=\"nav navbar-nav navbar-right\">\n" +
"				<li class=\"dropdown\">\n" +
"					<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">PERSONAL\n" +
"						<span class=\"caret\"></span>\n" +
"					</a>\n" +
"					<ul class=\"dropdown-menu\">\n" +
"						<li><a href=\"ViewAccount\">View Account Details</a></li>\n" +
"						<li><a href=\"TransferMoney\">Transfer Money</a></li>\n" +
"					</ul>\n" +
"				</li>\n" +
"				<li class=\"dropdown\">\n" +
"					<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">LOANS\n" +
"						<span class=\"caret\"></span>\n" +
"					</a>\n" +
"					<ul class=\"dropdown-menu\">\n" +
"						<li><a href=\"LoanApply\">Apply For Loan</a></li>\n" +
"						<li><a href=\"LoanStatus\">View Loan Status</a></li>\n" +
"					</ul>\n" +
"				</li>\n" +
"				<li><a href=\"index.html#about\">ABOUT US</a></li>\n" +
"				<li><a href=\"index.html#contact\">CONTACT US</a></li>\n" +
"                                <li><a href=\"LoginNeeded\">Login</a></li>\n" +
"                                <li><a href=\"LogoutNeeded\">Logout</a></li>\n" +
"			</ul>\n" +
"		</div>\n" +
"	</div>\n" +
"</nav>\n" +
"<div class=\"jumbotron text-center standard-formatting-light\">\n");
            out.println("<h2>You are already logged in as:" + user + "</h2>");
            out.println("</div>\n" +
"<footer class=\"container-fluid text-center standard-formatting-dark\">\n" +
"	<p>Copyright : Vistaar Bank Pvt. Ltd.</p>\n" +
"</footer>\n" +
"\n" +
"</body>\n" +
"</html>\n" +
"   \n");
        }
        else
        {
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.forward(request, response);
        }
        /*
        out.println("<html><head></head><body>");
        out.println("<a href='index.html'>Back</a>");
        out.println("</body></html>");
        */
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

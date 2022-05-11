package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Validator;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.dao.DBManagerDAO;
import au.edu.uts.project.domain.Staff;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup the coding
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(); 
        Validator valid = new Validator(); // Create a validator to check the email and password
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager
        Account acct = null;
        Staff staff = null;
        valid.clear(session); // Reset validation message
        
        if (!valid.validateEmail(email)) { // Check if the email is not inserted in the correct format and display error message
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else if (!valid.validatePassword(pass)) { // Check if the password is not inserted in the correct format and display error message
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        else {
            try {
              acct = manager.findUser(email, pass); // Check to see if the email and password is in Customer DB
              staff = manager.findStaff(email, pass); // Check to see if the email and password is in Staff DB
              if (acct != null && acct.isStatus()) { // Direct user to Customer page if they are Customer and their account status is active
                session.setAttribute("account", acct);
                request.getRequestDispatcher("welcome.jsp").include(request, response);
              }
              else if (staff != null && staff.isStatus()) { // Direct user to Staff page if they are Staff and their account status is active
                session.setAttribute("staff", staff);
                request.getRequestDispatcher("welcomeStaff.jsp").include(request, response);
              }
              else { // Display an error message that the user's account doesn't exist or js disabled
                session.setAttribute("existErr", "Account does not exist/is disabled in the database.");
                request.getRequestDispatcher("login.jsp").include(request, response);
              } 
            }
            catch (SQLException | NullPointerException ex){
              System.out.println(ex.getMessage() == null ? "Account does not exist" : "welcome");
           }
        }
      
    }
}

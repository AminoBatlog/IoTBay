/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.DBManagerDAO;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.Staff;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author weichen
 */
public class MainServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       String email = request.getParameter("email").replace("'", "");
       String pass = request.getParameter("password").replace("'", "");
       DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager");
       Account acct = null;
       Staff staff = null;
       String datePattern = "yyyy-MM-dd";
       String timePattern = "HH:mm:ss z";
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern); 
       SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(timePattern);
       String inDate = simpleDateFormat.format(new Date(session.getCreationTime())); // Get the Login Date
       String inTime = simpleTimeFormat.format(new Date(session.getCreationTime())); // Get the Login Time


       try {
         acct = manager.findUser(email, pass); // Check to see if the email and password is in Customer DB
         staff = manager.findStaff(email, pass); // Check to see if the email and password is in Staff DB
         manager.addAccess(email, inDate, inTime); // Add the Login Date and Time associated with the session's email
         if (acct != null) { // If Customer account then set session to that account and redirect to Customer Page
           session.setAttribute("account", acct);
//           request.getRequestDispatcher("main.jsp").include(request, response);
             response.sendRedirect(request.getContextPath() + "/main.jsp");
         } 
         else if (staff != null){ // If Staff account then set session to that account and redirect to Staff Page
           session.setAttribute("staff", staff);
//           request.getRequestDispatcher("mainStaff.jsp").include(request, response);
             response.sendRedirect("/mainStaff.jsp");

         }
         else {
           session.setAttribute("existErr", "Account does not exist in the database.");
           request.getRequestDispatcher(request.getContextPath() + "main.jsp").include(request, response);
         }
         
       } catch (SQLException ex) {
            Logger.getLogger(AccessServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
}

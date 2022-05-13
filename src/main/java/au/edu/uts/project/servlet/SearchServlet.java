/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.DBManagerDAO;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.AccountAccess;
import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.domain.Validator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author weichen
 */
public class SearchServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       Validator valid = new Validator();
       String email = request.getParameter("email");
       String pass = request.getParameter("password");
       String inDate = request.getParameter("date");
       DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager
       Account acct = null;
       valid.clear(session); // Reset validation message

       try {
          acct = manager.findUser(email.replace("'", ""), pass.replace("'", "")); // Check to see if the email and password is in Customer DB
          boolean haveRecord = manager.checkAccess(email.replace("'", ""), inDate); // Check whether records associated with the given email exists in the access log
          if (haveRecord) { // If the records associated with the given email existed then get the list based on the email and login date
              List<AccountAccess> list = manager.listByDate(email.replace("'", ""), inDate);
              session.setAttribute("list", list);
              session.setAttribute("existErr", "");
              if (acct != null) { // If it's a Customer account then redirect to the Customer page
                 request.getRequestDispatcher("access.jsp").include(request, response);
              }
              else { // If it's not a Customer account then redirect to the Staff page
                 request.getRequestDispatcher("accessStaff.jsp").include(request, response);
              }
          }
          else { // If the records associated with the given email don't exist then display error message
              if (acct != null) {
                 session.setAttribute("existErr", "Record does not exist in the database.");
                 request.getRequestDispatcher("access.jsp").include(request, response);
              }
              else {
                 session.setAttribute("existErr", "Record does not exist in the database.");
                 request.getRequestDispatcher("accessStaff.jsp").include(request, response);
              }
          }
       } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
    
}

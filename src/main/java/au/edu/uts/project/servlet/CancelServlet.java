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
public class CancelServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup the coding
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        Account acct = null;
        Staff staff = null;
        DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager

        try {
           acct = manager.findUser(email.replace("'", ""), pass.replace("'", ""));  // Check to see if the email and password is in Customer DB
           staff = manager.findStaff(email.replace("'", ""), pass.replace("'", "")); // Check to see if the email and password is in Staff DB
          if (acct != null) { // If it's a Customer account then set their status to false to deactivate the account
             manager.cancelUser(email.replace("'", ""));
             request.getRequestDispatcher("confirmation.jsp").include(request, response);
          }
          else if (staff != null) { // If it's a Staff account then set their status to false to deactivate the account
             manager.cancelStaff(email.replace("'", ""));
             request.getRequestDispatcher("confirmation.jsp").include(request, response);
          }
        } catch (SQLException ex) {
            Logger.getLogger(CancelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

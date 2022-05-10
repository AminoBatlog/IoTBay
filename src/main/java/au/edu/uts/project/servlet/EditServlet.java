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
public class EditServlet extends HttpServlet {
 
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     HttpSession session = request.getSession();
     String email = request.getParameter("email");
     String pass = request.getParameter("password");
     DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager

     Account acct = null;
     Staff staff = null;
     try {
       acct = manager.findUser(email, pass); // Check to see if the email and password is in Customer DB
       staff = manager.findStaff(email.replace("'", ""), pass.replace("'", "")); // Check to see if the email and password is in Staff DB
       if (acct != null) { // Direct to edit page for Customer if user is in Customer DB
           session.setAttribute("account", acct);
           request.getRequestDispatcher("edit.jsp").include(request, response);
       }
       else if (staff != null) { // Direct to edit page for Staff if user is in Staff DB
           session.setAttribute("staff", staff);
           request.getRequestDispatcher("editStaff.jsp").include(request, response);
       }
       else if (acct == null) { // Display account doesn't exist if user not in Customer DB
           session.setAttribute("existErr", "Account does not exist in the database.");
           request.getRequestDispatcher("edit.jsp").include(request, response);
       }
       else if (staff == null) { // Display account doesn't exist if user not in Staff DB
           session.setAttribute("existErr", "Account does not exist in the database.");
           request.getRequestDispatcher("editStaff.jsp").include(request, response);
       }
     }
     catch (SQLException ex) {
       Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
       System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
     }
  }
    
}

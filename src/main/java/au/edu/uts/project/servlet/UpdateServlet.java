/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.DBManagerDAO;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.domain.Validator;
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
public class UpdateServlet extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String gender = request.getParameter("gender");
        int addressStreetNo = Integer.parseInt(request.getParameter("address_streetNo"));
        String addressStreetName = request.getParameter("address_streetName");
        String addressCity = request.getParameter("address_city");
        int addressZipcode = Integer.parseInt(request.getParameter("address_zipcode"));
        String addressCountry = request.getParameter("address_country");
        String dob = request.getParameter("dob");
        String roles = request.getParameter("roles");
        Account acct = null;
        Staff staff = null;
        DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager
        Validator valid = new Validator(); // Create a validator to check the email and password
        session.setAttribute("updated", ""); // Reset update message
        valid.clear(session); // Reset error message

        try {
            acct = manager.checkUserEmail(email); // Check to see if the email and password is in Customer DB
            staff = manager.checkStaffEmail(email); // Check to see if the email and password is in Staff DB
            if (acct != null) { // If user is a Customer then it will create a new Customer with the given information and set the account to this session
               if (!valid.validatePassword(pass)) {
                 session.setAttribute("passErr", "Error: Password format is incorrect");
                 request.getRequestDispatcher("edit.jsp").include(request, response);
               }
               else {
                 acct = new Account(fname, lname, email, pass, gender, addressStreetNo, addressStreetName, addressCountry, addressZipcode, addressCity, dob, true);
                 session.setAttribute("account", acct);
                 manager.updateUser(fname, lname, email, pass, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, dob);
                 session.setAttribute("updated", "Update was successful"); // Display a message that the update was successful
                 request.getRequestDispatcher("edit.jsp").include(request, response);
               }
            }
            else if (staff != null) { // If user is a Customer then it will create a new Staff with the given information and set the account to this session
               if (!valid.validatePassword(pass)) {
                 session.setAttribute("passErr", "Error: Password format is incorrect");
                 request.getRequestDispatcher("editStaff.jsp").include(request, response);
               }
               else {
                 staff = new Staff(fname, lname, email, pass, dob, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, roles, true);
                 session.setAttribute("staff", staff);
                 manager.updateStaff(fname, lname, email, pass, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, dob, roles);
                 session.setAttribute("updated", "Update was successful"); // Display a message that the update was successful
                 request.getRequestDispatcher("editStaff.jsp").include(request, response);
               }
            }
            // Display a message that the update was not successful
            else if (acct == null) { 
               session.setAttribute("updated", "Update was not successful");
               request.getRequestDispatcher("edit.jsp").include(request, response);
            }
            else if (staff == null) {
               session.setAttribute("updated", "Update was not successful");
               request.getRequestDispatcher("editStaff.jsp").include(request, response);
            }
        } catch (SQLException ex) {
           Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}

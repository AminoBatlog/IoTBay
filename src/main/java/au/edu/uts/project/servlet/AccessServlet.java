/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.DBManagerDAO;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.AccountAccess;
import au.edu.uts.project.domain.Staff;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class AccessServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        Account acct = null;
        Staff staff = null;
        DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager

        try {
           acct = manager.findUser(email.replace("'", ""), pass.replace("'", "")); // Check to see if the email and password is in Customer DB
           staff = manager.findStaff(email.replace("'", ""), pass.replace("'", "")); // Check to see if the email and password is in Staff DB
           List<AccountAccess> list = manager.listAccess(email.replace("'", "")); // Get the access log associated with the given email
           session.setAttribute("list", list);
           if (acct != null) { // If it's a Customer account then redirect to a Customer page
             request.getRequestDispatcher("access.jsp").include(request, response);
           }
           else if (staff != null) { // If it's a Staff account then redirect to a Staff page
             request.getRequestDispatcher("accessStaff.jsp").include(request, response);
           }
        } catch (SQLException ex) {
            Logger.getLogger(AccessServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

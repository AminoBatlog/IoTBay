/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.DBManagerDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class UpdateLogoutServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String datePattern = "yyyy-MM-dd";
        String timePattern = "HH:mm:ss z";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern); 
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(timePattern);
        String outDate = simpleDateFormat.format(new Date()); // Get the Logout Date
        String outTime = simpleTimeFormat.format(new Date()); // Get the Logout Time
        DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager");

        try {
         manager.updateLogout(email.replace("'", ""), outDate, outTime); // Add the Logout Date and Time associated with the given email
         request.getRequestDispatcher("logout.jsp").include(request, response); // redirect to the logout page
        } catch (SQLException ex) {
            Logger.getLogger(UpdateLogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

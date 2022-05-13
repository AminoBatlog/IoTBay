/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import au.edu.uts.project.dao.*;
import au.edu.uts.project.utils.DatabaseConnection;
/**
 *
 * @author weichen
 */
public class ConnServlet extends HttpServlet {
   private DatabaseConnection db;
   private DBManagerDAO manager;
   private Connection conn;

   //Create an instance of DatabaseConnection for the deployment session
   @Override
   public void init() {

       db = new DatabaseConnection(); // Create a database connection when the application starts
   }

    @Override //Add the DatabaseConnection, DBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession();
       conn = db.getConnection(); // Create a DB connection
       try {
         manager = new DBManagerDAO(conn); // Create a DB manager
       } 
       catch (SQLException ex) {
         Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
       }

           //export the DB manager to the view-session (JSPs)

           session.setAttribute("manager", manager); // Add the manager to the session        

       }
    
    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

        public void destroy() {

        db.close(); // close the DB connection once the session is terminated

    }
    
}

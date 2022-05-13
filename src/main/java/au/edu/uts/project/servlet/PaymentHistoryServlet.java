/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Payment;
import au.edu.uts.project.dao.PaymentDao;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christie
 */
public class PaymentHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       Integer customerID = Integer.parseInt(request.getParameter("cust_ID")); 
       PaymentDao paymentdao = (PaymentDao)session.getAttribute("paymentdao");
       String username = (String) session.getAttribute("username");
           
       if(username != null){
           ArrayList<String> tempList = new ArrayList();
           try {
               System.out.println(cust_ID);
               tempList = paymentdao.getPayments(cust_ID);
           } catch (SQLException e) {
               Logger.getLogger(PaymentHistoryServlet.class.getName()).log(Level.SEVERE, null, e);
           }
                if(tempList != null){
                    session.setAttribute("paymentsList", tempList);
                }  else {
                    session.setAttribute("getMessage", "There is no record of payments");
                }
                response.sendRedirect("paymentHistory.jsp");
           
       } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
       }
    } 
}

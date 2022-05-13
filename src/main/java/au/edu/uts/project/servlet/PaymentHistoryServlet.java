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
       String cust_Email = request.getParameter("Cust_Email"); 
       PaymentDao paymentdao = (PaymentDao)session.getAttribute("paymentdao");
       String email = (String)session.getAttribute("Cust_Email");
           
       if(email != null){
           ArrayList<String> tempList = new ArrayList();
      
               System.out.println(cust_Email);
               tempList = paymentdao.getPayments(cust_Email);
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

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
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Christie
 */
public class DeletePaymentServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer payment_ID = Integer.parseInt(request.getParameter("Payment_ID")); 
        PaymentDao paymentdao = (PaymentDao)session.getAttribute("paymentdao");
        
        Payment payment = null;
        try{
            
            payment = paymentdao.findByID(payment_ID);
            if(payment != null){
                paymentdao.deletePayment(payment_ID);
                System.out.println("Payment deleted.");
            } else {
                System.out.println("Error.");
            }
            response.sendRedirect("main.jsp");
        } catch (SQLException e) {
           System.out.println(e.getErrorCode());
        }
       request.getRequestDispatcher("main.jsp").include(request, response);
    }  
    
}

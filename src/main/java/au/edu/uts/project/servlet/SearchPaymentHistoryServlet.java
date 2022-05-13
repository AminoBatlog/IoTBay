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
public class SearchPaymentHistoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer payment_ID = Integer.parseInt(request.getParameter("payment_ID"));
        String payment_date = request.getParameter("payment_date");
        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao");
        
        Payment payment = null;
        session.setAttribute("searchPayment", null);
        session.setAttribute("searchMessage", null);
   
        
        try{
            payment = paymentdao.findByIDandDATE(payment_ID, payment_date);
      
            if(payment != null){
                session.setAttribute("searchPayment", payment ); 
                request.getRequestDispatcher("searchPaymentHistory.jsp").include(request, response);
            } else {
                session.setAttribute("searchMessage", "No payments found");
                request.getRequestDispatcher("searchPaymentHistory.jsp").include(request, response);
            } 
        } catch (SQLException e) {
           System.out.println(e.getErrorCode());
        }
    }  
}

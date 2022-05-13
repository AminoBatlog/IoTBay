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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christie
 */
public class UpdatePaymentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String payment_method = request.getParameter("payment_method");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String securityCode = request.getParameter("securityCode");
        String nameOnCard = request.getParameter("nameOnCard");
        String payment_date = request.getParameter("payment_date");   

        Payment payment = new Payment(payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao");

        try{
            if(payment != null){
                session.setAttribute("payment", payment);
                paymentdao.updatePayment(paymentdao.getLastPaymentID(), payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
                request.getRequestDispatcher("updatePayment.jsp").include(request, response);
                response.sendRedirect("main.jsp");
                 
            } else {
                request.getRequestDispatcher("updatePayment.jsp").include(request, response);
            }
        } catch (SQLException e){
            Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }    
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Payment;
import au.edu.uts.project.dao.PaymentDao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Christie
 */

public class AddPaymentServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String payment_method = request.getParameter("Payment_method");
        String cardNumber = request.getParameter("Card_number");
        String expiryDate = request.getParameter("ExpiryDate");
        String securityCode = request.getParameter("SecurityCode");
        String nameOnCard = request.getParameter("NameOnCard");
        String payment_date = request.getParameter("Payment_date");     
         
        Payment payment = new Payment( payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao"); 

        try {
            if(payment != null){
                session.setAttribute("payment", payment);
                Integer order_ID = paymentdao.getOrderID();
                session.setAttribute("Order_ID", order_ID);
                paymentdao.addPayment(order_ID, payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
                Integer payment_ID = paymentdao.getLastPaymentID();
                session.setAttribute("payment_ID", payment_ID);
                request.getRequestDispatcher("addPayment.jsp").include(request, response);
                response.sendRedirect("confirmPayment.jsp");
            } else {
                request.getRequestDispatcher("order_list.jsp").include(request, response);
            }
        } catch ( SQLException e){
            Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

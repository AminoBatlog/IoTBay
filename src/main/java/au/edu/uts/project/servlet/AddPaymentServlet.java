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
        String paymentMethod = request.getParameter("paymentMethod");
        String cardNumber = request.getParameter("cardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String securityCode = request.getParameter("securityCode");
        String nameOnCard = request.getParameter("nameOnCard");
        String datePaid = request.getParameter("datePaid");     
         
        Payment payment = new Payment( paymentMethod, cardNumber, expiryDate, securityCode, nameOnCard, datePaid);
        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao"); 

        try {
            if(payment != null){
                session.setAttribute("payment", payment);
                Integer orderID = paymentdao.getOrderID();
                session.setAttribute("orderID", orderID);
                paymentdao.addPayment(orderID, paymentMethod, cardNumber, expiryDate, securityCode, nameOnCard, datePaid);
                Integer paymentID = paymentdao.getLastPaymentID();
                session.setAttribute("paymentID", paymentID);
                request.getRequestDispatcher("addPayment.jsp").include(request, response);
                response.sendRedirect("confirmPayment.jsp");
            } else {
                request.getRequestDispatcher("order.jsp").include(request, response);
            }
        } catch ( SQLException e){
            Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
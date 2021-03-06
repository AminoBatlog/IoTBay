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
@WebServlet(name = "UpdatePaymentServlet", value = "/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int paymentid = Integer.parseInt(request.getParameter("payment_id"));
        PaymentDao paymentdao = (PaymentDao) request.getSession().getAttribute("paymentdao");
        Payment payment = null;
        try {
            payment = paymentdao.getPayment(paymentid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("exist", payment);
        request.getRequestDispatcher("/updatePayment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String payment_method = request.getParameter("Payment_method");
//        String cardNumber = request.getParameter("Card_number");
//        String expiryDate = request.getParameter("ExpiryDate");
//        String securityCode = request.getParameter("SecurityCode");
//        String nameOnCard = request.getParameter("NameOnCard");
//        String payment_date = request.getParameter("Payment_date");
//
//        Payment payment = new Payment(payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
//        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao");
//
//        try{
//            if(payment != null){
//                session.setAttribute("payment", payment);
//                paymentdao.updatePayment(paymentdao.getLastPaymentID(), payment_method, cardNumber, expiryDate, securityCode, nameOnCard, payment_date);
//                request.getRequestDispatcher("updatePayment.jsp").include(request, response);
//                response.sendRedirect("main.jsp");
//
//            } else {
//                request.getRequestDispatcher("updatePayment.jsp").include(request, response);
//            }
//        } catch (SQLException e){
//            Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, e);
//        }
        PaymentDao paymentdao = (PaymentDao) request.getSession().getAttribute("paymentdao");
        Payment payment = new Payment();
        payment.setPaymentId(Integer.parseInt(request.getParameter("paymentid")));
        payment.setEmail(request.getParameter("email"));
        payment.setPaymentMethod(request.getParameter("paymentMethod"));
        payment.setCardNumber(Long.parseLong(request.getParameter("cardNumber")));
        payment.setExpiryDate(request.getParameter("expiryDate"));
        payment.setSecurityCode(request.getParameter("securityCode"));
        payment.setNameOnCard(request.getParameter("nameOnCard"));
        payment.setPaymentDate(request.getParameter("paymentdate"));
        try {
            paymentdao.updatePayment(payment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/CheckPaymentServlet?order_id=" + payment.getPaymentId() + "&price=" + request.getSession().getAttribute("current_price"));
    }
}

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
public class EditPaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer payment_ID = Integer.parseInt(request.getParameter("Payment_ID"));
        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao");
        Payment payment = null;
        try{
            payment = paymentdao.findByID(payment_ID);
            System.out.println(payment_ID);
            if(payment != null){
                session.setAttribute("payment", payment);
                request.getRequestDispatcher("confirm.jsp").include(request, response);
                response.sendRedirect("updatePayment.jsp");
            } else {
                System.out.println("No payment method found");
                request.getRequestDispatcher("updatePayment.jsp").include(request, response);
            }
        } catch (SQLException e) {
           System.out.println(e.getErrorCode());
        }
    }
    
}

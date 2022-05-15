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
@WebServlet(name = "DeletePaymentServlet", value = "/DeletePaymentServlet")
public class DeletePaymentServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer paymentid = Integer.parseInt(request.getParameter("payment_id"));
        PaymentDao paymentdao = (PaymentDao)session.getAttribute("paymentdao");
        
        Payment payment = null;
        try {
            paymentdao.deletePayment(paymentid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/CheckPaymentServlet?order_id=" + paymentid + "&price=" + request.getSession().getAttribute("current_price"));
    }
    
}

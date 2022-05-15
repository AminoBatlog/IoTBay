/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Payment;
import au.edu.uts.project.domain.Order;
import au.edu.uts.project.dao.PaymentDao;
import au.edu.uts.project.domain.Account;
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
@WebServlet(name = "CheckPaymentServlet", value = "/CheckPaymentServlet")
public class CheckPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer order_ID = Integer.parseInt(request.getParameter("order_id"));
        Double price = Double.parseDouble(request.getParameter("price"));

        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao");


        //try{
            if(order_ID != null){
                Account account = (Account) session.getAttribute("account");
                Payment payment = null;
                try {
                    payment = paymentdao.getPayment(order_ID);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("payment", payment);
                request.getSession().setAttribute("current_order_id", order_ID);
                request.getSession().setAttribute("current_price", price);

                request.getRequestDispatcher("/confirmPayment.jsp").forward(request, response);
            } else {

            }
        //} catch (SQLException e){
            //Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, e);
        //}
    }
}

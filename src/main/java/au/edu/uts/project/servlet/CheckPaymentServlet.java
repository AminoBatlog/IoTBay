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
public class CheckPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Integer payment_ID = Integer.parseInt(request.getParameter("Payment_ID"));
        Integer order_ID = Integer.parseInt((String) request.getAttribute("order_id"));
        Double price = Double.parseDouble((String) request.getAttribute("price"));
                
  
        //try{
            if(order_ID != null){
                Account account = (Account) session.getAttribute("account");
                request.setAttribute("Payment_ID", payment_ID);
                request.setAttribute("order_id", order_ID);
                request.setAttribute("price", price);
                response.sendRedirect("successful.jsp");
                 
            } else {
                request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
            }
        //} catch (SQLException e){
            //Logger.getLogger(EditPaymentServlet.class.getName()).log(Level.SEVERE, null, e);
        //}
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.Payment;
import au.edu.uts.project.dao.PaymentDao;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christie
 */
public class PaymentHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       HttpSession session = request.getSession();
       Account account = (Account) session.getAttribute("account");
       String email = account.getEmail();
       PaymentDao paymentdao = (PaymentDao)session.getAttribute("paymentdao");

        if(email != null){
            ArrayList<Payment> tempList = new ArrayList();
            try {
                tempList = paymentdao.getPayments(email);
            } catch (SQLException ex) {
                Logger.getLogger(PaymentHistoryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(tempList.size() > 0){
                request.setAttribute("paymentsList", tempList);
            }  else {
                request.setAttribute("msg", "There is no record of payments. Please add your Payment Details.");
            }
            request.getRequestDispatcher("/paymentHistory.jsp").forward(request, response);
           
        } else {

        }
    } 
}


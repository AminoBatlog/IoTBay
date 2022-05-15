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
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Christie
 */
public class SearchPaymentHistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        String email = account.getEmail();
        request.setAttribute("msg", "No result");
        request.getRequestDispatcher("/searchPaymentHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String email = account.getEmail();
        int id = 0;
        if(!"".equals(request.getParameter("id"))){
            id = Integer.parseInt(request.getParameter("id"));
        }
        String date = request.getParameter("date");
        PaymentDao paymentdao = (PaymentDao) session.getAttribute("paymentdao");
        System.out.println(id + date);
        
        List<Payment> list = null;
        try {
            list = paymentdao.findByIDandDATE(id, date, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(list != null && list.size() > 0){
            request.setAttribute("list", list );
            request.getRequestDispatcher("/searchPaymentHistory.jsp").include(request, response);
        } else {
            request.setAttribute("msg", "No payments found");
            request.getRequestDispatcher("/searchPaymentHistory.jsp").include(request, response);
        } 
    }  
}

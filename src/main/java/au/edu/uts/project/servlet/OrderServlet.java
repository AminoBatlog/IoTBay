/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.dao.daoImpl.OrderDaoImpl;
import au.edu.uts.project.domain.Order;
import au.edu.uts.project.service.OrderService;
import au.edu.uts.project.service.impl.OrderServiceImpl;
import au.edu.uts.project.utils.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FurryDesktop
 */
@WebServlet(name = "OrderServlet", value = "/OrderServlet")
public class OrderServlet extends HttpServlet {

    OrderService service = new OrderServiceImpl();

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("display") != null) {
            String email = request.getParameter("display");
            List<Order> list = service.getListByEmail(email);
            request.getSession().setAttribute("email", email);
            request.setAttribute("order_list", list);
            request.getRequestDispatcher("/order_list.jsp").forward(request, response);
        } else if(request.getParameter("delete") != null) {
            int result = service.removeOrder(Integer.parseInt(request.getParameter("delete")));
            request.getRequestDispatcher("/OrderServlet?display=" + request.getSession().getAttribute("email"));
        } else if(request.getParameter("fid") != null || request.getParameter("fdate") != null){
            String email = (String) request.getSession().getAttribute("email");
            int id = 0;
            if(!"".equals(request.getParameter("fid"))){
                id = Integer.parseInt(request.getParameter("fid"));
            }
            String date = request.getParameter("fdate");
            List<Order> list = service.filterList(email, id, date);
            request.setAttribute("order_list", list);
            request.getRequestDispatcher("/order_list.jsp").forward(request, response);
        } else if(request.getParameter("create") != null) {
            request.getRequestDispatcher("/order_add.jsp").forward(request, response);
        } else if(request.getParameter("status") != null && request.getParameter("orderId") != null) {
            int result = service.updateStatusById(request.getParameter("status"), Integer.parseInt(request.getParameter("orderId")));
            request.setAttribute("msg", "status successfully changed to " + request.getParameter("status") + " for order: " + request.getParameter("orderId"));
            if("false".equals(request.getParameter("total"))){
                request.getRequestDispatcher("/OrderServlet?display=" + request.getSession().getAttribute("email")).forward(request, response);
            } else {
                request.setAttribute("order_id", request.getParameter("orderId"));
                request.setAttribute("price", request.getParameter("total"));
                request.getRequestDispatcher("/ChekPaymentServlet").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // creation
        if(request.getParameter("id") == null) {
            Order order = new Order();
            // give a random number
            order.setOrderId(0);
            order.setEmail((String) request.getParameter("email"));
            order.setStatus((String) request.getParameter("status"));
            order.setDeliveryDate((String) request.getParameter("date"));
            order.setDeliveryTime((String) request.getParameter("time"));
            long result = service.createOrder(order);
            if(result > 0){
                request.setAttribute("id", result);
                request.getRequestDispatcher("/orderline_add.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/OrderServlet?display=" + order.getEmail());
            }

        } else if(request.getParameter("id") != null){
            Order order = new Order();
            order.setOrderId(Integer.parseInt(request.getParameter("id")));
            order.setEmail((String) request.getParameter("email"));
            order.setStatus((String) request.getParameter("status"));
            order.setDeliveryDate((String) request.getParameter("date"));
            order.setDeliveryTime((String) request.getParameter("time"));
            int result = service.updateOrder(order);
            if(result > 0){
                response.sendRedirect(request.getContextPath() + "/successful.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/fail.jsp");
            }
        }
    }


}

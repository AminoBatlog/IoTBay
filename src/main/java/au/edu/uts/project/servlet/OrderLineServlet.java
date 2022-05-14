package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Order;
import au.edu.uts.project.domain.OrderLine;
import au.edu.uts.project.service.OrderLineService;
import au.edu.uts.project.service.impl.OrderLineServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderLineServlet", value = "/OrderLineServlet")
public class OrderLineServlet extends HttpServlet {

    OrderLineService service = new OrderLineServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("display") != null) {
            request.getSession().removeAttribute("msg");
            List<OrderLine> list = service.getOrderLineById(Integer.parseInt(request.getParameter("display")));
            request.setAttribute("orderLine_list", list);
            request.setAttribute("orderId", request.getParameter("display"));
            request.getRequestDispatcher("/orderLine_list.jsp").forward(request, response);
        } else if(request.getParameter("delete") != null) {
            int orderId = Integer.parseInt(request.getParameter("orderid"));
            int devId = Integer.parseInt(request.getParameter("delete"));
            int result = service.removeOrderLine(orderId, devId);
            response.sendRedirect(request.getContextPath() + "/OrderLineServlet?display=" + String.valueOf(orderId));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderId(Integer.parseInt(request.getParameter("orderid")));
        orderLine.setDevId(Integer.parseInt(request.getParameter("devid")));
        orderLine.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        int result = service.createOrderLine(orderLine);
        if(result > 0){
            request.setAttribute("msg", "Add item successfully");
            request.setAttribute("id", request.getParameter("orderid"));
            request.getRequestDispatcher("/orderline_add.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Add item failed, maybe the item is not exist or is out of stock");
            request.setAttribute("id", request.getParameter("orderid"));
            request.getRequestDispatcher("/orderline_add.jsp").forward(request, response);
        }
    }
}

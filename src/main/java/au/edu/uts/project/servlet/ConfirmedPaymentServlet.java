package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.utils.OrderDaoSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ConfirmedPaymentServlet", value = "/ConfirmedPaymentServlet")
public class ConfirmedPaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = Integer.parseInt(req.getParameter("order_id"));
        OrderDao dao = OrderDaoSingleton.getInstance();
        try {
            dao.updateStatusById(orderId, "Finish");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Account account = (Account) req.getSession().getAttribute("account");
        resp.sendRedirect(req.getContextPath() + "/OrderServlet?display=" + account.getEmail());
    }
}

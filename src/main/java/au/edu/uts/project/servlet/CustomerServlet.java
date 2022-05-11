package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Customer;
import au.edu.uts.project.service.CustomerService;
import au.edu.uts.project.service.impl.CustomerServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    CustomerService service = new CustomerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("true".equals(request.getParameter("list"))){
            List<Customer> list = service.getList();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/customer_list.jsp").forward(request, response);
        } else if(request.getParameter("email") != null) {
            Customer customer = service.getCustomer((String)request.getParameter("email"));
            request.setAttribute("selected", customer);
            request.getRequestDispatcher("/customer_detail.jsp").forward(request, response);
        } else if("true".equals(request.getParameter("create"))){
            response.sendRedirect(request.getContextPath() + "/customer_add.jsp");
        } else if(request.getParameter("emailf") != null || request.getParameter("namef") != null) {
            String name = (String) request.getParameter("namef");
            String email = (String) request.getParameter("emailf");
            List<Customer> list = service.filterList(name, email);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/customer_list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Customer customer = new Customer();
        customer.setCustomerFname((String)request.getParameter("customer_fname"));
        customer.setCustomerLname((String)request.getParameter("customer_lname"));
        customer.setEmail((String)request.getParameter("email"));
        customer.setPassword((String)request.getParameter("password"));
        customer.setDob((String)request.getParameter("dob"));
        customer.setGender((String)request.getParameter("gender"));
        customer.setCustomerStreetno(Integer.parseInt(request.getParameter("customer_streetno")));
        customer.setCustomerStreetname((String)request.getParameter("customer_streetname"));
        customer.setCustomerCity((String)request.getParameter("customer_city"));
        customer.setCustomerZipcode(Integer.parseInt(request.getParameter("customer_zipcode")));
        customer.setCustomerCountry((String)request.getParameter("customer_country"));

        int result = 0;
        try {
            result = service.modifyCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result > 0){
            response.sendRedirect(request.getContextPath() + "/successful.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int result = service.deleteCustomer(id);
        if(result > 0){
            response.sendRedirect(request.getContextPath() + "/successful.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }
    }//destory
}

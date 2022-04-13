package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // The operation below is for assignment 1
        // extract the data from request
        String fname = (String)request.getParameter("fname");
        String lname = (String)request.getParameter("lname");
        String email = (String)request.getParameter("email");
        String username = (String)request.getParameter("username");
        String password = (String)request.getParameter("password");
        String gender = (String)request.getParameter("gender");
        String addressCountry = (String)request.getParameter("address_country");
        String addressState = (String)request.getParameter("address_state");
        String addressCity = (String)request.getParameter("address_city");
        String dob = (String)request.getParameter("dob");
        Account account = new Account(fname, lname, email, username, password, gender, addressCountry, addressState, addressCity, dob);
        HttpSession session = request.getSession(true);
        session.setAttribute("account", account);
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
}

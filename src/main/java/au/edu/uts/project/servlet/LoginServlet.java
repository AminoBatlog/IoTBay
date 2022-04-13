package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Account;
import au.edu.uts.project.service.AccountService;
import au.edu.uts.project.service.impl.AccountServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup the coding
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        // The validation below is for assignment 2

//        // extract the data from request
//        String username = (String)request.getParameter("username");
//        String password = (String)request.getParameter("password");
//
//         // validate the account
//        Integer result = accountService.login(account);
//        if(result != 100){
//            // if it is wrong
//            response.sendRedirect(request.getContextPath() + "/failed.jsp");
//        } else {
//            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
//        }
        // The validation below is for assignment 1
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        if(account != null && username.equals(account.getUsername()) && password.equals(account.getPassword())){
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
//            request.setAttribute("info", "no account");
//            request.getRequestDispatcher("/register.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }
    }}

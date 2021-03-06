package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.domain.Validator;
import au.edu.uts.project.service.StaffService;
import au.edu.uts.project.service.impl.StaffServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "StaffServlet", value = "/StaffServlet")
public class StaffServlet extends HttpServlet {

    StaffService service = new StaffServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if("true".equals(request.getParameter("list"))){
            // get staff list
            List<Staff> list = service.getList();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/staff_list.jsp").forward(request, response);
        } else if(request.getParameter("email") != null) {
            // get staff detail based on the email
            Staff staff = service.getStaff((String)request.getParameter("email"));
            request.setAttribute("selected", staff);
            request.getRequestDispatcher("/staff_detail.jsp").forward(request, response);
        } else if("true".equals(request.getParameter("create"))){
            // create staff
            response.sendRedirect(request.getContextPath() + "/staff_add.jsp");
        } else if(request.getParameter("emailf") != null || request.getParameter("namef") != null) {
            // filter staff list
            String name = (String) request.getParameter("namef");
            String email = (String) request.getParameter("emailf");
            List<Staff> list = service.filterList(name, email);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/staff_list.jsp").forward(request, response);
        } else if(request.getParameter("delete") != null) {
            // remove staff
            String email = (String) request.getParameter("delete");
            int result = service.removeStaff(email);
            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/StaffServlet?list=true");
            } else {
                response.sendRedirect(request.getContextPath() + "/fail.jsp");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup the coding
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Validator validator = new Validator();
        if(request.getAttribute("update") != null){
            boolean valid = true;
            if (!validator.validateEmail(request.getParameter("email"))){
                request.setAttribute("emailErr", "The format of email is incorrect");
                valid = false;
            }
            if (!validator.validatePassword(request.getParameter("password"))){
                request.setAttribute("passErr", "Password should have at least 4 digits");
                valid = false;
            }
            if(valid == false){
                request.getRequestDispatcher("/staff_add.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/StaffServlet?email=" + request.getAttribute("update")).forward(request, response);
            }
        }

        Staff staff = new Staff();
        staff.setStaffFname((String)request.getParameter("staff_fname"));
        staff.setStaffLname((String)request.getParameter("staff_lname"));
        staff.setEmail((String)request.getParameter("email"));
        staff.setPassword((String)request.getParameter("password"));
        staff.setDob((String)request.getParameter("dob"));
        staff.setGender((String)request.getParameter("gender"));
        staff.setStaffStreetno(Integer.parseInt(request.getParameter("staff_streetno")));
        staff.setStaffStreetname((String)request.getParameter("staff_streetname"));
        staff.setStaffCity((String)request.getParameter("staff_city"));
        staff.setStaffZipcode(Integer.parseInt(request.getParameter("staff_zipcode")));
        staff.setStaffCountry((String)request.getParameter("staff_country"));
        staff.setRoles((String)request.getParameter("roles"));
        staff.setStatus(true);
        int result = 0;
        try {
            result = service.modifyStaff(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result > 0){
            response.sendRedirect(request.getContextPath() + "/StaffServlet?list=true");
        } else {
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }
    }
}

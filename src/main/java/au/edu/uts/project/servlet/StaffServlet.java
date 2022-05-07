package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.service.StaffService;
import au.edu.uts.project.service.impl.StaffServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import static com.mysql.cj.MysqlType.JSON;

@WebServlet(name = "StaffServlet", value = "/StaffServlet")
public class StaffServlet extends HttpServlet {

    StaffService service = new StaffServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if the page and size exist
        if("true".equals(request.getParameter("list"))){
            // get staff list page and size
            List<Staff> list = service.getList();
            HttpSession session = request.getSession();
            session.setAttribute("staff_list", list);
            response.sendRedirect(request.getContextPath() + "/staff_list.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup the coding
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Staff staff = new Staff();
        staff.setStaffId(0);
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
        int result = service.addStaff(staff);
        if(result > 0){
            response.sendRedirect(request.getContextPath() + "/successful.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = new Staff();
        staff.setStaffId(Integer.parseInt(request.getParameter("id")));
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

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

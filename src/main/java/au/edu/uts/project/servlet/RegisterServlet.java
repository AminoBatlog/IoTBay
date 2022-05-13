package au.edu.uts.project.servlet;

import au.edu.uts.project.dao.DBManagerDAO;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.domain.Validator;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegisterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator valid = new Validator(); // Create a validator to check the email and password
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String gender = request.getParameter("gender");
        int addressStreetNo = Integer.parseInt(request.getParameter("address_streetNo"));
        String addressStreetName = request.getParameter("address_streetName");
        String addressCity = request.getParameter("address_city");
        int addressZipcode = Integer.parseInt(request.getParameter("address_zipcode"));
        String addressCountry = request.getParameter("address_country");
        String dob = request.getParameter("dob");
        String roles = request.getParameter("roles");
        DBManagerDAO manager = (DBManagerDAO) session.getAttribute("manager"); // Create a DB manager
        valid.clear(session); // Reset validation message

        if (!valid.validateEmail(email)) { // Check if the email is not inserted in the correct format and display error message
             session.setAttribute("emailErr", "Error: Email format is incorrect");
             request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!valid.validateName(fname) && !valid.validateName(lname)){ // Check if the first and last name are not inserted in the correct format and display error message
             session.setAttribute("nameErr", "Error: Name format is incorrect");
             request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!valid.validatePassword(pass)) { // Check if the password is not inserted in the correct format and display error message
             session.setAttribute("passErr", "Error: Password format is incorrect");
             request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
             try {
                  Account custExist = manager.checkUserEmail(email); // Check whether the Customer account already existed in the Customer DB from the given email
                  Staff staffExist = manager.checkStaffEmail(email); // Check whether the Staff account already existed in the Staff DB from the given email
                  if (custExist != null) { // If Customer account already existed in the Customer DB then display error message
                       session.setAttribute("existErr", "Account already exists in the database");
                       request.getRequestDispatcher("register.jsp").include(request, response);
                  } 
                  else if (staffExist != null) { // If Staff account already existed in the Staff DB then display error message
                       session.setAttribute("existErr", "Account already exists in the database");
                       request.getRequestDispatcher("staffRegister.jsp").include(request, response);
                  } 
                  else if (custExist == null && roles == null) { // If Customer account doesn't exist then create a new Customer account and add it into the Customer DB
                       manager.addUser(fname, lname, email, pass, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, dob);
                       Account account = new Account(fname, lname, email, pass, gender, addressStreetNo, addressStreetName, addressCountry, addressZipcode, addressCity, dob, true);
                       session.setAttribute("account", account);
                       request.getRequestDispatcher("welcome.jsp").include(request, response);
                  }
                  else if (staffExist == null && roles != null) { // If Staff account doesn't exist then create a new Staff account and add it into the Staff DB
                       manager.addStaff(fname, lname, email, pass, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, dob, roles);
                       Staff staff = new Staff(fname, lname, email, pass, dob, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, roles, true);
                       session.setAttribute("staff", staff);
                       request.getRequestDispatcher("welcomeStaff.jsp").include(request, response);
                  }
             } catch (SQLException | ParseException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

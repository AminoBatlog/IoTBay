<%@ page import="au.edu.uts.project.domain.Staff" %><%--
  Created by IntelliJ IDEA.
  User: FurryDesktop
  Date: 5/9/2022
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff information</title>
    <link rel="stylesheet" href="./dist/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="./assets/css/select.css">
    <link rel="stylesheet" href="./assets/css/style.css">
    <link rel="stylesheet" href="./assets/css/staff_page.css">
</head>
<body>
    <%
        Staff selected = (Staff)session.getAttribute("selected");
    %>
    <div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6" style="text-align: center">
                    <h2>Infomation of <% out.print(selected.getStaffFname() + " " + selected.getStaffLname()); %></h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="form" class="text-center login-register-main">
                        <span id="back-button"> &lsaquo;Back</span>
                        <form action="${pageContext.request.contextPath}/StaffServlet" method="post">
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_fname">First Name</label>
                                    <input name="staff_fname" type="text" id="staff_fname" value="<% out.print(selected.getStaffFname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_lname">Last Name</label>
                                    <input name="staff_lname" type="text" id="staff_lname" value="<% out.print(selected.getStaffLname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="email">Email Address</label>
                                    <input name="email" type="text" id="email" value="<% out.print(selected.getEmail()); %>" readonly>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input name="password" type="text" id="password" value="<% out.print(selected.getPassword()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="dob">Date of Birth</label>
                                    <input name="dob" type="date" id="dob" value="<% out.print(selected.getDob()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="gender">Gender</label>
                                    <select name="gender" id="gender" class="form-select">
                                        <option value="Male" <% if("Male".equals(selected.getGender())) out.print("selected"); %> >Male</option>
                                        <option value="Female" <% if("Female".equals(selected.getGender())) out.print("selected"); %> >Female</option>
                                        <option value="Other"<% if("Other".equals(selected.getGender())) out.print("selected"); %> >Other</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_streetno">Street Number</label>
                                    <input name="staff_streetno" type="text" id="staff_streetno" value="<% out.print(selected.getStaffStreetno()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_streetname">Street Name</label>
                                    <input name="staff_streetname" type="text" id="staff_streetname" value="<% out.print(selected.getStaffStreetname()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_city">City</label>
                                    <input name="staff_city" type="text" id="staff_city" value="<% out.print(selected.getStaffCity()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_zipcode">Zipcode</label>
                                    <input name="staff_zipcode" type="text" id="staff_zipcode" value="<% out.print(selected.getStaffZipcode()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="staff_country">Country</label>
                                    <input name="staff_country" type="text" id="staff_country" value="<% out.print(selected.getStaffCountry()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="roles">Staff Role</label>
                                    <input name="roles" type="text" id="roles" value="<% out.print(selected.getRoles()); %>">
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="status">Staff Status</label>
                                    <input name="status" type="checkbox" id="status" <% if(selected.isStatus()) out.print("checked"); %>>
                                </div>
                            </div>
                            <button type="submit" class="confirm-button">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="./dist/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="./dist/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="./assets/js/submission.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="./assets/js/validation.js"></script>
    <script type="text/javascript" src="./assets/js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="./assets/js/main.js"></script>
    <script type="text/javascript">
        $('#back-button').click(function (){
            window.location.href = '${pageContext.request.contextPath}/StaffServlet?list=true'
        })
    </script>
</body>
</html>

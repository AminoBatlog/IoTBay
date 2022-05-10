/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;

import au.edu.uts.project.domain.IotDev;
import au.edu.uts.project.service.IotDevService;
import au.edu.uts.project.service.impl.IotDevServiceImpl;
import com.sun.net.httpserver.Authenticator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kevin
 */
public class IotDevServlet extends HttpServlet {

    IotDevService iotService = new IotDevServiceImpl();
    IotDev iotDev = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        if (request.getParameter("list") != null)
        {
            List<IotDev> list = iotService.selectAllItem();
            if (list != null)
            {
                response.sendRedirect(request.getContextPath() + "/order.jsp");
                System.out.println("Servlet is successful");
            }
        }
         */
        String action = null;
        switch (request.getParameter(action)) {

            case "list":

                List<IotDev> list = iotService.selectAllItem();
                if (list != null) {
                    response.sendRedirect(request.getContextPath() + "/order.jsp");
                    System.out.println("Servlet is successful");
                }
                break;

            case "create":

                // if Staff.getEmail != null then create
                response.sendRedirect(request.getContextPath() + "/createDevice.jsp");
                System.out.println("Servlet is successful");
                break;

            case "delete":
                
                // if staff.getEmail != null
                String devID = request.getParameter("delete");
                // int deleteResult = IotDevService.deleteDevices(devID);
                // IotDevService.deleteDevices(devID);
                break;


            case "update":
                
                // if staff.getEmail != null
                // link the listed item and then put a button to call the update

            case "DevID":

                // staff and user can get the ID list without any permission
                // show ID list by calling the .getDevicesID
                
            case "DevName":
                
                // staff and user can get the name list without any additional permission
                // show Name list by calling the .getDevicesName

        }

    }

}

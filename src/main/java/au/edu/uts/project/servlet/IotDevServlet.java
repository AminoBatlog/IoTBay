/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package au.edu.uts.project.servlet;


import au.edu.uts.project.domain.IotDev;
import au.edu.uts.project.service.IotDevService;
import au.edu.uts.project.service.impl.IotDevServiceImpl;
import java.io.IOException;
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

        // Try to do the create here
        if (request.getParameter("devID") == null) 
        {
            
            int deviceID = 0;
            String deviceName = request.getParameter("deviceName");
            Double devicePrice = Double.parseDouble(request.getParameter("devicePrice"));
            int deviceQuantity = Integer.parseInt(request.getParameter("deviceQuantity"));
            
            IotDev iotdev = new IotDev(deviceID, deviceName, devicePrice, deviceQuantity);
            iotService.createDevices(iotdev);

            if (iotdev != null)
            {
                response.sendRedirect(request.getContextPath() + "/IotDevServlet?list=1");
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/fail.jsp");
            }
            
        }
        
        // Try to make the update here
        else if (request.getParameter("devID") != null) 
        {

            int deviceID = Integer.parseInt(request.getParameter("devID"));
            String deviceName = request.getParameter("deviceName");
            Double devicePrice = Double.parseDouble(request.getParameter("devicePrice"));
            int deviceQuantity = Integer.parseInt(request.getParameter("deviceQuantity"));
            
            IotDev iotdev = new IotDev(deviceID, deviceName, devicePrice, deviceQuantity);
            iotService.updateDevices(iotdev);
            
            if (iotdev != null)
            {
                System.out.println("update is successful");
                response.sendRedirect(request.getContextPath() + "/IotDevServlet?list=1");
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/fail.jsp");
            }
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("list") != null) {
            List<IotDev> list = iotService.selectAllItem();
            if (list != null) {
                request.setAttribute("list", list);
                request.getRequestDispatcher("/device.jsp").forward(request, response);
                // response.sendRedirect(request.getContextPath() + "/order.jsp");
                // System.out.println("Servlet is successful");
            }
        } 
        
        else if (request.getParameter("create") != null) {
            // if Staff.getEmail != null then create
            response.sendRedirect(request.getContextPath() + "/createDevice.jsp");
            // System.out.println("Servlet is successful");

        } 
        
        else if (request.getParameter("update") != null) {
            // if Staff.getEmail != null then create
            response.sendRedirect(request.getContextPath() + "/updateDevice.jsp");
            // System.out.println("Servlet is successful");

        } 
        
        else if (request.getParameter("delete") != null) {
            // if staff.getEmail != null
            int devID = Integer.parseInt(request.getParameter("delete"));
            iotService.deleteDevices(devID);
            response.sendRedirect(request.getContextPath() + "/device.jsp");
            // IotDevService.deleteDevices(devID);
        } 
        
        else if (request.getParameter("devID") != null) {
            IotDev iotDev = iotService.getDevicesID(Integer.parseInt(request.getParameter("devID")));
            System.out.println("your ID is being retrieved");

            if (iotDev == null) {
                System.out.println("fail");
                response.sendRedirect(request.getContextPath() + "/failed.jsp");
            } else {
                request.getRequestDispatcher("/updateDevice.jsp").forward(request, response);
            }
            // staff and user can get the ID list without any permission
            // show ID list by calling the .getDevicesID
        } 
        
        else if (request.getParameter("devName") != null) {
            IotDev iotDevName = iotService.getDevicesName((String) request.getParameter("devName"));
            System.out.println("your Name is being retrieved");
            if (iotDevName == null) {
                System.out.println("fail");
                response.sendRedirect(request.getContextPath() + "/failed.jsp");
            }
            // staff and user can get the name list without any additional permission
            // show Name list by calling the .getDevicesName
        }
        
    }

}

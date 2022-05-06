/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.domain;

import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.dao.daoImpl.StaffDaoImpl;
import au.edu.uts.project.entity.Staff;
import au.edu.uts.project.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class StaffMain {
    
public static void main(String[] args) throws SQLException {

// DatabaseConnection.getConnection();
//StaffDao dao = DatabaseConnection.getStaffDao();
StaffDao sdao = null;
sdao = new StaffDaoImpl(new DatabaseConnection().getConnection());



Staff staff = new Staff();
staff.setStaff_FName("Test");
}



}

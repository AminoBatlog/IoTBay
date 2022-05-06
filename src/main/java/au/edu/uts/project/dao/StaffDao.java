/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package au.edu.uts.project.dao;

import au.edu.uts.project.entity.Staff;
import au.edu.uts.project.entity.StaffException;
import java.util.*;

/**
 *
 * @author kevin
 */
public interface StaffDao {

    public void insertStaff(Staff staff) throws StaffException;

    public void updateStaff(Staff staff) throws StaffException;

    public void deleteStaff(int staff_ID) throws StaffException;

    public Staff getStaffID(int staff_ID) throws StaffException;

    public Staff getStaffEmail(String email) throws StaffException;

    public List<Staff> selectAllStaff() throws StaffException;

}

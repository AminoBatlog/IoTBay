package au.edu.uts.project.dao;

import au.edu.uts.project.domain.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffDao {

    List<Staff> getList() throws SQLException;

    int addStaff(Staff staff) throws SQLException;

    int updateStaff(Staff staff) throws SQLException;

    int removeStaff(String email) throws SQLException;

    boolean isExistStaff(String email) throws SQLException;

    Staff selectStaffByEmail(String email) throws SQLException;

    List<Staff> filterList(String name, String email) throws SQLException;

}

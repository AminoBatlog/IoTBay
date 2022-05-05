package au.edu.uts.project.dao;

import au.edu.uts.project.domain.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffDao {

    List<Staff> getList() throws SQLException;

    int addStaff(Staff staff) throws SQLException;

}

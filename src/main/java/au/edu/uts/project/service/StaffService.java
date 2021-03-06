package au.edu.uts.project.service;

import au.edu.uts.project.domain.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffService {

    List<Staff> getList();

    int addStaff(Staff staff);

    int updateStaff(Staff staff);

    int modifyStaff(Staff staff) throws SQLException;

    int removeStaff(String email);

    Staff getStaff(String email);

    List<Staff> filterList(String name, String email);
}

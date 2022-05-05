package au.edu.uts.project.service;

import au.edu.uts.project.domain.Staff;

import java.util.List;

public interface StaffService {

    List<Staff> getList();

    int addStaff(Staff staff);
}

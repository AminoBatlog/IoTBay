package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.dao.daoImpl.StaffDaoImpl;
import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.service.StaffService;
import au.edu.uts.project.utils.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;

public class StaffServiceImpl implements StaffService {

    StaffDao dao = new StaffDaoImpl(new DatabaseConnection().getConnection());

    /**
     * get staff list
     * @return
     */
    @Override
    public List<Staff> getList() {
        List<Staff> list = null;
        try {
            list = dao.getList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * add staff info
     * @param staff
     * @return
     */
    @Override
    public int addStaff(Staff staff) {
        int result = 0;
        try {
            result = dao.addStaff(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * update staff information
     * @param staff
     * @return
     */
    @Override
    public int updateStaff(Staff staff) {
        int result = 0;
        try {
            result = dao.updateStaff(staff);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyStaff(Staff staff) throws SQLException {
        boolean isExist = dao.isExistStaff(staff.getEmail());
        int result = 0;
        if(isExist){
            result = dao.updateStaff(staff);
        } else {
            result = dao.addStaff(staff);
        }
        return result;
    }

    /**
     * remove staff information
     * @param email
     * @return
     */
    @Override
    public int removeStaff(String email) {
        int result = 0;
        try {
            result = dao.removeStaff(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Staff getStaff(String email) {
        Staff staff = null;
        try {
            staff = dao.selectStaffByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public List<Staff> filterList(String name, String email) {
        List<Staff> list = null;
        try {
            list = dao.filterList(name, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

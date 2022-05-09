package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.dao.daoImpl.StaffDaoImpl;
import au.edu.uts.project.domain.Staff;
import au.edu.uts.project.service.StaffService;
import au.edu.uts.project.utils.DatabaseConnection;
import au.edu.uts.project.utils.StaffDaoSingleton;

import java.sql.SQLException;
import java.util.List;

public class StaffServiceImpl implements StaffService {

    /**
     * get staff list
     * @return
     */
    @Override
    public List<Staff> getList() {
        StaffDao dao = StaffDaoSingleton.getInstance();
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
        StaffDao dao = StaffDaoSingleton.getInstance();
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
        StaffDao dao = StaffDaoSingleton.getInstance();
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
        StaffDao dao = StaffDaoSingleton.getInstance();
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
     * @param id
     * @return
     */
    @Override
    public int removeStaff(int id) {
        StaffDao dao = StaffDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.removeStaff(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Staff getStaff(String email) {
        StaffDao dao = StaffDaoSingleton.getInstance();
        Staff staff = null;
        try {
            staff = dao.selectStaffByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }
}

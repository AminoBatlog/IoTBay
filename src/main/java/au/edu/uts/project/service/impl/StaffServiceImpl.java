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
//        StaffDao dao = new StaffDaoImpl(new DatabaseConnection().getConnection());
        return 0;
    }
}

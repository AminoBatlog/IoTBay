package au.edu.uts.project.utils;

import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.dao.daoImpl.StaffDaoImpl;

import java.sql.SQLException;

public class StaffDaoSingleton {

    // first, have a static variable
    private static StaffDao dao = null;

    // second, make the constructor private to make sure nobody could new object for it
    private StaffDaoSingleton() {

    }

    // eventually, have a public method to get the dao
    public static StaffDao getInstance() {
        if(dao == null) {
            try {
                dao = new StaffDaoImpl(new DatabaseConnection().getConnection());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

}

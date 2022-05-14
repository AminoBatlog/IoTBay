package au.edu.uts.project.utils;

import au.edu.uts.project.dao.OrderLineDao;
import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.dao.daoImpl.OrderLineDaoImpl;
import au.edu.uts.project.dao.daoImpl.StaffDaoImpl;

import java.sql.SQLException;

public class OrderLineSingleton {

    // first, have a static variable
    private static OrderLineDao dao = null;

    // second, make the constructor private to make sure nobody could new object for it
    private OrderLineSingleton() {

    }

    // eventually, have a public method to get the dao
    public static OrderLineDao getInstance() {
        if(dao == null) {
            try {
                dao = new OrderLineDaoImpl(new DatabaseConnection().getConnection());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

}

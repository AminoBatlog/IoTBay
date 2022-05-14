package au.edu.uts.project.utils;

import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.dao.daoImpl.OrderDaoImpl;
import au.edu.uts.project.dao.daoImpl.StaffDaoImpl;
import au.edu.uts.project.domain.Order;

import java.sql.SQLException;

public class OrderDaoSingleton {

    // first, have a static variable
    private static OrderDao dao = null;

    // second, make the constructor private to make sure nobody could new object for it
    private OrderDaoSingleton() {

    }

    // eventually, have a public method to get the dao
    public static OrderDao getInstance() {
        if(dao == null) {
            try {
                dao = new OrderDaoImpl(new DatabaseConnection().getConnection());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

}

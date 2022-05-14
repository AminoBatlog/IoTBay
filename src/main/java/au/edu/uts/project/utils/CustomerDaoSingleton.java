package au.edu.uts.project.utils;

import au.edu.uts.project.dao.CustomerDao;
import au.edu.uts.project.dao.daoImpl.CustomerDaoImpl;
import au.edu.uts.project.dao.daoImpl.OrderDaoImpl;
import java.sql.SQLException;

public class CustomerDaoSingleton {

    // first, have a static variable
    private static CustomerDao dao = null;

    // second, make the constructor private to make sure nobody could new object for it
    private CustomerDaoSingleton() {

    }

    // eventually, have a public method to get the dao
    public static CustomerDao getInstance() {
        if(dao == null) {
            try {
                dao = new CustomerDaoImpl(new DatabaseConnection().getConnection());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

}
package au.edu.uts.project.utils;

import au.edu.uts.project.dao.IotDevDao;
import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.dao.daoImpl.IotDevDaoImpl;
import au.edu.uts.project.dao.daoImpl.OrderDaoImpl;

import java.sql.SQLException;

public class IotDevDaoSingleton {

    // first, have a static variable
    private static IotDevDao dao = null;

    // second, make the constructor private to make sure nobody could new object for it
    private IotDevDaoSingleton() {

    }

    // eventually, have a public method to get the dao
    public static IotDevDao getInstance() {
        if(dao == null) {
            try {
                dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

}

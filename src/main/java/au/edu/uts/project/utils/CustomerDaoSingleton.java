package au.edu.uts.project.utils;

import au.edu.uts.project.dao.CustomerDao;
import au.edu.uts.project.dao.daoImpl.CustomerDaoImpl;

public class CustomerDaoSingleton {

    // first, have a static variable
    private static CustomerDao dao = null;

    // second, make the constructor private to make sure nobody could new object for it
    private CustomerDaoSingleton() {

    }

    // eventually, have a public method to get the dao
    public static CustomerDao getInstance() {
        if(dao == null) {
            dao = new CustomerDaoImpl(new DatabaseConnection().getConnection());
        }
        return dao;
    }

}
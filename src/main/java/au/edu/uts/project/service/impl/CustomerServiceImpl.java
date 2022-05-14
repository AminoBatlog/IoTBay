package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.CustomerDao;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.service.CustomerService;
import au.edu.uts.project.utils.CustomerDaoSingleton;
import java.sql.SQLException;
import java.util.List;
//
public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Account> getList() {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        List<Account> list = null;
        try {
            list = dao.getList();
        } catch (SQLException e) {
            e.printStackTrace();
        } return list;
    }

    @Override
    public int addCustomer(Account customer) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.addCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } return result;
    }

    @Override
    public int updateCustomer(Account customer) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyCustomer(Account customer) throws SQLException {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        boolean isExist = dao.isExistCustomer(customer.getEmail());
        int result = 0;
        if(isExist){
            result = dao.updateCustomer(customer);
        } else {
            result = dao.addCustomer(customer);
        }
        return result;
    }
    
    @Override
    public int deleteCustomer(String email) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.deleteCustomer(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Account getCustomer(String email) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        Account customer = null;
        try {
            customer = dao.selectCustomerByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Account> filterList(String name, String email) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        List<Account> list = null;
        try {
            list = dao.filterList(name, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
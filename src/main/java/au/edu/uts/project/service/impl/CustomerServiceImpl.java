package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.CustomerDao;
import au.edu.uts.project.domain.Customer;
import au.edu.uts.project.service.CustomerService;
import au.edu.uts.project.utils.CustomerDaoSingleton;
import java.sql.SQLException;
import java.util.List;
//
public class CustomerServiceImpl implements CustomerService {

    public List<Customer> getList() {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        List<Customer> list = null;
        try {
            list = dao.getList();
        } catch (SQLException e) {
            e.printStackTrace();
        } return list;
    }

    public int addCustomer(Customer customer) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.addCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        } return result;
    }

    public int updateCustomer(Customer customer) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.updateCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int modifyCustomer(Customer customer) throws SQLException {
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
    
    public int deleteCustomer(int id) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Customer getCustomer(String email) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        Customer customer = null;
        try {
            customer = dao.selectCustomerByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> filterList(String name, String email) {
        CustomerDao dao = CustomerDaoSingleton.getInstance();
        List<Customer> list = null;
        try {
            list = dao.filterList(name, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
package au.edu.uts.project.dao;

import au.edu.uts.project.domain.Customer;
import java.sql.SQLException;
import java.util.List;
        
public interface CustomerDao {

    /**
     *
     * @return
     * @throws SQLException
     */
    List<Customer> getList() throws SQLException;

    int addCustomer(Customer customer) throws SQLException;

    int updateCustomer(Customer customer) throws SQLException;

    int deleteCustomer(int id) throws SQLException;

    boolean isExistCustomer(String email) throws SQLException;

    Customer selectCustomerByEmail(String email) throws SQLException;

    List<Customer> filterList(String name, String email) throws SQLException;

}
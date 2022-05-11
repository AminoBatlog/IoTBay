package au.edu.uts.project.service;

import au.edu.uts.project.domain.Customer;
import java.sql.SQLException;
import java.util.List;
//
public interface CustomerService {
    List<Customer> getList();

    int addCustomer(Customer staff);

    int updateCustomer(Customer staff);

    int deleteCustomer(int id);
    
    int modifyCustomer(Customer customer) throws SQLException;

    Customer getCustomer(String email);

    List<Customer> filterList(String name, String email);
}
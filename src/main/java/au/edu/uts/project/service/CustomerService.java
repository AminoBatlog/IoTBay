package au.edu.uts.project.service;

import au.edu.uts.project.domain.Account;
import java.sql.SQLException;
import java.util.List;
//
public interface CustomerService {
    List<Account> getList();

    int addCustomer(Account cust);

    int updateCustomer(Account cust);

    int deleteCustomer(String email);
    
    int modifyCustomer(Account cust) throws SQLException;

    Account getCustomer(String email);

    List<Account> filterList(String name, String email);
}
package au.edu.uts.project.dao;

import au.edu.uts.project.domain.Account;
import java.sql.SQLException;
import java.util.List;
        
public interface CustomerDao {

    /**
     *
     * @return
     * @throws SQLException
     */
    List<Account> getList() throws SQLException;

    int addCustomer(Account customer) throws SQLException;

    int updateCustomer(Account customer) throws SQLException;

    int deleteCustomer(String email) throws SQLException;

    boolean isExistCustomer(String email) throws SQLException;

    Account selectCustomerByEmail(String email) throws SQLException;

    List<Account> filterList(String name, String email) throws SQLException;

}
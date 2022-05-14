package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.CustomerDao;
import au.edu.uts.project.domain.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private Connection connection = null;
    private PreparedStatement pst = null;

    public CustomerDaoImpl(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Account> getList() throws SQLException {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        this.pst = this.connection.prepareStatement(sql);
        ResultSet result = this.pst.executeQuery();
        while(result.next()){
            Account customer = new Account();
            customer.setFname(result.getString("cust_fname"));
            customer.setLname(result.getString("cust_lname"));
            customer.setEmail(result.getString("email"));
            customer.setPassword(result.getString("password"));
            customer.setDob(result.getString("dob"));
            customer.setGender(result.getString("gender"));
            customer.setAddressStreetNo(result.getInt("cust_streetno"));
            customer.setAddressStreetName(result.getString("cust_streetname"));
            customer.setAddressCity(result.getString("cust_city"));
            customer.setAddressZipcode(result.getInt("cust_zipcode"));
            customer.setAddressCountry(result.getString("cust_country"));
            customer.setStatus(result.getBoolean("status"));
            list.add(customer);
        }
        this.pst.close();
        return list;
    }
    
    @Override
    public int addCustomer(Account customer) throws SQLException {
        String sql = "INSERT INTO Customer (CUST_FNAME, CUST_LNAME, EMAIL, PASSWORD, DOB, GENDER, CUST_STREETNO,"
        + "CUST_STREETNAME, CUST_CITY, CUST_ZIPCODE, CUST_COUNTRY, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, customer.getFname());
        this.pst.setString(2, customer.getLname());
        this.pst.setString(3, customer.getEmail());
        this.pst.setString(4, customer.getPassword());
        this.pst.setString(5, customer.getDob());
        this.pst.setString(6, customer.getGender());
        this.pst.setInt(7, customer.getAddressStreetNo());
        this.pst.setString(8, customer.getAddressStreetName());
        this.pst.setString(9, customer.getAddressCity());
        this.pst.setInt(10, customer.getAddressZipcode());
        this.pst.setString(11, customer.getAddressCountry());
        this.pst.setBoolean(12, customer.isStatus());
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }
//Add a user-data into the database   
//public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException 


    @Override
    public int updateCustomer(Account customer) throws SQLException {
        String sql = "INSERT INTO Customer (CUST_FNAME, CUST_LNAME, EMAIL, PASSWORD, DOB, GENDER, CUST_STREETNO,"
        + "CUST_STREETNAME, CUST_CITY, CUST_ZIPCODE, CUST_COUNTRY, STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, customer.getFname());
        this.pst.setString(2, customer.getLname());
        this.pst.setString(3, customer.getEmail());
        this.pst.setString(4, customer.getPassword());
        this.pst.setString(5, customer.getDob());
        this.pst.setString(6, customer.getGender());
        this.pst.setInt(7, customer.getAddressStreetNo());
        this.pst.setString(8, customer.getAddressStreetName());
        this.pst.setString(9, customer.getAddressCity());
        this.pst.setInt(10, customer.getAddressZipcode());
        this.pst.setString(11, customer.getAddressCountry());
        this.pst.setBoolean(12, customer.isStatus());
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }
//update a user details in the database   
//public void updateUser( String email, String name, String password, String gender, String favcol) throws SQLException     
//code for update-operation  
    @Override
    public int deleteCustomer(String email) throws SQLException {
        String sql = "DELETE FROM Customer WHERE email=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, email);
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }
//delete a user from the database   
//public void deleteUser(String email) throws SQLException{       
//code for delete-operation 
    @Override 
    public boolean isExistCustomer(String email) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE email=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, email);
        ResultSet result = this.pst.executeQuery();
        boolean isExist = false;
        while(result.next()){
            isExist = true;
        }
        return isExist;
    }
//delete a user from the database   
//public void deleteUser(String email) throws SQLException{       
//code for delete-operation  
    @Override
    public Account selectCustomerByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE email=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, email);
        ResultSet result = this.pst.executeQuery();
        Account customer = null;
        while(result.next()){
            customer = new Account();
            customer.setFname(result.getString("cust_fname"));
            customer.setLname(result.getString("cust_lname"));
            customer.setEmail(result.getString("email"));
            customer.setPassword(result.getString("password"));
            customer.setDob(result.getString("dob"));
            customer.setGender(result.getString("gender"));
            customer.setAddressStreetNo(result.getInt("cust_streetno"));
            customer.setAddressStreetName(result.getString("cust_streetname"));
            customer.setAddressCity(result.getString("cust_city"));
            customer.setAddressZipcode(result.getInt("cust_zipcode"));
            customer.setAddressCountry(result.getString("cust_country"));
            customer.setStatus(result.getBoolean("status"));
        }
        return customer;
    }
//
    @Override
    public List<Account> filterList(String name, String email) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE email LIKE ? AND (Customer_fname LIKE ? OR Customer_lname LIKE ?)";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, "%" + email + "%");
        this.pst.setString(2, "%" + name + "%");
        this.pst.setString(3, "%" + name + "%");
        ResultSet result = this.pst.executeQuery();
        List<Account> list = new ArrayList<>();
        while(result.next()){
            Account customer = new Account();
            customer.setFname(result.getString("cust_fname"));
            customer.setLname(result.getString("cust_lname"));
            customer.setEmail(result.getString("email"));
            customer.setPassword(result.getString("password"));
            customer.setDob(result.getString("dob"));
            customer.setGender(result.getString("gender"));
            customer.setAddressStreetNo(result.getInt("cust_streetno"));
            customer.setAddressStreetName(result.getString("cust_streetname"));
            customer.setAddressCity(result.getString("cust_city"));
            customer.setAddressZipcode(result.getInt("cust_zipcode"));
            customer.setAddressCountry(result.getString("cust_country"));
            customer.setStatus(result.getBoolean("status"));
            list.add(customer);
        }
        return list;
    }
}

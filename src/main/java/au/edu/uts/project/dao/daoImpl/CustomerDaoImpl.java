package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.CustomerDao;
import au.edu.uts.project.domain.Customer;
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
    public List<Customer> getList() throws SQLException {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        this.pst = this.connection.prepareStatement(sql);
        ResultSet result = this.pst.executeQuery();
        while(result.next()){
            Customer customer = new Customer();
            customer.setCustomerFname(result.getString("customer_fname"));
            customer.setCustomerLname(result.getString("customer_lname"));
            customer.setEmail(result.getString("email"));
            customer.setPassword(result.getString("password"));
            customer.setDob(result.getString("dob"));
            customer.setGender(result.getString("gender"));
            customer.setCustomerStreetno(result.getInt("customer_streetno"));
            customer.setCustomerStreetname(result.getString("customer_streetname"));
            customer.setCustomerCity(result.getString("customer_city"));
            customer.setCustomerZipcode(result.getInt("customer_zipcode"));
            customer.setCustomerCountry(result.getString("customer_country"));
            customer.setType(result.getString("type"));
            list.add(customer);
        }
        this.pst.close();
        return list;
    }
    
    public int addCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customer (Customer_FName, Customer_LName, Email, Password, DOB, Gender, Customer_streetNo, Customer_streetName, Customer_city, Customer_zipcode, Customer_country, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, customer.getCustomerFname());
        this.pst.setString(2, customer.getCustomerLname());
        this.pst.setString(3, customer.getEmail());
        this.pst.setString(4, customer.getPassword());
        this.pst.setString(5, customer.getDob());
        this.pst.setString(6, customer.getGender());
        this.pst.setInt(7, customer.getCustomerStreetno());
        this.pst.setString(8, customer.getCustomerStreetname());
        this.pst.setString(9, customer.getCustomerCity());
        this.pst.setInt(10, customer.getCustomerZipcode());
        this.pst.setString(11, customer.getCustomerCountry());
        this.pst.setString(1, customer.getType());
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }
//Add a user-data into the database   
//public void addUser(String email, String name, String password, String gender, String favcol) throws SQLException 



    public int updateCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO Customer (Customer_FName, Customer_LName, Email, Password, DOB, Gender, Customer_streetNo, Customer_streetName, Customer_city, Customer_zipcode, Customer_country, Type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, customer.getCustomerFname());
        this.pst.setString(2, customer.getCustomerLname());
        this.pst.setString(3, customer.getEmail());
        this.pst.setString(4, customer.getPassword());
        this.pst.setString(5, customer.getDob());
        this.pst.setString(6, customer.getGender());
        this.pst.setInt(7, customer.getCustomerStreetno());
        this.pst.setString(8, customer.getCustomerStreetname());
        this.pst.setString(9, customer.getCustomerCity());
        this.pst.setInt(10, customer.getCustomerZipcode());
        this.pst.setString(11, customer.getCustomerCountry());
        this.pst.setString(11, customer.getType());
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }
//update a user details in the database   
//public void updateUser( String email, String name, String password, String gender, String favcol) throws SQLException     
//code for update-operation  
    public int deleteCustomer(int id) throws SQLException {
        String sql = "DELETE FROM Customer WHERE Customer_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setInt(1, id);
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }
//delete a user from the database   
//public void deleteUser(String email) throws SQLException{       
//code for delete-operation  
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
    public Customer selectCustomerByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE email=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, email);
        ResultSet result = this.pst.executeQuery();
        Customer customer = null;
        while(result.next()){
            customer = new Customer();
            customer.setCustomerFname(result.getString("customer_fname"));
            customer.setCustomerLname(result.getString("customer_lname"));
            customer.setEmail(result.getString("email"));
            customer.setPassword(result.getString("password"));
            customer.setDob(result.getString("dob"));
            customer.setGender(result.getString("gender"));
            customer.setCustomerStreetno(result.getInt("customer_streetno"));
            customer.setCustomerStreetname(result.getString("customer_streetname"));
            customer.setCustomerCity(result.getString("customer_city"));
            customer.setCustomerZipcode(result.getInt("customer_zipcode"));
            customer.setCustomerCountry(result.getString("customer_country"));
            customer.setType(result.getString("customer_type"));
        }
        return customer;
    }
//
    public List<Customer> filterList(String name, String email) throws SQLException {
        String sql = "SELECT * FROM Customer WHERE email LIKE ? AND (Customer_fname LIKE ? OR Customer_lname LIKE ?)";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, "%" + email + "%");
        this.pst.setString(2, "%" + name + "%");
        this.pst.setString(3, "%" + name + "%");
        ResultSet result = this.pst.executeQuery();
        List<Customer> list = new ArrayList<>();
        while(result.next()){
            Customer customer = new Customer();
            customer.setCustomerFname(result.getString("customer_fname"));
            customer.setCustomerLname(result.getString("customer_lname"));
            customer.setEmail(result.getString("email"));
            customer.setPassword(result.getString("password"));
            customer.setDob(result.getString("dob"));
            customer.setGender(result.getString("gender"));
            customer.setCustomerStreetno(result.getInt("customer_streetno"));
            customer.setCustomerStreetname(result.getString("customer_streetname"));
            customer.setCustomerCity(result.getString("customer_city"));
            customer.setCustomerZipcode(result.getInt("customer_zipcode"));
            customer.setCustomerCountry(result.getString("customer_country"));
            customer.setType(result.getString("customer_type"));
            list.add(customer);
        }
        return list;
    }
}

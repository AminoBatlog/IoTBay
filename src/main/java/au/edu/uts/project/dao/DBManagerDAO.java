/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.dao;
import java.sql.*;
import au.edu.uts.project.domain.Account;
import au.edu.uts.project.domain.AccountAccess;
import au.edu.uts.project.domain.Staff;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author weichen
 */
public class DBManagerDAO {
  private PreparedStatement st;
  private final Connection conn;
  
  public DBManagerDAO(Connection conn) throws SQLException {       
     st = null; 
     this.conn = conn;  
  }
   
    public Account checkUserEmail(String email) throws SQLException {
        String sql = "SELECT * FROM USERTEST.CUSTOMER WHERE EMAIL = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, email);

        ResultSet result = this.st.executeQuery();
        
        while(result.next()){
            String userEmail = result.getString(3);
            if (userEmail.equals(email)) {
               String fName = result.getString(1);
               String lName = result.getString(2);
               String pass = result.getString(4);
               String dob = result.getString(5);
               String gender = result.getString(6);
               int addressStreetNo = result.getInt(7);
               String addressStreetName = result.getString(8);
               String addressCity = result.getString(9);
               int addressZipcode = result.getInt(10);
               String addressCountry = result.getString(11);
               boolean status = result.getBoolean(12);
            
               return new Account(fName, lName, userEmail, pass, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, dob, status);
          }

        }
        // return the result
        return null;
    }

 
    public Account findUser(String email, String pass) throws SQLException {
        String sql = "SELECT * FROM USERTEST.CUSTOMER WHERE EMAIL = ? AND PASSWORD = ?";

        // get the result after execute the query
        st = conn.prepareStatement(sql);
        st.setString(1, email);
        st.setString(2, pass);

        ResultSet result = this.st.executeQuery();
        // if the result is not finished(normally we only have one result here)
        while(result.next()){
            String userEmail = result.getString(3);
            String userPass = result.getString(4);
            if (userEmail.equals(email) && userPass.equals(pass)) {
               String fName = result.getString(1);
               String lName = result.getString(2);
               String dob = result.getString(5);
               String gender = result.getString(6);
               int addressStreetNo = result.getInt(7);
               String addressStreetName = result.getString(8);
               String addressCity = result.getString(9);
               int addressZipcode = result.getInt(10);
               String addressCountry = result.getString(11);
               boolean status = result.getBoolean(12);
            
               return new Account(fName, lName, userEmail, userPass, gender, addressStreetNo, addressStreetName, addressCity, addressZipcode, addressCountry, dob, status);
          }

        }
        // return the result
        return null;
    }

    public void addUser(String fName, String lName, String email, String pass, String gender, int addressStreetNo, String addressStreetName, String addressCity, int addressZipcode, String addressCountry, String dob) throws SQLException, ParseException {
        String sql = "INSERT INTO USERTEST.CUSTOMER (CUST_FNAME, CUST_LNAME, EMAIL, PASSWORD, DOB, GENDER, CUST_STREETNO,"
        + "CUST_STREETNAME, CUST_CITY, CUST_ZIPCODE, CUST_COUNTRY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        st = conn.prepareStatement(sql);
        st.setString(1, fName);
        st.setString(2, lName);
        st.setString(3, email);
        st.setString(4, pass);
        st.setString(5, dob);
        st.setString(6, gender);
        st.setInt(7, addressStreetNo);
        st.setString(8, addressStreetName);
        st.setString(9, addressCity);
        st.setInt(10, addressZipcode);
        st.setString(11, addressCountry);
        
        this.st.executeUpdate();

    }

    public void updateUser(String fName, String lName, String email, String pass, String gender, int addressStreetNo, String addressStreetName, String addressCity, int addressZipcode, String addressCountry, String dob) throws SQLException {
       String sql = "UPDATE USERTEST.CUSTOMER SET CUST_FNAME = ?, CUST_LNAME = ?, PASSWORD = ?, DOB = ?, "
       + "GENDER = ?, CUST_STREETNO = ?, CUST_STREETNAME = ?, CUST_CITY = ?, CUST_ZIPCODE = ?, CUST_COUNTRY = ? "
       + "WHERE EMAIL = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, fName);
        st.setString(2, lName);
        st.setString(3, pass);
        st.setString(4, dob);
        st.setString(5, gender);
        st.setInt(6, addressStreetNo);
        st.setString(7, addressStreetName);
        st.setString(8, addressCity);
        st.setInt(9, addressZipcode);
        st.setString(10, addressCountry);
        st.setString(11, email);

        this.st.executeUpdate();

    } 
    
    public void cancelUser(String email) throws SQLException {
       String sql = "UPDATE USERTEST.CUSTOMER SET STATUS = ? WHERE EMAIL = ?";
       st = conn.prepareStatement(sql);
       st.setBoolean(1, false);
       st.setString(2, email);

       this.st.executeUpdate();
    }

    public void addAccess(String email, String inDate, String inTime) throws SQLException {
       String sql = "INSERT INTO USERTEST.ACCESS (EMAIL, INDATE, INTIME) VALUES (?, ?, ?)";
       st = conn.prepareStatement(sql);
       st.setString(1, email);
       st.setString(2, inDate);
       st.setString(3, inTime);

       this.st.executeUpdate();

    }


    public void updateLogout(String email, String outDate, String outTime) throws SQLException {
         String sql = "UPDATE USERTEST.ACCESS SET OUTDATE = ?, OUTTIME = ? WHERE EMAIL = ? AND OUTDATE IS NULL";
         
         st = conn.prepareStatement(sql);
         st.setString(1, outDate);
         st.setString(2, outTime);
         st.setString(3, email);
         
         this.st.executeUpdate();
    }

    public ArrayList<AccountAccess> listAccess(String email) throws SQLException {
      
      ArrayList<AccountAccess> list = new ArrayList<>();
      String sql = "SELECT * FROM USERTEST.ACCESS WHERE EMAIL = ?";
      st = conn.prepareStatement(sql);
      st.setString(1, email);
      ResultSet result = this.st.executeQuery();

      while(result.next()) {
         AccountAccess access = new AccountAccess();
         access.setEmail(result.getString("email"));
         access.setInDate(result.getString("indate"));
         access.setInTime(result.getString("intime"));
         access.setOutDate(result.getString("outdate"));
         access.setOutTime(result.getString("outtime"));
         list.add(access);
      }
      return list;
    }

    public ArrayList<AccountAccess> listByDate(String email, String loginDate) throws SQLException {
      
      ArrayList<AccountAccess> list = new ArrayList<>();
      String sql = "SELECT * FROM USERTEST.ACCESS WHERE EMAIL = ? AND INDATE = ?";
      st = conn.prepareStatement(sql);
      st.setString(1, email);
      st.setString(2, loginDate);
      ResultSet result = this.st.executeQuery();

      while(result.next()) {
         AccountAccess access = new AccountAccess();
         access.setEmail(result.getString("email"));
         access.setInDate(result.getString("indate"));
         access.setInTime(result.getString("intime"));
         access.setOutDate(result.getString("outdate"));
         access.setOutTime(result.getString("outtime"));
         list.add(access);
      }
      return list;
    }

    public boolean checkAccess(String email, String loginDate) throws SQLException {
        String sql = "SELECT * FROM USERTEST.ACCESS WHERE EMAIL = ? AND INDATE = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, email);
        st.setString(2, loginDate);

        ResultSet result = this.st.executeQuery();
        
        while (result.next()) {
            String userEmail = result.getString("email");
            String inDate = result.getString("indate");
            if (userEmail.equals(email) && inDate.equals(loginDate)) {
               return true; 
            }
        }
        return false;
    }

    public Staff checkStaffEmail(String email) throws SQLException {
        String sql = "SELECT * FROM USERTEST.STAFF WHERE EMAIL = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, email);

        ResultSet result = this.st.executeQuery();
        // if the result is not finished(normally we only have one result here)
        while(result.next()){
            String staffEmail = result.getString(3);
            if (staffEmail.equals(email)) {
               String staffFname = result.getString(1);
               String staffLname = result.getString(2);
               String pass = result.getString(4);
               String dob = result.getString(5);
               String gender = result.getString(6);
               int staffStreetNo = result.getInt(7);
               String staffStreetName = result.getString(8);
               String staffCity = result.getString(9);
               int staffZipcode = result.getInt(10);
               String staffCountry = result.getString(11);
               String roles = result.getString(12);
               boolean status = result.getBoolean(13);
            
               return new Staff(staffFname, staffLname, staffEmail, pass, dob, gender, staffStreetNo, staffStreetName, staffCity, staffZipcode, staffCountry, roles, status);
          }

        }
        // return the result
        return null;
    }
   
    public Staff findStaff(String email, String pass) throws SQLException {
        String sql = "SELECT * FROM USERTEST.STAFF WHERE EMAIL = ? AND PASSWORD = ?";

        // get the result after execute the query
        st = conn.prepareStatement(sql);
        st.setString(1, email);
        st.setString(2, pass);

        ResultSet result = this.st.executeQuery();
        // if the result is not finished(normally we only have one result here)
        while(result.next()){
            String staffEmail = result.getString(3);
            String staffPass = result.getString(4);
            if (staffEmail.equals(email) && staffPass.equals(pass)) {
               String staffFname = result.getString(1);
               String staffLname = result.getString(2);
               String dob = result.getString(5);
               String gender = result.getString(6);
               int staffStreetNo = result.getInt(7);
               String staffStreetName = result.getString(8);
               String staffCity = result.getString(9);
               int staffZipcode = result.getInt(10);
               String staffCountry = result.getString(11);
               String roles = result.getString(12);
               boolean status = result.getBoolean(13);
            
               return new Staff(staffFname, staffLname, staffEmail, staffPass, dob, gender, staffStreetNo, staffStreetName, staffCity, staffZipcode, staffCountry, roles, status);
          }

        }
        // return the result
        return null;
    }

    public void addStaff(String fName, String lName, String email, String pass, String gender, int addressStreetNo, String addressStreetName, String addressCity, int addressZipcode, String addressCountry, String dob, String roles) throws SQLException, ParseException {
        String sql = "INSERT INTO USERTEST.STAFF (STAFF_FNAME, STAFF_LNAME, EMAIL, PASSWORD, DOB, GENDER, STAFF_STREETNO,"
        + "STAFF_STREETNAME, STAFF_CITY, STAFF_ZIPCODE, STAFF_COUNTRY, ROLES) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        st = conn.prepareStatement(sql);
        st.setString(1, fName);
        st.setString(2, lName);
        st.setString(3, email);
        st.setString(4, pass);
        st.setString(5, dob);
        st.setString(6, gender);
        st.setInt(7, addressStreetNo);
        st.setString(8, addressStreetName);
        st.setString(9, addressCity);
        st.setInt(10, addressZipcode);
        st.setString(11, addressCountry);
        st.setString(12, roles);
        
        this.st.executeUpdate();

    }

    public void updateStaff(String fName, String lName, String email, String pass, String gender, int addressStreetNo, String addressStreetName, String addressCity, int addressZipcode, String addressCountry, String dob, String roles) throws SQLException {
       String sql = "UPDATE USERTEST.STAFF SET STAFF_FNAME = ?, STAFF_LNAME = ?, PASSWORD = ?, DOB = ?, "
       + "GENDER = ?, STAFF_STREETNO = ?, STAFF_STREETNAME = ?, STAFF_CITY = ?, STAFF_ZIPCODE = ?, STAFF_COUNTRY = ?, "
       + "ROLES = ? WHERE EMAIL = ?";
        st = conn.prepareStatement(sql);
        st.setString(1, fName);
        st.setString(2, lName);
        st.setString(3, pass);
        st.setString(4, dob);
        st.setString(5, gender);
        st.setInt(6, addressStreetNo);
        st.setString(7, addressStreetName);
        st.setString(8, addressCity);
        st.setInt(9, addressZipcode);
        st.setString(10, addressCountry);
        st.setString(11, roles);
        st.setString(12, email);

        this.st.executeUpdate();

    }

    public void cancelStaff(String email) throws SQLException {
       String sql = "UPDATE USERTEST.STAFF SET STATUS = ? WHERE EMAIL = ?";
       st = conn.prepareStatement(sql);
       st.setBoolean(1, false);
       st.setString(2, email);

       this.st.executeUpdate();
    } 

}

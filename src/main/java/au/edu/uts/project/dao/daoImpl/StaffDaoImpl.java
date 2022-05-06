/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.StaffDao;
import au.edu.uts.project.entity.Staff;
import au.edu.uts.project.entity.StaffException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public class StaffDaoImpl implements StaffDao {

    private Connection connection;

    public StaffDaoImpl(Connection connection) {
        this.connection = connection;
    }
    private final String insertStaff = "INSERT INTO Staff (Staff_FName, Staff_LName, Email, Password, DOB, Gender, Staff_streetNo, Staff_streetName, Staff_city, Staff_zipcode, Staff_country, Roles) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    private final String updateStaff = "UPDATE STAFF SET Staff_FName=?, Staff_LName=?, Email=?, Password=?, DOB=?, Gender=?, Staff_streetNo=?, Staff_streetName=?, Staff_city=?, Staff_zipcode=?, Staff_country=?, Roles=? WHERE STAFF_ID=?";

    private final String deleteStaff = "DELETE FROM STAFF WHERE STAFF_ID=?";

    private final String retrieveStaffID = "SELECT * FROM STAFF WHERE ID=?";

    private final String retrieveStaffEmail = "SELECT * FROM STAFF WHERE EMAIL=?";

    private final String selectAll = "SELECT * FROM STAFF";

    /**
     *
     * @param staff
     * @throws StaffException
     */
    @Override
    public void insertStaff(Staff staff) throws StaffException {
        PreparedStatement statement = null;
        try {
            // Try to commit the function later until every statement has been set
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertStaff);
            statement.setString(1, staff.getStaff_FName());
            statement.setString(1, staff.getStaff_FName());
            statement.setString(2, staff.getStaff_LName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPassword());
            statement.setString(5, staff.getDOB());
            statement.setString(6, staff.getStaff_FName());
            statement.setString(7, staff.getStaff_StreetNo());
            statement.setString(8, staff.getStaff_City());
            statement.setString(9, staff.getStaff_Zipcode());
            statement.setString(10, staff.getStaff_Country());
            statement.setString(11, staff.getRoles());
            // Proceed to commit it
            connection.commit();

        } catch (SQLException e) {
            try {
                // If there is an error, rollback the connection
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new StaffException(e.getMessage());
        } finally {
            try {
                // If the connection is successful, then we can set it back to autocommit since there shouldn't be any issue
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        // throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void updateStaff(Staff staff) throws StaffException {
        PreparedStatement statement = null;
        try {
            // Try to commit the function later until every statement has been set
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(updateStaff);
            statement.setString(1, staff.getStaff_FName());
            statement.setString(1, staff.getStaff_FName());
            statement.setString(2, staff.getStaff_LName());
            statement.setString(3, staff.getEmail());
            statement.setString(4, staff.getPassword());
            statement.setString(5, staff.getDOB());
            statement.setString(6, staff.getStaff_FName());
            statement.setString(7, staff.getStaff_StreetNo());
            statement.setString(8, staff.getStaff_City());
            statement.setString(9, staff.getStaff_Zipcode());
            statement.setString(10, staff.getStaff_Country());
            statement.setString(11, staff.getRoles());
            statement.setInt(12, staff.getStaff_ID());
            statement.executeUpdate();

            // Here is the commit (first try)
            connection.commit();

        } catch (SQLException e) {
            try {
                // If there is an error, rollback the connection
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new StaffException(e.getMessage());
        } finally {
            try {
                // If the connection is successful, then we can set it back to autocommit since there shouldn't be any issue
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        // throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void deleteStaff(int Staff_ID) throws StaffException {
        PreparedStatement statement = null;
        try {
            // Put it to false
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(deleteStaff);
            statement.setInt(1, Staff_ID);
            statement.executeUpdate();

            // Here is the commit
            connection.commit();

        } catch (SQLException e) {
            try {
                // If there is an error, rollback the connection
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new StaffException(e.getMessage());
        } finally {
            try {
                // If the connection is successful, then we can set it back to autocommit since there shouldn't be any issue
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        // throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Staff getStaffID(int Staff_ID) throws StaffException {
        PreparedStatement statement = null;
        try {
            // Put it to false
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(retrieveStaffID);
            statement.setInt(1, Staff_ID);
            ResultSet result = statement.executeQuery();
            Staff staff = null;

            if (result.next()) {
                // initialize a new staff
                staff = new Staff();
                // get the values from the table
                staff.setStaff_ID(result.getInt("Staff_ID"));
                staff.setStaff_FName(result.getString("Staff_FName"));
                staff.setStaff_LName(result.getString("Staff_LName"));
                staff.setEmail(result.getString("Email"));
                staff.setPassword(result.getString("Password"));
                staff.setDOB(result.getString("DOB"));
                staff.setStaff_FName(result.getString("Staff_FName"));
                staff.setStaff_StreetNo(result.getString("Staff_StreetNo"));
                staff.setStaff_City(result.getString("Staff_City"));
                staff.setStaff_Zipcode(result.getString("Staff_Zipcode"));
                staff.setStaff_Country(result.getString("Staff_Country"));
                staff.setRoles(result.getString("Roles"));
            } else {
                throw new StaffException(Staff_ID + " is not valid, please try again");
            }

            // Put the commit here before any values are returned
            connection.commit();

            return staff; // return the staff value
        } catch (SQLException e) {
            try {
                // If there is an error, rollback the connection
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new StaffException(e.getMessage());
        } finally {
            try {
                // If the connection is successful, then we can set it back to autocommit since there shouldn't be any issue
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        // throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Staff getStaffEmail(String email) throws StaffException {
        PreparedStatement statement = null;
        try {

            // Obviously another false here
            connection.setAutoCommit(false);

            // Create a connection to the database and get the first email
            statement = connection.prepareStatement(retrieveStaffEmail);
            statement.setString(1, email);

            // Execute the query / command and store it in the result
            ResultSet result = statement.executeQuery();
            Staff staff = null;

            if (result.next()) {
                // initialize a new staff to search the next result
                staff = new Staff();
                // get the additional values from the table
                staff.setStaff_ID(result.getInt("Staff_ID"));
                staff.setStaff_FName(result.getString("Staff_FName"));
                staff.setStaff_LName(result.getString("Staff_LName"));
                staff.setEmail(result.getString("Email"));
                staff.setPassword(result.getString("Password"));
                staff.setDOB(result.getString("DOB"));
                staff.setStaff_FName(result.getString("Staff_FName"));
                staff.setStaff_StreetNo(result.getString("Staff_StreetNo"));
                staff.setStaff_City(result.getString("Staff_City"));
                staff.setStaff_Zipcode(result.getString("Staff_Zipcode"));
                staff.setStaff_Country(result.getString("Staff_Country"));
                staff.setRoles(result.getString("Roles"));
            } else {
                throw new StaffException(email + " is not valid, please try again");
            }

            // Same as getStaffID, commit here
            connection.commit();

            return staff; // return the staff value
        } catch (SQLException e) {
            try {
                // If there is an error, rollback the connection
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new StaffException(e.getMessage());
        } finally {
            try {
                // If the connection is successful, then we can set it back to autocommit since there shouldn't be any issue
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        // throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public List<Staff> selectAllStaff() throws StaffException {

        // Create a statement to execute string based queries
        Statement statement = null;
        List<Staff> list = new ArrayList<Staff>();

        try {

            // Also here
            connection.setAutoCommit(false);

            // Create a connection to the database
            statement = connection.createStatement();

            // find the result from selectALL (gets the entire table)
            ResultSet result = statement.executeQuery(selectAll);
            Staff staff = null;

            while (result.next()) {
                // initialize a new staff
                staff = new Staff();
                // get the values from the table
                staff.setStaff_ID(result.getInt("Staff_ID"));
                staff.setStaff_FName(result.getString("Staff_FName"));
                staff.setStaff_LName(result.getString("Staff_LName"));
                staff.setEmail(result.getString("Email"));
                staff.setPassword(result.getString("Password"));
                staff.setDOB(result.getString("DOB"));
                staff.setStaff_FName(result.getString("Staff_FName"));
                staff.setStaff_StreetNo(result.getString("Staff_StreetNo"));
                staff.setStaff_City(result.getString("Staff_City"));
                staff.setStaff_Zipcode(result.getString("Staff_Zipcode"));
                staff.setStaff_Country(result.getString("Staff_Country"));
                staff.setRoles(result.getString("Roles"));
                list.add(staff);
            }

            // Similar as before
            connection.commit();

            return list; // return all of the value from the list
        } catch (SQLException e) {
            try {
                // If there is an error, rollback the connection
                connection.rollback();
            } catch (SQLException ex) {
            }

            throw new StaffException(e.getMessage());
        } finally {
            try {
                // If the connection is successful, then we can set it back to autocommit since there shouldn't be any issue
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
        // throw new UnsupportedOperationException("Not supported yet");
    }

}

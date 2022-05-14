/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.IotDevDao;
import au.edu.uts.project.domain.IotDev;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class IotDevDaoImpl implements IotDevDao {

    private Connection connection = null;

    private PreparedStatement pst = null;

    public IotDevDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<IotDev> selectAllItem() throws SQLException {

        String selectAll = "SELECT * FROM IOT_DEV";
        this.pst = this.connection.prepareStatement(selectAll);

        ResultSet result = this.pst.executeQuery();

        List<IotDev> list = new ArrayList<IotDev>();

        while (result.next()) {
            // initialize a new staff
            IotDev iotdev = new IotDev();
            // get the values from the table
            iotdev.setDevID(result.getInt("Dev_ID"));
            iotdev.setDevName(result.getString("Dev_Name"));
            iotdev.setDevPrice(result.getDouble("Dev_price"));
            iotdev.setQuantity(result.getInt("Quantity"));
            list.add(iotdev);
        }

        // Close the prepared statement
        this.pst.close();
        return list;
    }

    @Override
    public void createDevices(IotDev iotDev) throws SQLException {

        String createDevices = "INSERT INTO IOT_DEV (Dev_Name, Dev_price, Quantity) VALUES (?,?,?)";
        this.pst = this.connection.prepareStatement(createDevices);

        // Redundant due to auto increment
        // this.pst.setInt(1, iotDev.getDevID());
        this.pst.setString(1, iotDev.getDevName());
        this.pst.setDouble(2, iotDev.getDevPrice());
        this.pst.setInt(3, iotDev.getQuantity());
        
        this.pst.executeUpdate();

        this.pst.close();
    }

    @Override
    public void updateDevices(IotDev iotDev) throws SQLException {

        String updateDevices = "UPDATE IOT_DEV SET Dev_Name=?, Dev_price=?, Quantity=? WHERE Dev_ID=?";
        this.pst = this.connection.prepareStatement(updateDevices);

        this.pst.setString(1, iotDev.getDevName());
        this.pst.setDouble(2, iotDev.getDevPrice());
        this.pst.setInt(3, iotDev.getQuantity());
        this.pst.setInt(4, iotDev.getDevID());

        // Execute the update on existing data tables
        this.pst.executeUpdate();

        // close the connection since we are done
        this.pst.close();
    }

    @Override
    public void deleteDevices(int devID) throws SQLException {

        String deleteDevices = "DELETE FROM IOT_DEV WHERE Dev_ID=?";
        this.pst = this.connection.prepareStatement(deleteDevices);

        this.pst.setInt(1, devID);

        // Execute the update on existing data tables
        this.pst.executeUpdate();

        // close the connection since we are done
        this.pst.close();

    }

    @Override
    public IotDev getDevicesID(int devID) throws SQLException {

        String retrieveDevicesID = "SELECT * FROM IOT_DEV WHERE Dev_ID=?";
        this.pst = this.connection.prepareStatement(retrieveDevicesID);

        // Get the Device ID
        this.pst.setInt(1, devID);

        // Put the result into the query
        ResultSet result = this.pst.executeQuery();

        // Initialize a new IotDev
        IotDev iotDev = null;

        if (result.next()) 
        {
            // initialize a new staff
            iotDev = new IotDev();
            // get the values from the table
            iotDev.setDevID(result.getInt("Dev_ID"));
            iotDev.setDevName(result.getString("Dev_Name"));
            iotDev.setDevPrice(result.getDouble("Dev_price"));
            iotDev.setQuantity(result.getInt("Quantity"));
        } 
        else 
        {
            throw new SQLException(devID + " is not valid, please try again");
        }
        // Close the connection
        this.pst.close();
        // return the values from all of the selected items
        return iotDev;

    }

    @Override
    public IotDev getDevicesName(String devName) throws SQLException {

        String retrieveDevicesName = "SELECT * FROM IOT_DEV WHERE Dev_Name=?";
        this.pst = this.connection.prepareStatement(retrieveDevicesName);

        // Get the Device ID
        this.pst.setString(1, devName);

        // Put the result into the query
        ResultSet result = this.pst.executeQuery();

        // Initialize a new IotDev
        IotDev iotDev = null;

        if (result.next()) 
        {
            // initialize a new staff
            iotDev = new IotDev();
            // get the values from the table
            iotDev.setDevID(result.getInt("Dev_ID"));
            iotDev.setDevName(result.getString("Dev_Name"));
            iotDev.setDevPrice(result.getDouble("Dev_price"));
            iotDev.setQuantity(result.getInt("Quantity"));
        } 
        else 
        {
            throw new SQLException(devName + " is not valid, please try again");
        }
        // Close the connection
        this.pst.close();
        // return the values from all of the selected items
        return iotDev;

    }

    @Override
    public List<IotDev> filterList(int id) throws SQLException {
        String filterList = "SELECT * FROM IOT_DEV WHERE Dev_ID=?";
        this.pst = this.connection.prepareStatement(filterList);
        this.pst.setInt(1, id);
        ResultSet result = this.pst.executeQuery();
        List<IotDev> list = new ArrayList<>();
        if (result.next()){
            IotDev iotDev = new IotDev();
            iotDev = new IotDev();
            iotDev.setDevID(result.getInt("Dev_ID"));
            iotDev.setDevName(result.getString("Dev_Name"));
            iotDev.setDevPrice(result.getDouble("Dev_price"));
            iotDev.setQuantity(result.getInt("Quantity"));
            list.add(iotDev);
        }
        this.pst.close();
        return list;
    }

}

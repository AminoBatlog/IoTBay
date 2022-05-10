/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.dao;

import au.edu.uts.project.domain.IotDev;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IotDevDao {
    
    // Select all item from the list
    public List<IotDev> selectAllItem() throws SQLException;
    
    // Create item to the database
    public void createDevices(IotDev iotDev) throws SQLException;

    // Update existing item in the database
    public void updateDevices(IotDev iotDev) throws SQLException;

    // delete existing item from the database using ID
    public void deleteDevices(int devID) throws SQLException;

    // get the devices ID from the database table
    public IotDev getDevicesID(int devID) throws SQLException;

    // get the devices name instead of ID
    public IotDev getDevicesName(String devName) throws SQLException;

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.IotDevDao;
import au.edu.uts.project.dao.daoImpl.IotDevDaoImpl;
import au.edu.uts.project.domain.IotDev;
import au.edu.uts.project.service.IotDevService;
import au.edu.uts.project.utils.DatabaseConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class IotDevServiceImpl implements IotDevService {

    @Override
    public List<IotDev> selectAllItem() {

        // Notice there is no singleton here? well Linhan forbid it, so thats why...
        IotDevDao dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());

        List<IotDev> list = null;

        try {
            list = dao.selectAllItem();

        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public void createDevices(IotDev iotDev) {
        
        // I first used it on my staff trial run, but since it wasn't working...
        IotDevDao dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());
        
        try {
            dao.createDevices(iotDev);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

    @Override
    public void updateDevices(IotDev iotDev) {
        
        // but it turns out, it was because of a stupid mistake, a tiny one...
        IotDevDao dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());
        
        try {
            dao.updateDevices(iotDev);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteDevices(int devID) {
        
        // unfortunately I had no time to really dwell on it as it nears due date...
        IotDevDao dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());
        
        try {
            dao.deleteDevices(devID);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public IotDev getDevicesID(int devID) {
        
        // but finally I had to make a decision if I were to return to my simple ways...
        IotDevDao dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());
        IotDev iotDev = null;
        try {
            iotDev = dao.getDevicesID(devID);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iotDev;
    }

    @Override
    public IotDev getDevicesName(String devName) {
        
        // Out of fear of Linhan, I chose not to pursue the simple way, to preserve my life...
        IotDevDao dao = new IotDevDaoImpl(new DatabaseConnection().getConnection());
        IotDev iotDev = null;
        try {
            iotDev = dao.getDevicesName(devName);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iotDev;
    }
    
    

}

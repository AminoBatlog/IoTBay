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
import au.edu.uts.project.utils.IotDevDaoSingleton;

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
        // to be honest, I never said dont use singleton, if u see, i use singleton too
        IotDevDao dao = IotDevDaoSingleton.getInstance();

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
        // I even made a example for u just in case if dont know how to do that
        IotDevDao dao = IotDevDaoSingleton.getInstance();
        
        try {
            dao.createDevices(iotDev);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

    @Override
    public void updateDevices(IotDev iotDev) {
        
        // but it turns out, it was because of a stupid mistake, a tiny one...
        // pratice need time, so no worry that u cant find the mistake timely
        IotDevDao dao = IotDevDaoSingleton.getInstance();
        
        try {
            dao.updateDevices(iotDev);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteDevices(int devID) {
        
        // unfortunately I had no time to really dwell on it as it nears due date...
        // I believe u can do well, and actually u did well, u can finish ur part just by simply guide
        IotDevDao dao = IotDevDaoSingleton.getInstance();
        
        try {
            dao.deleteDevices(devID);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public IotDev getDevicesID(int devID) {
        
        // but finally I had to make a decision if I were to return to my simple ways...
        // Of course u can, just if u know how to read the error log...
        IotDevDao dao = IotDevDaoSingleton.getInstance();
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
        // Congrats! u saved, and here is another good news, u will never see me in following semesters

        // cuz I am graduates XD
        IotDevDao dao = IotDevDaoSingleton.getInstance();
        IotDev iotDev = null;
        try {
            iotDev = dao.getDevicesName(devName);
        } catch (SQLException ex) {
            Logger.getLogger(IotDevServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iotDev;
    }

    @Override
    public List<IotDev> filterList(int id) {
        IotDevDao dao = IotDevDaoSingleton.getInstance();
        List<IotDev> list = null;
        try {
            list = dao.filterList(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // anyway Kevin, u are really active in class, and probably u need to practice a little bit or Java, but it depends on if u really wanna be a programmer or something...
    // But I really appriciate ur coorperation, it is really good, expecially in online class
    // hopefully u can get a good grade
    // and btw, I got u with the singleton which u really looking for day and night, it is in the util package, check that out


}

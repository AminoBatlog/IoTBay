/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package au.edu.uts.project.service;

import au.edu.uts.project.domain.IotDev;
import java.util.List;

/**
 *
 * @author kevin
 */
public interface IotDevService {
    
    public List<IotDev> selectAllItem();
    
    public void createDevices(IotDev iotDev);

    public void updateDevices(IotDev iotDev);

    public void deleteDevices(int devID);

    public IotDev getDevicesID(int devID);

    public IotDev getDevicesName(String devName);

    public List<IotDev> filterList(int id);
    
}

package Model;

import Domain.Device;
import Repos.DeviceRepo;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author JK
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DeviceModel implements Serializable{

    private Device device;
    @Autowired
    private DeviceRepo deviceRepo;

    public void addDevice() {
        int flag = deviceRepo.save(device);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Device registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Device not saved! Check your inputs and try again later!"));
                break;
        }
    }
    
    public void updateDevice() {
        int flag = deviceRepo.update(device);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Device updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Device not updated! Check your inputs and try again later!"));
                break;
        }
    }
    
    public void deleteDevice() {
        int flag = deviceRepo.delete(device);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Device deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Device not deleted! Check your inputs and try again later!"));
                break;
        }
    }
    
    public Device fetchDevice() {
        return deviceRepo.fetch(device.getSsn());
    }
    
    public List<Device> fetchAllDevices() {
        return deviceRepo.fetchAll();
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}

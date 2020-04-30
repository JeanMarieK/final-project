
package Model;

import Domain.Accusation;
import Repos.AccusationRepo;
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
public class AccusationModel implements Serializable{

    private Accusation accusation;
    @Autowired
    private AccusationRepo accusationRepo;

    public void addAccusation() {
        int flag = accusationRepo.save(accusation);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Accusation registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Accusation not saved! Check your inputs and try again later!"));
                break;
        }
    }

    public void updateAccusation() {
        int flag = accusationRepo.update(accusation);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Accusation updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Accusation not updated! Check your inputs and try again later!"));
                break;
        }
    }

    public void deleteAccusation() {
        int flag = accusationRepo.delete(accusation);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Accusation deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Accusation not deleted! Check your inputs and try again later!"));
                break;
        }
    }

    public Accusation fetchAccusation() {
        return accusationRepo.fetch(accusation.getAcId());
    }

    public List<Accusation> fetchAllAccusations() {
        return accusationRepo.fetchAll();
    }

    public Accusation getAccusation() {
        return accusation;
    }

    public void setAccusation(Accusation accusation) {
        this.accusation = accusation;
    }
}

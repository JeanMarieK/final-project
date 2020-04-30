
package Model;

import Domain.Movement;
import Repos.MovementRepo;
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
public class MovementModel implements Serializable{

    private Movement movement;
    @Autowired
    private MovementRepo movementRepo;

    public void addMovement() {
        int flag = movementRepo.save(movement);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Movement registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Movement not saved! Check your inputs and try again later!"));
                break;
        }
    }

    public void updateMovement() {
        int flag = movementRepo.update(movement);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Movement updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Movement not updated! Check your inputs and try again later!"));
                break;
        }
    }

    public void deleteMovement() {
        int flag = movementRepo.delete(movement);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Movement deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Movement not deleted! Check your inputs and try again later!"));
                break;
        }
    }

    public Movement fetchMovement() {
        return movementRepo.fetch(movement.getSsn());
    }

    public List<Movement> fetchAllMovements() {
        return movementRepo.fetchAll();
    }

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
}

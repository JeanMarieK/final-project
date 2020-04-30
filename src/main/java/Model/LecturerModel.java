
package Model;

import Domain.Lecturer;
import Repos.LecturerRepo;
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
public class LecturerModel implements Serializable{

    private Lecturer lecturer;
    @Autowired
    private LecturerRepo lecturerRepo;

    public void addLecturer() {
        int flag = lecturerRepo.save(lecturer);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Lecturer registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Lecturer not saved! Check your inputs and try again later!"));
                break;
        }
    }

    public void updateLecturer() {
        int flag = lecturerRepo.update(lecturer);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Lecturer updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Lecturer not updated! Check your inputs and try again later!"));
                break;
        }
    }

    public void deleteLecturer() {
        int flag = lecturerRepo.delete(lecturer);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Lecturer deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Lecturer not deleted! Check your inputs and try again later!"));
                break;
        }
    }

    public Lecturer fetchLecturer() {
        return lecturerRepo.fetch(lecturer.getLecturerId());
    }

    public List<Lecturer> fetchAllLecturers() {
        return lecturerRepo.fetchAll();
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
}

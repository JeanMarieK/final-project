
package Model;

import Domain.Faculty;
import Repos.FacultyRepo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JK
 */
@ManagedBean
@SessionScoped
public class FacultyModel implements Serializable{
    private Faculty faculty;
    private FacultyRepo facultyRepo;
    
    @PostConstruct
    public void init() {
        faculty = new Faculty();
        facultyRepo=new FacultyRepo();
    }

    public void addFaculty() {
        int flag = facultyRepo.save(faculty);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Faculty registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Faculty not saved! Check your inputs and try again later!"));
                break;
        }
    }

    public void updateFaculty() {
        int flag = facultyRepo.update(faculty);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Faculty updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Faculty not updated! Check your inputs and try again later!"));
                break;
        }
    }

    public void deleteFaculty() {
        int flag = facultyRepo.delete(faculty);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Faculty deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Faculty not deleted! Check your inputs and try again later!"));
                break;
        }
    }

    public Faculty fetchFaculty() {
        return facultyRepo.fetch(faculty.getFacultyId());
    }

    public List<Faculty> fetchAllFaculties() {
        return facultyRepo.fetchAll();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}

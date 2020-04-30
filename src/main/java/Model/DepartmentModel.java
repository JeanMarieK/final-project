package Model;

import Domain.Department;
import Repos.DepartmentRepo;
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
public class DepartmentModel implements Serializable {

    private Department department;
    private DepartmentRepo departmentRepo;

    @PostConstruct
    public void init() {
        department = new Department();
        departmentRepo = new DepartmentRepo();
    }


    public void addDepartment() {
        int flag = departmentRepo.save(department);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Department registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Department not saved! Check your inputs and try again later!"));
                break;
        }
    }

    public void updateDepartment() {
        int flag = departmentRepo.update(department);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Department updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Department not updated! Check your inputs and try again later!"));
                break;
        }
    }

    public void deleteDepartment() {
        int flag = departmentRepo.delete(department);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Department deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Department not deleted! Check your inputs and try again later!"));
                break;
        }
    }

    public Department fetchDepartment() {
        return departmentRepo.fetch(department.getDepartmentId());
    }

    public List<Department> fetchAllDepartments() {
        return departmentRepo.fetchAll();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}

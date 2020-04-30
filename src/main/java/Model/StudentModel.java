package Model;

import Domain.Department;
import Domain.EGender;
import Domain.EStatus;
import Domain.Student;
import Repos.DepartmentRepo;
import Repos.StudentRepo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author JK
 */
@ManagedBean
@SessionScoped
public class StudentModel implements Serializable {

    private Student student;
    private StudentRepo studentRepo;
    private String gender;
    private UploadedFile pic;

    @PostConstruct
    public void init() {
        student = new Student();
        studentRepo=new StudentRepo();
    }

    public void addStudent() {
        student.setPhoto(pic.getContents());
        student.setGender(EGender.valueOf(gender));
        student.setStatus(EStatus.ACTIVE);
        int flag = studentRepo.save(student);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student registered successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Student not saved! Check your inputs and try again later!"));
                break;
        }
    }

    public void updateStudent() {
        int flag = studentRepo.update(student);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student updated successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Student not updated! Check your inputs and try again later!"));
                break;
        }
    }

    public void deleteStudent() {
        int flag = studentRepo.delete(student);
        switch (flag) {
            case 1:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Student deleted successfully!"));
                break;
            case 0:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Student not deleted! Check your inputs and try again later!"));
                break;
        }
    }

    public Student fetchStudent() {
        return studentRepo.fetch(student.getStudentId());
    }

    public List<Student> fetchAllStudents() {
        return studentRepo.fetchAll();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UploadedFile getPic() {
        return pic;
    }

    public void setPic(UploadedFile pic) {
        this.pic = pic;
    }

    
}

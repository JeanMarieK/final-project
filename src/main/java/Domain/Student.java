/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author student
 */
@Entity
public class Student extends Person {
    @Id
    private int studentId;
    private String program;
    @ManyToOne
    private List<Faculty> FacultyList;
    @ManyToOne
    private List<Department> DepartmentList;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public List<Faculty> getFacultyList() {
        return FacultyList;
    }

    public void setFacultyList(List<Faculty> FacultyList) {
        this.FacultyList = FacultyList;
    }

    public List<Department> getDepartmentList() {
        return DepartmentList;
    }

    public void setDepartmentList(List<Department> DepartmentList) {
        this.DepartmentList = DepartmentList;
    }

    
    
}

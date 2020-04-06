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
public class Lecturer extends Person {
    @Id
    private int lecturerId;
    @ManyToOne
    private List<Faculty> facultyList;
    private ElecturerType type;

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public ElecturerType getType() {
        return type;
    }

    public void setType(ElecturerType type) {
        this.type = type;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author student
 */
@Entity
public class Staff extends Person{
    @Id
    private String staffId;
    @Column(nullable = false)
    private EStaffType staffTpye;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public EStaffType getStaffTpye() {
        return staffTpye;
    }

    public void setStaffTpye(EStaffType staffTpye) {
        this.staffTpye = staffTpye;
    }
    
    
    
}

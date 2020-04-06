/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author student
 */
@Entity
public class Movement {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int ssn;
    @OneToOne
    private Device device;
    private Date date;
    private Time entranceTime;
    private Time exitTime;
    private EMovementStatus mStatus;

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Time entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Time getExitTime() {
        return exitTime;
    }

    public void setExitTime(Time exitTime) {
        this.exitTime = exitTime;
    }

    public EMovementStatus getmStatus() {
        return mStatus;
    }

    public void setmStatus(EMovementStatus mStatus) {
        this.mStatus = mStatus;
    }
    
    
}

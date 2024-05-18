package campusShuttle.classes;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
public class Shuttle {
    @Id
    private Integer shuttleId;

    private String name;

    private String registrationNumber;

    public Shuttle(Integer shuttleId, String name, String registrationNumber){
        this.shuttleId = shuttleId;
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public Shuttle(){

    }

    public Integer getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(Integer shuttleId) {
        this.shuttleId = shuttleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


}


package campusShuttle.classes;

import javax.persistence.*;

public class Passenger {

    @Id
    private Integer suid;

    @Embedded
    private Address address;

    private Integer shuttleId;

    public Passenger(Integer suid, Integer shuttleId, Address address){
        this.suid = suid;
        this.address = address;
        this.shuttleId = shuttleId;
    }

    public Passenger(){

    }

    public Integer getSuid() {
        return suid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getShuttleId() {
        return shuttleId;
    }
}

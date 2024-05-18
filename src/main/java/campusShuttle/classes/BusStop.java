package campusShuttle.classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class BusStop {
    @Id
    private Integer busStopId;

    private String name;

    private Location location;

    public BusStop(){

    }

    public BusStop(Integer busStopId, String name, Location location){
        this.busStopId = busStopId;
        this.name = name;
        this.location = location;
    }

    public Integer getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(Integer busStopId) {
        this.busStopId = busStopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
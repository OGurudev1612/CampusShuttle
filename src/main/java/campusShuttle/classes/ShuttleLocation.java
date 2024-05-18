package campusShuttle.classes;

import org.springframework.data.annotation.Id;


public class ShuttleLocation extends Location {

    @Id
    private Integer shuttleId;

    public ShuttleLocation(Integer shuttleId,Double longitude, Double latitude) {
        this.shuttleId = shuttleId;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public ShuttleLocation(){

    }

    public Integer getShuttleId() {
        return shuttleId;
    }
}

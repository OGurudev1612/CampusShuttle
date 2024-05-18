package campusShuttle.classes;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String address;

    private Location location;

    public Address(String address, Location location){

        this.address = address;
        this.location = location;
    }

    public Address(){

    }

    public String getAddress(){
        return this.address;
    }

    public Location getLocation(){
        return this.location;
    }

    public void setLocation(Location location){
        this.location = location;
    }
}

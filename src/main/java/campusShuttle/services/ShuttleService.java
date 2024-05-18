package campusShuttle.services;

import campusShuttle.classes.*;
import campusShuttle.repositories.PassengerRepository;
import campusShuttle.repositories.ShuttleLocationRepository;
import campusShuttle.repositories.ShuttleRepository;
import campusShuttle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ShuttleService {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ShuttleRepository shuttleRepository;

    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShuttleLocationRepository shuttleLocationRepository;


    //Returns all the shuttles in the database
    public Iterable<Shuttle> getAllShuttles() {
        return shuttleRepository.findAll();
    }

    //Adds new shuttle to the database
    public Boolean addNewShuttle (Integer shuttleId, String name, String registrationNumber) {
        try {
            Shuttle s = new Shuttle(shuttleId, name, registrationNumber);
            shuttleRepository.save(s);
            ShuttleLocation sl = new ShuttleLocation(shuttleId, 0.0, 0.0);
            shuttleLocationRepository.save(sl);
        }catch(Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    //Updates the current location of the shuttle
    public Boolean setShuttleLocation (Integer shuttleId, Double longitude, Double latitude) {
        try {
            ShuttleLocation sl = shuttleLocationRepository.findByShuttleId(shuttleId);
            sl.setLongitude(longitude);
            sl.setLatitude(latitude);
            shuttleLocationRepository.save(sl);
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    //Adds new passenger to the shuttle
    public String addPassenger (Integer shuttleId, Integer user_id, String address) {
        if(shuttleRepository.existsById(shuttleId)) {
            if (userRepository.existsById(user_id)) {
                User user = userRepository.getById(user_id);
                Passenger passenger = new Passenger(user_id, shuttleId,new Address(address, new Location()));
                passengerRepository.save(passenger);
                return "{ MSG : saved }";
            }
            else{
                return "{ ERROR : user not found }";
            }
        }
        return "{ ERROR : shuttle not found }";
    }

    //Returns all passengers of a shuttle
    public List<Passenger> getAllPassengers(Integer shuttleId){
        if(shuttleRepository.existsById(shuttleId)){
            return passengerRepository.findByShuttleId(shuttleId);
        }
        return null;
    }

    public Boolean removeAllPassengers(Integer shuttleId){
        try {
            if (shuttleRepository.existsById(shuttleId)) {
                passengerRepository.deleteAllByShuttleId(shuttleId);
            }
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}

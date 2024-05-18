package campusShuttle.repositories;

import java.util.List;

import campusShuttle.classes.Passenger;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<Passenger, String> {

    public Passenger findBySuid(Integer suid);
    public List<Passenger> findByShuttleId(Integer shuttleId);

    public void deleteAllByShuttleId(Integer shuttleId);

}

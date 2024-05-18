package campusShuttle.repositories;

import campusShuttle.classes.ShuttleLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShuttleLocationRepository extends MongoRepository<ShuttleLocation, String> {

    public ShuttleLocation findByShuttleId(Integer shuttleId);

}

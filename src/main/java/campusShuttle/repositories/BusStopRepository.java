package campusShuttle.repositories;

import campusShuttle.classes.BusStop;
import campusShuttle.classes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BusStopRepository extends CrudRepository<BusStop, Integer> {


}
package campusShuttle.repositories;

import campusShuttle.classes.Shuttle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ShuttleRepository extends CrudRepository<Shuttle, Integer> {

    //Returns shuttle object
    @Query("SELECT s FROM Shuttle s WHERE id = ?1")
    Shuttle getById(Integer shuttleId);

}
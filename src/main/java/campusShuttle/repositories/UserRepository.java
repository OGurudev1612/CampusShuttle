package campusShuttle.repositories;

import campusShuttle.classes.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    //Returns user object
    @Query("SELECT a FROM User a WHERE id = ?1")
    User getById(int suid);

}
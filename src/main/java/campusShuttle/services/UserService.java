package campusShuttle.services;

import campusShuttle.classes.User;
import campusShuttle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Returns Estimated Time of Arrival (ETA)
    public String getETA(Integer suid, Double longitude, Double latitude){

        if(userRepository.existsById(suid)){
            //ETA = ShuttleService.getETA(longitude,latitude);
            return "{ {BusStop : 1, ETA : 0.0, 3.0, ETA_To_BusStop : 5.0}," +
                    "{BusStop : 2, ETA : 10.0, 15.0, ETA_To_BusStop : 10.0}  }";
        }
        return "{ ERROR : invalid suid }";
    }

    //Adds new student(user) to the database
    public Boolean addNewUser(Integer suid, String name, String email){
        try {
            User n = new User(suid, name, email);
            //n.setSuid(suid);
           // n.setName(name);
          //  n.setEmail(email);
            userRepository.save(n);
        }catch (Exception e){
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    //Returns all the users in the database
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}

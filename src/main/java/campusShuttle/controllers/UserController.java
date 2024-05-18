package campusShuttle.controllers;

import campusShuttle.classes.User;
import campusShuttle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserService userService;

    //Returns all the Users in the database
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }

    //Adds new user to the database
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam Integer suid, @RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if(userService.addNewUser(suid, name, email)){
            return "{ MSG : Saved }";
        }

        return "{ ERROR : some exception occurred. Please try again later }";
    }

    //Returns Estimated Time of Arrivals(ETA) of both the shuttles to both the bus stops to the user.
    //Taking current location of the user to return ETA for the user to go the bus stop.
    @PostMapping(path="/requestPickup") // Map ONLY POST Requests
    public @ResponseBody String requestPickup (@RequestParam Integer suid,
                                            @RequestParam Double longitude,
                                            @RequestParam Double latitude) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return userService.getETA(suid, longitude, latitude);
    }


}
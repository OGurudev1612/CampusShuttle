package campusShuttle.controllers;

import campusShuttle.classes.*;
import campusShuttle.services.ShuttleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // This means that this class is a Controller
@RequestMapping(path="/shuttle") // This means URL's start with /demo (after Application path)
public class ShuttleController {
    @Autowired
    private ShuttleService shuttleService;

    //Returns all the shuttles in the database
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Shuttle> getAllShuttles() {
        // This returns a JSON or XML with the shuttles
        return shuttleService.getAllShuttles();
    }

    //Adds new shuttle to the database
    @PostMapping(path="/addShuttle") // Map ONLY POST Requests
    public @ResponseBody String addNewShuttle (@RequestParam Integer shuttleId, @RequestParam String name,
                                               @RequestParam String registrationNumber) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if(shuttleService.addNewShuttle(shuttleId, name, registrationNumber)){
            return "{ MSG : Saved }";
        }

        return "{ ERROR : some exception occurred. Please try again later }";
    }

    //Updates current location of the shuttle
    @PostMapping(path="/setLocation") // Map ONLY POST Requests
    public @ResponseBody String setShuttleLocation (@RequestParam Integer shuttleId,
                                               @RequestParam Double longitude,
                                               @RequestParam Double latitude) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if(shuttleService.setShuttleLocation(shuttleId, longitude, latitude)){
            return "{ MSG : updated }";
        }
        return "{ ERROR : some exception occurred }";
    }

    //Adds new passenger to the shuttle
    @PostMapping(path="/addPassenger") // Map ONLY POST Requests
    public @ResponseBody String addPassenger (@RequestParam Integer shuttleId,
                                              @RequestParam Integer userId, @RequestParam String address) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return shuttleService.addPassenger(shuttleId, userId, address);

    }

    //Returns all the passengers in the shuttle
    @PostMapping(path="/passengers/all")
    public @ResponseBody List<Passenger> getAllPassengers(@RequestParam Integer shuttleId){

        return shuttleService.getAllPassengers(shuttleId);
    }

    @PostMapping(path="/passengers/removeAll")
    public @ResponseBody String removeAllPassengers(@RequestParam Integer shuttleId){

        if(shuttleService.removeAllPassengers(shuttleId)){
            return "{ MSG : cleared }";
        }
        return "{ ERROR : some error occurred }";
    }
}
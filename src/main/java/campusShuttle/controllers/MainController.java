package campusShuttle.controllers;

//import campusShuttle.classes.User;
//import campusShuttle.repositories.UserRepository;
import campusShuttle.classes.BusStop;
import campusShuttle.classes.Location;
import campusShuttle.repositories.BusStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path="/main") // This means URL's start with /demo (after Application path)
public class MainController {

    @Autowired
    private BusStopRepository busStopRepository;

    @GetMapping(path="/")
    public @ResponseBody String welcome() {
        // This returns a JSON or XML with the users
        return "Hi! this is campus shuttle";
    }

    @PostMapping(path="/addBusStop")
    public @ResponseBody String addBusStop(@RequestParam Integer busStopId,
                                           @RequestParam String name,
                                           @RequestParam Double longitude,
                                           @RequestParam Double latitude){
        try {
            BusStop bs = new BusStop(busStopId, name, new Location(longitude, latitude));
            busStopRepository.save(bs);
        }catch (Exception e) {
            return "{ ERROR : some error occurred }";
        }
        return "{ MSG : saved }";
    }
}
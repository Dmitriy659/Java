package part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/departures")
public class DepartureController {
    private List<Departure> departures = new ArrayList<>();

    @PostMapping("/create")
    @ResponseBody
    public String createDeparture(@RequestBody Departure departure) {
        departures.add(departure);
        return "Created element with id: " + (departures.size() - 1);
    }

    @GetMapping("/get")
    @ResponseBody
    public String getAllDepartures() {
        StringBuilder res = new StringBuilder();
        for (Departure departure : departures) {
            res.append(departure);
            res.append("\n");
        }
        return res.toString();
    }

    @DeleteMapping("/{index}")
    public void deleteDeparture(@PathVariable int index) {
        if (index >= 0 && index < departures.size()) {
            departures.remove(index);
        }
    }
}


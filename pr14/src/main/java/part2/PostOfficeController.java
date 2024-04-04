package part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/postOffices")
public class PostOfficeController {
    private List<PostOffice> postOffices = new ArrayList<>();

    @PostMapping("/create")
    public void createPostOffice(@RequestBody PostOffice postOffice) {

        postOffices.add(postOffice);
    }

    @GetMapping("/get")
    public List<PostOffice> getAllPostOffices() {
        return postOffices;
    }

    @DeleteMapping("/{index}")
    public void deletePostOffice(@PathVariable int index) {
        if (index >= 0 && index < postOffices.size()) {
            postOffices.remove(index);
        }
    }
}

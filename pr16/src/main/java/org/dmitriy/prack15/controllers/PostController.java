package org.dmitriy.prack15.controllers;

import org.dmitriy.prack15.entity.Departure;
import org.dmitriy.prack15.entity.PostOffice;
import org.dmitriy.prack15.services.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postOffice")
public class PostController {
    PostOfficeService postOfficeService;
    @Autowired
    public PostController(PostOfficeService postOfficeService) {
        this.postOfficeService = postOfficeService;
    }

    @PostMapping("/create")
    public String createPost(@RequestBody PostOffice postOffice) {
        return postOfficeService.addPost(postOffice);
    }

    @GetMapping("/getall")
    public List<PostOffice> getAllPost() {

        return postOfficeService.getAllPost();
    }

    @GetMapping("/get/{id}")
    public String getOne(@PathVariable Long id) {

        return postOfficeService.getPost(id).toString();
    }

    @PostMapping("/add/{id}")
    public String addDeparture(@RequestBody Departure departure, @PathVariable Long id) {
        postOfficeService.addDeparture(id, departure);
        return "Добавлено";
    }

    @PostMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postOfficeService.removePost(id);
    }
}

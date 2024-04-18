package org.dmitriy.prack15.controllers;

import org.dmitriy.prack15.entity.PostOffice;
import org.dmitriy.prack15.services.PostOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String getAllPost() {
        return postOfficeService.getAllPost().toString();
    }

    @GetMapping("/get/{id}")
    public PostOffice getOne(@PathVariable Long id) {
        return postOfficeService.getPost(id);
    }

    @PostMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        postOfficeService.removePost(id);
    }
}

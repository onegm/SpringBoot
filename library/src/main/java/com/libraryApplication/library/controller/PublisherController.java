package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Publisher;
import com.libraryApplication.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers(){
        return publisherService.getAllPublishers();
    }

    @GetMapping("/publishers/{id}")
    public Publisher getPublisher(@PathVariable Long id){
        return publisherService.getPublisher(id);
    }

    @PostMapping("/publishers/new")
    public void createPublisher(@RequestBody Publisher publisher){
        publisherService.createPublisher(publisher);
    }

    @PutMapping("/publishers/update")
    public void updatePublisher(@RequestBody Publisher publisher){
        publisherService.updatePublisher(publisher);
    }

    @DeleteMapping("/publishers/remove/{id}")
    public void deletePublisher(@PathVariable Long id){
        publisherService.removePublisher(id);
    }
}

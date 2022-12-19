package com.libraryApplication.library.controller;

import com.libraryApplication.library.entity.Book;
import com.libraryApplication.library.entity.Publisher;
import com.libraryApplication.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/publishers")
    public String getAllPublishers(Model model){
        model.addAttribute("publisherList", publisherService.getAllPublishers());
        return "publisher/publishers";
    }

    @GetMapping("/publishers/{id}")
    public String getPublisher(@PathVariable Long id, Model model){
        Publisher publisher = publisherService.getPublisher(id);
        Set<Book> books = publisher.getBooks();
        model.addAttribute("publisher", publisher);
        model.addAttribute("books", books);
        return "publisher/publisher-books";
    }

    @GetMapping("/publishers/new")
    public String createPublisher(Publisher publisher){
        return "publisher/new-publisher";
    }

    @PostMapping("/publishers/save-publisher")
    public String savePublisher(Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisher/new-publisher";
        }
        publisherService.createPublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/publishers/update/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute("publisher", publisherService.getPublisher(id));
        return "publisher/edit-publisher";
    }

    @PostMapping("/publishers/save-update/{id}")
    public String updatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result){
        if(result.hasErrors()){
            return "publisher/edit-publisher";
        }
        publisherService.updatePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/publishers/remove/{id}")
    public String deletePublisher(@PathVariable Long id){
        publisherService.removePublisher(id);
        return"redirect:/publishers";
    }
}
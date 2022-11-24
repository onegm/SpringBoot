package com.libraryApplication.library.service;

import com.libraryApplication.library.entity.Publisher;
import com.libraryApplication.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    public void createPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher getPublisher(Long id){
        return publisherRepository.findById(id).orElseThrow(() -> new RuntimeException("Publisher not Found"));
    }

    public void updatePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    public void removePublisher(Long id){
        publisherRepository.deleteById(id);
    }
}

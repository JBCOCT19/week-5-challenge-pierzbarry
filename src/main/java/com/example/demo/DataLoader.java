package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    JobRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        Job job;

        job = new Job("Sales Manager Advisor - Fulltime", "In desperate need of a Sales Manager Advisor for our new startup Glide. 40 hrs a week and we will buy you food!", "10/10/10", "Erin Sullivan", "301-444-2424", null, "Washington DC", "$40,000");
        repository.save(job);
        job = new Job("Sales Manager Advisor - Fulltime", "In desperate need of a Sales Manager Advisor for our new startup Glide. 40 hrs a week and we will buy you food!", "10/10/10", "Erin Sullivan", "301-444-2424", null, "Washington DC", "$40,000");
        repository.save(job);
    }
}

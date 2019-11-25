package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface JobRepository extends CrudRepository<Job, Long> {
    ArrayList<Job> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrPostedDateContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrLocationContainingIgnoreCaseOrSalaryContainingIgnoreCase
            (String title, String description, String postedDate, String author, String phone, String location, String salary);
}

//        this.title = title;
//        this.description = description;
//        this.postedDate = postedDate;
//        this.author = author;
//        this.phone = phone;
//        this.imageurl = imageurl;
//        this.location = location;
//        this.salary = salary;
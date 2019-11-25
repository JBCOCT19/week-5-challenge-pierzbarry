package com.example.demo;

public class Job {
    private String id;
    private String title;
    private String description;
    private String postedDate;
    private String author;
    private String phone;
    private String imageurl;

    public Job() {
    }

    public Job(String id, String title, String description, String postedDate, String author, String phone, String imageurl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedDate = postedDate;
        this.author = author;
        this.phone = phone;
        this.imageurl = imageurl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}


// title
// description
// postedDate
// author
// phone
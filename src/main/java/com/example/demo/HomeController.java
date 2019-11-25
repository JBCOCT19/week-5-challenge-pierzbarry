package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String jobForm(Model model) {
        model.addAttribute("job", new Job());
        return "jobform";
    }

    @PostMapping("/process")
    public String processForm(@ModelAttribute Job job, @RequestParam("file") MultipartFile file, @RequestParam("imageurl") String imageurl) {
        if (!file.isEmpty()) {
            try {
                Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype" , "auto"));
                job.setImageurl(uploadResult.get("url").toString());

            } catch (IOException e){
                e.printStackTrace();
            }
        }
        if(file.isEmpty() && imageurl.equalsIgnoreCase("")){
            job.setImageurl(null);
        }
        jobRepository.save(job);
        return "redirect:/";

    }

    @RequestMapping("/detail/{id}")
    public String showJob(@PathVariable("id") long id, Model model) {
        model.addAttribute("job", jobRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateJob(@PathVariable("id") long id, Model model) {
        model.addAttribute("job", jobRepository.findById(id).get());
        return "jobform";
    }

    @RequestMapping("/delete/{id}")
    public String delJob(@PathVariable("id") long id) {
        jobRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/searchlist")
    public String search(Model model, @RequestParam("searchString") String search){
        model.addAttribute("jobs", jobRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrPostedDateContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrPhoneContainingIgnoreCaseOrLocationContainingIgnoreCaseOrSalaryContainingIgnoreCase(search,
                search, search, search, search, search, search));
        return "searchlist";
    }
}


package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/processUser")
    public String processUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/";
    }
    @RequestMapping("/detailUse/{id}")
    public String detailUse(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findById(id).get());
        return "detailUse";

    }

    @RequestMapping("/updateUse/{id}")
    public String updateUse(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userRepository.findById(id).get());
        return "addUser";
    }

    @RequestMapping("/deleteUse/{id}")
    public String deleteUse(@PathVariable("id") long id){
        userRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/listJobs")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "listJobs";
    }

    @RequestMapping("/addJobs")
    public String addJobs(Model model){
        model.addAttribute("job", new Job());
        model.addAttribute("users", userRepository.findAll());
        return "addJobs";
    }



    @PostMapping("/processJob")
    public String processJob(@ModelAttribute Job job) {
        jobRepository.save(job);
        return "redirect:/";
    }

    @RequestMapping("/updateJobs/{id}")
    public String updateJobs(@PathVariable("id") long id, Model model){
        Job job = jobRepository.findById(id).get();
        model.addAttribute("job", job);
        model.addAttribute("users", userRepository.findAll());
        return "addJobs";
    }

    @RequestMapping("/deleteJobs/{id}")
    public String deleteJobs(@PathVariable("id") long id){
        jobRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/detailJobs/{id}")
    public String detailJobs(@PathVariable("id") long id, Model model){
        //   Pet pet = petRepository.findById(id).get();
        model.addAttribute("job", jobRepository.findById(id).get());
        return "detailJobs";



    }
}

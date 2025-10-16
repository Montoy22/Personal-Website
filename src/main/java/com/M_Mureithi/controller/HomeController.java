package com.M_Mureithi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class HomeController {
    
    @GetMapping({"/", "", "/home"})//if url matches any of these method below is called
    public String showHomePage(Model model){
        model.addAttribute("title","Home");
        return "master";
    } 

    @GetMapping("/contact")//if url matches any of these method below is called
    public String showContactPage(Model model){
        model.addAttribute("title","Contact");
        return "master";
    }

    @GetMapping("/resume")//if url matches any of these method below is called
    public String showResumePage(Model model){
        model.addAttribute("title","Resume");
        return "master";
    }

    @GetMapping("/projects")//if url matches any of these method below is called
    public String showProjectsPage(Model model){
        model.addAttribute("title","Projects");
        return "master";
    }
}

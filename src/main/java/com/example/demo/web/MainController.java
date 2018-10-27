package com.example.demo.web;


import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final UserRepository repository;

    @Autowired
    public MainController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("userList", repository.findAll());
        return "index";
    }

}

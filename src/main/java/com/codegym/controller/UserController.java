package com.codegym.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("user")
    public String user(Principal principal){
        System.out.println(principal.getName());
        //ModelAndView modelAndView = new ModelAndView("user");
        return "user";
    }

    @GetMapping("admin")
    public ModelAndView admin(){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        ModelAndView modelAndView = new ModelAndView("admin");
        return modelAndView;
    }
}

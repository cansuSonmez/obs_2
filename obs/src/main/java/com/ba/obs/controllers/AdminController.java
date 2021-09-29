package com.ba.obs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController
{
    @GetMapping(value = {"admin", "admin.html"})
    public ModelAndView admin()
    {
        return new ModelAndView("admin");
    }
}
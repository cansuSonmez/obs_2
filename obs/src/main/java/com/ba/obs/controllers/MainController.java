package com.ba.obs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller public class MainController
{
    @GetMapping(path = {"/index", "/index.html"}) public ModelAndView index()
    {
        return new ModelAndView("index");
    }

}
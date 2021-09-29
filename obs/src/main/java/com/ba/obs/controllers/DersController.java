package com.ba.obs.controllers;

import com.ba.obs.model.Ders;
import com.ba.obs.service.DersService;
import com.ba.obs.service.KonuService;
import com.ba.obs.service.OgretmenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller @AllArgsConstructor public class DersController
{
    private OgretmenService ogretmenService;
    private KonuService konuService;
    private DersService dersService;

    @GetMapping(path = "/ders") public ModelAndView ders()
    {
        ModelAndView ders = new ModelAndView("ders");
        ders.addObject("dersler", dersService.getAllDersDTO());
        ders.addObject("ogretmenler", ogretmenService.getAll());
        ders.addObject("konular", konuService.getAll());
        ders.addObject("ders", new Ders());
        return ders;
    }

    @PostMapping(path = "/ders") public ModelAndView dersPost(@ModelAttribute(name = "ders") Ders ders)
    {
        dersService.insert(ders);
        return new ModelAndView("redirect:/ders");
    }

}
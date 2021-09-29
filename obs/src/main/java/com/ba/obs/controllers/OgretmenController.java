package com.ba.obs.controllers;

import com.ba.obs.model.Ogretmen;
import com.ba.obs.service.OgretmenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller @AllArgsConstructor public class OgretmenController
{
    private OgretmenService ogretmenService;

    @GetMapping(path = "ogretmen") public ModelAndView ogretmen()
    {
        ModelAndView ogretmen = new ModelAndView("ogretmen");
        ogretmen.addObject("ogretmenler", ogretmenService.getAll());
        ogretmen.addObject("ogretmen", new Ogretmen());
        return ogretmen;
    }
    @PostMapping(path = "ogretmen") public ModelAndView ogretmenKaydet(@ModelAttribute(value = "ogretmen") Ogretmen ogretmen)
    {
        ogretmenService.insert(ogretmen);
        return new ModelAndView("redirect:/ogretmen");
    }
}
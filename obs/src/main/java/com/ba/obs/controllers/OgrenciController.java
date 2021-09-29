package com.ba.obs.controllers;

import com.ba.obs.model.Ogrenci;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.service.OgrenciService;
import com.ba.obs.service.OgretmenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class OgrenciController
{
    private OgrenciService ogrenciService;

    @GetMapping(path = "ogrenci") public ModelAndView ogrenci()
    {
        ModelAndView ogrenci = new ModelAndView("ogrenci");
        ogrenci.addObject("ogrenciler", ogrenciService.getAll());
        ogrenci.addObject("ogrenci", new Ogrenci());
        return ogrenci;
    }
    @PostMapping(path = "ogrenci") public ModelAndView ogrenciSil(@RequestParam(name = "id") Integer id)
    {
        ogrenciService.deleteById(id);
        return new ModelAndView("redirect:/ogrenci");
    }
}
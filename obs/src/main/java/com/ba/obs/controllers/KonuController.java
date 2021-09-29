package com.ba.obs.controllers;

import com.ba.obs.service.KonuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller @AllArgsConstructor public class KonuController
{
    private KonuService konuService;

    @GetMapping(path = "konu") public ModelAndView konu(@RequestParam(name = "page_num", required = false, defaultValue = "0") Integer page_num)
    {
        ModelAndView konu = new ModelAndView("konu");
        konu.addObject("konular", konuService.getKonu(page_num));
        if (page_num != 0)
        {
            konu.addObject("page_num_prev", page_num - 1);
        }
        int numberOfRows = konuService.getCount();
        if (numberOfRows > (page_num + 1) * 5)
        {
            konu.addObject("page_num_next", page_num + 1);
        }
        return konu;
    }
}
package com.ba.obs.restControllers;

import com.ba.obs.model.Konu;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.service.KonuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @AllArgsConstructor @RequestMapping(path = "KonuWS") public class KonuRestController
{
    private KonuService konuService;

    @GetMapping(path = "/getByName/{name}") public ResponseEntity<Konu> getKonuByName(@PathVariable(name = "name") String name)
    {
        return new ResponseEntity<>(konuService.getKonuByName(name), HttpStatus.OK);
    }
}
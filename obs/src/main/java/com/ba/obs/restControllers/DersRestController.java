package com.ba.obs.restControllers;

import com.ba.obs.dto.DersDTO;
import com.ba.obs.model.Ders;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.service.DersService;
import com.ba.obs.service.KonuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController @AllArgsConstructor @RequestMapping(path = "/dersWS") public class DersRestController
{
    private DersService dersService;
    private KonuService konuService;

    @GetMapping(path = "/getAll") public ResponseEntity<List<Ders>> getAll()
    {
        return new ResponseEntity<List<Ders>>(dersService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Burada ders id gönderilmek zorunda değildir") public ResponseEntity<String> insert(@RequestBody Ders ders)
    {
        //if(konuService.getKonuByIdders.getKonu_id()) != null)
        dersService.insert(ders);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }
}
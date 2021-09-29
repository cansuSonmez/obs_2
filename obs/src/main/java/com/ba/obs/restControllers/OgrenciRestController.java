package com.ba.obs.restControllers;

import com.ba.obs.model.Ogrenci;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.repo.OgrenciRepository;
import com.ba.obs.service.OgrenciService;
import com.ba.obs.service.OgretmenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ogrenciWS")
@AllArgsConstructor
public class OgrenciRestController
{
    OgrenciService ogrenciService;

    // http://localhost:8080/ogrenci/getAll
    @GetMapping(path = "/getAll") public ResponseEntity<List<Ogrenci>> getAll()
    {
        return new ResponseEntity<>(ogrenciService.getAll(), HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/getById/2
    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Ogrenci> getOgrenciById(@PathVariable(name = "id") int id)
    {
        return new ResponseEntity<>(ogrenciService.getById(id), HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/insert
    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@org.springframework.validation.annotation.Validated @RequestBody Ogrenci ogrenci)
    {
        ogrenciService.insert(ogrenci);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }

    // http://localhost:8080/ogrenci/deleteById/{id}
    @PostMapping(path = "/deleteById/{id}") public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id)
    {
        ogrenciService.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }
}
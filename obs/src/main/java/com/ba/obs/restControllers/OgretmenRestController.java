package com.ba.obs.restControllers;

import com.ba.obs.model.Konu;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.repo.OgretmenRepository;
import com.ba.obs.service.OgretmenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ogretmenWS")
@AllArgsConstructor
public class OgretmenRestController
{
    OgretmenService ogretmenService;

    @GetMapping(path = "/getAll") public ResponseEntity<List<Ogretmen>> getAll()
    {
        return new ResponseEntity<List<Ogretmen>>(ogretmenService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/getByName/{name}")
    public ResponseEntity<Ogretmen> getOgretmenByName(@PathVariable(name = "name") String name)
    {
        return new ResponseEntity<>(ogretmenService.getOgretmenByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/getById/{id}") public ResponseEntity<Ogretmen> getOgrenciById(@PathVariable(name = "id") int id)
    {
        return new ResponseEntity<>(ogretmenService.getById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") int id)
    {
        ogretmenService.deleteById(id);
        return new ResponseEntity<>("başarılı", HttpStatus.OK);
    }

    @PostMapping(path = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Object> insert(@RequestBody Ogretmen ogretmen)
    {
        ogretmenService.insert(ogretmen);
        return new ResponseEntity<>("Başarılı", HttpStatus.OK);
    }
}
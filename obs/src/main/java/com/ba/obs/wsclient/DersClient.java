package com.ba.obs.wsclient;

import com.ba.obs.model.Ders;
import com.ba.obs.model.Konu;
import com.ba.obs.model.Ogretmen;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class DersClient
{
    public static void main(String[] args)
    {
        RestTemplate template = new RestTemplate();
        String konu = "Java101";
        URI url = URI.create("http://localhost:8080/KonuWS/getByName/" + konu);
        Konu resultKonu = template.getForEntity(url, Konu.class).getBody();
        String ogretmen = "Numan";
        url = URI.create("http://localhost:8080/ogretmenWS/getByName/" + ogretmen);
        Ogretmen resultOgretmen = template.getForEntity(url, Ogretmen.class).getBody();
        url = URI.create("http://localhost:8080/dersWS/insert");
        if (resultKonu != null && resultOgretmen != null)
        {
            HttpEntity<Ders> entity = new HttpEntity<>(new Ders(resultKonu.getKonu_id(), resultOgretmen.getOgr_id()));
            ResponseEntity<String> result = template.postForEntity(url, entity, String.class);
            System.err.println(result.getBody());
        }
    }
}
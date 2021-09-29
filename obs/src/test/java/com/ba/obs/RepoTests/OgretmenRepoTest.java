package com.ba.obs.RepoTests;

import com.ba.obs.model.Ogretmen;
import com.ba.obs.repo.OgretmenRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName(value = "Ogrenci Repo test")
public class OgretmenRepoTest
{
    @Autowired OgretmenRepository ogretmenRepository;

    @Test
    public void getOgretmenById()
    {
        // jupiter assertions
        Assertions.assertEquals(ogretmenRepository.getById(6), new Ogretmen(6, "Onur"));
    }
}
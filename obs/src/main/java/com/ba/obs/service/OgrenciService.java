package com.ba.obs.service;

import com.ba.obs.model.Ogrenci;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.repo.OgrenciRepository;
import com.ba.obs.repo.OgretmenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor public class OgrenciService
{
    private OgrenciRepository ogrenciRepository;

    public List<Ogrenci> getAll()
    {
        return ogrenciRepository.getAll();
    }

    public Ogrenci getById(int id)
    {
        return ogrenciRepository.getOgrenciById(id);
    }

    public boolean deleteById(int id)
    {
        return ogrenciRepository.deleteById(id);
    }

    public boolean insert(Ogrenci ogrenci)
    {
        return  ogrenciRepository.insert(ogrenci);
    }

}
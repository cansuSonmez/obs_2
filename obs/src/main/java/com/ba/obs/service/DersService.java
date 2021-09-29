package com.ba.obs.service;

import com.ba.obs.dto.DersDTO;
import com.ba.obs.model.Ders;
import com.ba.obs.repo.DersRepository;
import com.ba.obs.repo.KonuRepository;
import com.ba.obs.repo.OgretmenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor public class DersService
{
    private DersRepository dersRepository;
    private KonuRepository konuRepository;
    private OgretmenRepository ogretmenRepository;

    public void insert(Ders ders)
    {
        dersRepository.insert(ders);
    }

    public List<Ders> getAll()
    {
        return dersRepository.getAll();
    }

    public List<DersDTO> getAllDersDTO()
    {
        return dersRepository.getAlldersDTO();
        // veritabanında optimize sorgu yazabiliyorsanız sql ile çözüm bulunabilir
        /*List<DersDTO> liste = new ArrayList<>();
        List<Ders> dersListesi = dersRepository.getAll();
        for (Ders ders : dersListesi)
        {
            String ogretmenName = ogretmenRepository.getById(ders.getOgretmen_id()).getOgr_name();
            String konuName = konuRepository.getById(ders.getKonu_id()).getKonu();
            liste.add(new DersDTO(ders.getDers_id(), ders.getOgretmen_id(), ders.getKonu_id(), ogretmenName, konuName));
        }
        return liste;*/
    }
}
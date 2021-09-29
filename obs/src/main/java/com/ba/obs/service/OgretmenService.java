package com.ba.obs.service;

import com.ba.obs.model.Konu;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.repo.OgretmenRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service @AllArgsConstructor public class OgretmenService
{
    private OgretmenRepository ogretmenRepository;

    public List<Ogretmen> getAll()
    {
        return ogretmenRepository.getAll();
    }

    public Ogretmen getById(int id)
    {
        return ogretmenRepository.getById(id);
    }

    public boolean deleteById(int id)
    {
        return ogretmenRepository.deleteById(id);
    }

    public boolean insert(Ogretmen ogretmen)
    {
        return ogretmenRepository.insert(ogretmen);
    }

    public Ogretmen getOgretmenByName(String name)
    {
        return ogretmenRepository.getOgretmenByName(name);
    }
}
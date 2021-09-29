package com.ba.obs.service;

import com.ba.obs.model.Konu;
import com.ba.obs.repo.KonuRepository;
import com.ba.obs.repo.PagingKonuRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor public class KonuService
{
    private PagingKonuRepository pagingKonuRepository;
    private KonuRepository konuRepository;

    public List<Konu> getKonu(int page)
    {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("konu_id").ascending());
        return pagingKonuRepository.findAll(pageable).toList();
    }

    public int getCount()
    {
        return (int) pagingKonuRepository.count();
    }

    public Konu getKonuByName(String name)
    {
        return konuRepository.getByName(name);
    }

    public List<Konu> getAll()
    {
        return konuRepository.getAll();
    }
}
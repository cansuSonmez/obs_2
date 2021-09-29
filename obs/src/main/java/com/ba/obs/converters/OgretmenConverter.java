package com.ba.obs.converters;

import com.ba.obs.model.Konu;
import com.ba.obs.model.Ogretmen;
import com.ba.obs.repo.KonuRepository;
import com.ba.obs.repo.OgretmenRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class OgretmenConverter implements Converter<Integer, Ogretmen>
{
    private OgretmenRepository repo;

    @Override public Ogretmen convert(Integer source)
    {
        return repo.getById(source);
    }
}
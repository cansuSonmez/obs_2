package com.ba.obs.converters;

import com.ba.obs.model.Ders;
import com.ba.obs.model.Konu;
import com.ba.obs.repo.DersRepository;
import com.ba.obs.repo.KonuRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KonuConverter implements Converter<Integer, Konu>
{
    private KonuRepository repo;

    @Override public Konu convert(Integer source)
    {
        return repo.getById(source);
    }
}
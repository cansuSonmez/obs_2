package com.ba.obs.converters;

import com.ba.obs.model.Ders;
import com.ba.obs.repo.DersRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DersConverter implements Converter<Integer, Ders>
{
    private DersRepository repo;

    @Override public Ders convert(Integer source)
    {
        return repo.getById(source);
    }
}
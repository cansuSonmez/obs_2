package com.ba.obs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Ogrenci
{
    private int id;
    private int number;
    private String name;

    @Override public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Ogrenci ogrenci = (Ogrenci) o;
        return id == ogrenci.id && number == ogrenci.number && Objects.equals(name, ogrenci.name);
    }

    @Override public int hashCode()
    {
        return Objects.hash(id, number, name);
    }
}
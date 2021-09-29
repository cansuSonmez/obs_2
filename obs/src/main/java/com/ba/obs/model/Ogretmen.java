package com.ba.obs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ogretmen {

    private int ogr_id;
    private String ogr_name;

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
        Ogretmen ogretmen = (Ogretmen) o;
        return ogr_id == ogretmen.ogr_id && Objects.equals(ogr_name, ogretmen.ogr_name);
    }

    @Override public int hashCode()
    {
        return Objects.hash(ogr_id, ogr_name);
    }
}
package com.ba.obs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter @NoArgsConstructor public class Ders
{
    private int ders_id;
    private int ogretmen_id;
    //@onetomany
    //private Ogretmen;
    private int konu_id;

    public Ders(int konu_id, int ogretmen_id)
    {
        this.konu_id = konu_id;
        this.ogretmen_id = ogretmen_id;
    }

}
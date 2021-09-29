package com.ba.obs.dto;

import lombok.Getter;

@Getter
public class DersDTO
{
    private int ders_id;
    private int ogretmen_id;
    private int konu_id;
    private String ogretmen_name;
    private String konu_name;

    public DersDTO(int ders_id, int ogretmen_id, int konu_id, String ogretmen_name, String konu_name)
    {
        this.ders_id = ders_id;
        this.ogretmen_id = ogretmen_id;
        this.konu_id = konu_id;
        this.ogretmen_name = ogretmen_name;
        this.konu_name = konu_name;
    }
}
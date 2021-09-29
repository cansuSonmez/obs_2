package com.ba.obs.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter @AllArgsConstructor @NoArgsConstructor
@Table("OBS\".\"KONU")
public class Konu
{
    @Id
    @Column(value = "KONU_ID")
    private int konu_id;
    @Column(value = "KONU")
    private String konu;

}
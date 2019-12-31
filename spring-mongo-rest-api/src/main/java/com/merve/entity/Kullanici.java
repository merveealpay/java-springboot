package com.merve.entity;
//kullanici collection ı

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
@Document //collection
public class Kullanici {
    //kullanici nesnesinin propları
    @Id //primary key muhabbeti
    private String Id;
    private String adi;
    private String soyadi;
    private HashMap ozellikleri; //hashmap, özelliklerin hangi veri türünden oldugunu kestiremiyoruz

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public HashMap getOzellikleri() {
        return ozellikleri;
    }

    public void setOzellikleri(HashMap ozellikleri) {
        this.ozellikleri = ozellikleri;
    }
}

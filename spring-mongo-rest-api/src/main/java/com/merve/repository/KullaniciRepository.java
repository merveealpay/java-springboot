package com.merve.repository;

import com.merve.entity.Kullanici;
import org.springframework.data.mongodb.repository.MongoRepository;

//entity aracılıgıyla veritabanına kaydet vs islemler, springdatamongodb den interface olusturucaz

public interface KullaniciRepository extends MongoRepository<Kullanici, String> {


}

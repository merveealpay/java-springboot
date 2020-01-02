package com.merve.repository;

import com.merve.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
//jpa repositorylerde crud islemleri falan hep var.. biz onları extend alıyoruz
public interface AdresRepository extends JpaRepository<Adres, Long> {
}

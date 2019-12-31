package com.merve.api;

import com.merve.entity.Kullanici;
import com.merve.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RequestMapping("/kullanici")
@RestController
public class KullaniciController {
    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAdi("Merve");
        kullanici.setSoyadi("Alpay");
        kullaniciRepository.save(kullanici);
    }

    @PostMapping
    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici) {
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }
    @GetMapping
    public ResponseEntity<List<Kullanici>> tumunuListele() {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }


}

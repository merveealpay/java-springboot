package com.merve.api;

import com.merve.entity.Kisi;
import com.merve.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.ml.DeleteCalendarEventRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor // lombok hangi fieldlar gerekiyorsa constructorını eklesin
@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setAd("Merve");
        kisi.setSoyad("Alpay");
        kisi.setAdres("test");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("Id5824");
        kisiRepository.save(kisi);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        List<Kisi> kisiler = kisiRepository.getByCustomQuery(search);
        return ResponseEntity.ok(kisiler);
    }
}

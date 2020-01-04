package com.merve.service.Impl;

import com.merve.dto.KisiDto;
import com.merve.entity.Adres;
import com.merve.entity.Kisi;
import com.merve.repository.AdresRepository;
import com.merve.repository.KisiRepository;
import com.merve.service.KisiService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {
    private final  KisiRepository kisiRepository;
    private final AdresRepository adresRepository;


    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        //Assert.isNull(kisiDto.getAd(), "Ad bos birakilamaz.");

        Kisi kisi = new Kisi();
        kisi.setAd(kisiDto.getAd());
        kisi.setSoyad(kisiDto.getSoyad());
        Kisi kisiDb = kisiRepository.save(kisi);

        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdres().forEach(item -> {
                Adres adres = new Adres();
                adres.setAdres(item);
                adres.setAktif(true);
                adres.setAdresTip(Adres.AdresTip.DIGER);
                adres.setKisi(kisiDb);
                liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();

        kisiler.forEach(it ->{
            KisiDto kisiDto = new KisiDto();
            kisiDto.setAd(it.getAd());
            kisiDto.setSoyad(it.getSoyad());
            kisiDto.setAdres(it.getAdres().stream().map(Adres::getAdres).collect(Collectors.toList()));
            kisiDto.setId(it.getId());
            kisiDtos.add(kisiDto);
        });

        return kisiDtos;
    }


    @Override
    public void delete(long id) {


    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}


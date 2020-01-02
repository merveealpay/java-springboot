package com.merve.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Table(name = "kisi")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})

public class Kisi {
    @Id
    @SequenceGenerator(name = "seq_kisi_ad", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_ad", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "ad", length = 100)
    private String ad;

    @Column(name = "soyad", length = 100)
    private String soyad;

    @OneToMany
    @JoinColumn(name = "kisi_id_adres")
    private List<Adres> adresler;
}

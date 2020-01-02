package com.merve.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "kisi_adres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Adres implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kisi_adres", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "adres", length = 500)
    private String adres;

    @Column(name = "aktif")
    private Boolean aktif;

    @Enumerated
    AdresTipi adresTipi;

    @ManyToOne
    @JoinColumn(name = "kisi_id_adres")
    private Kisi kisi;

    enum AdresTipi{
        EV_ADRESİ,
        IS_ADRESİ,
        DIGER

    }

}

package com.merve.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString

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
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adres;
}

package com.merve.dto;
//kendi entitylerimizi api olarak dısarı acmak istemeyiz o yüzden dısarıda calıstıklarımız ile icerdeki farklı olur, esneklik kazandırsın diye aslında.
//arka tarafta yönetmek istedigin seyleri entityde tanımlarız
import com.merve.entity.Adres;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data //dökümantasyonuna bak
public class KisiDto {

    private long id;
    private String ad;
    private String soyad;
    private List<String> adres;
}

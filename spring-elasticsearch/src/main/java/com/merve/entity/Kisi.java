package com.merve.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
@Document(indexName = "kisiler", type = "kisi")
//lombok sayesinde tüm field'lara bu getter setter ları uygula diyebiliyoruz
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Kisi {

    @Id
    private String id;

    @Field(name = "ad", type = FieldType.Text)
    private String ad;

    @Field(name = "soyad", type = FieldType.Text)
    private String soyad;

    @Field(name = "adres", type = FieldType.Text)
    private String adres;

    @Field(name = "dogum tarihi", type = FieldType.Text)
    private Date dogumTarihi;
}

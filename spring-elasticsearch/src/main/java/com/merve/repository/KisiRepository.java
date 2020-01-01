package com.merve.repository;

import com.merve.entity.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KisiRepository extends ElasticsearchRepository<Kisi, String>{

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}") //sadece adı örtüsen gelsin
    List<Kisi> getByCustomQuery(String search);,
    //test icin: http://localhost:8080/kisi/merve

}

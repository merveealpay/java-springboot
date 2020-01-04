package com.merve.service;

import com.merve.dto.KisiDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//dto'larla calisacak.

public interface KisiService {
    void delete(long id);
    KisiDto save(KisiDto kisiDto);
    List<KisiDto> getAll();
    Page<KisiDto> getAll(Pageable pageable);
}

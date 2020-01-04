package com.merve.controller;

import com.merve.dto.KisiDto;
import com.merve.service.KisiService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiController {
    private final KisiService kisiService;

    @PostMapping
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }
    @GetMapping
    public ResponseEntity<List<KisiDto>> tumunuListele() {
        return ResponseEntity.ok(kisiService.getAll());
    }


}

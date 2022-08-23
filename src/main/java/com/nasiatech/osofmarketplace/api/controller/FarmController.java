package com.nasiatech.osofmarketplace.api.controller;

import com.nasiatech.osofmarketplace.api.dto.FarmDto;
import com.nasiatech.osofmarketplace.business.service.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/farm")
public class FarmController {
    private final FarmService farmService;

    @GetMapping
    public ResponseEntity<List<FarmDto>> getAll() {
        return ResponseEntity.ok(farmService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(farmService.getById(id));
    }

}

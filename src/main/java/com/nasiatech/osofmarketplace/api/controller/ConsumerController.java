package com.nasiatech.osofmarketplace.api.controller;


import com.nasiatech.osofmarketplace.api.dto.ConsumerDto;
import com.nasiatech.osofmarketplace.business.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/consumer")
public class ConsumerController {
    private final ConsumerService consumerService;

    @GetMapping
    public ResponseEntity<List<ConsumerDto>> getAll() {
        return ResponseEntity.ok(consumerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumerDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(consumerService.getById(id));
    }
}

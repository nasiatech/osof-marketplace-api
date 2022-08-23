package com.nasiatech.osofmarketplace.api.controller;


import com.nasiatech.osofmarketplace.api.dto.FarmerDto;
import com.nasiatech.osofmarketplace.business.service.FarmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/farmer")
public class FarmerController {
    private final FarmerService farmerService;

    @GetMapping
    public ResponseEntity<List<FarmerDto>> getAll() {
        return ResponseEntity.ok(farmerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(farmerService.getById(id));
    }
}

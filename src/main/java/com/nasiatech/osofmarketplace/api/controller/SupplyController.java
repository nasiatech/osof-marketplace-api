package com.nasiatech.osofmarketplace.api.controller;


import com.nasiatech.osofmarketplace.api.dto.SupplyDto;
import com.nasiatech.osofmarketplace.business.service.SupplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supply")
public class SupplyController {
    private final SupplyService supplyService;

    @GetMapping
    public ResponseEntity<List<SupplyDto>> getAll() {
        return ResponseEntity.ok(supplyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplyDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(supplyService.getById(id));
    }
}

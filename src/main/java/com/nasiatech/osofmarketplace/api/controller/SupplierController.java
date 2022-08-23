package com.nasiatech.osofmarketplace.api.controller;


import com.nasiatech.osofmarketplace.api.dto.SupplierDto;
import com.nasiatech.osofmarketplace.business.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supplier")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAll() {
        return ResponseEntity.ok(supplierService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(supplierService.getById(id));
    }
}

package com.nasiatech.osofmarketplace.api.controller;

import com.nasiatech.osofmarketplace.api.dto.AddressDto;
import com.nasiatech.osofmarketplace.business.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;
    
    @GetMapping
    public ResponseEntity<List<AddressDto>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.getById(id));
    }
}

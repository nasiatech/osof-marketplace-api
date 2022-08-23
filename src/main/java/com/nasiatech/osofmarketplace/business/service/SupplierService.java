package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.SupplierDto;
import com.nasiatech.osofmarketplace.api.dto.SupplierDto;
import com.nasiatech.osofmarketplace.business.mapper.SupplierMapper;
import com.nasiatech.osofmarketplace.data.entity.Supplier;
import com.nasiatech.osofmarketplace.data.repo.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    public List<SupplierDto> getAll() {
        return supplierRepository.findAll().stream().map(supplierMapper::supplierToSupplierDto).toList();
    }

    public SupplierDto getById(Integer id) {
        return supplierMapper.supplierToSupplierDto(getEntityById(id));
    }

    public Supplier getEntityById(Integer id) {
        return supplierRepository.findById(id).orElse(null);
    }
}

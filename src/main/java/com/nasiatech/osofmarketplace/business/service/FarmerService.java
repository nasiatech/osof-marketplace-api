package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.FarmerDto;
import com.nasiatech.osofmarketplace.api.dto.FarmerDto;
import com.nasiatech.osofmarketplace.business.mapper.FarmerMapper;
import com.nasiatech.osofmarketplace.data.entity.Farmer;
import com.nasiatech.osofmarketplace.data.repo.FarmerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmerService {
    private final FarmerRepository farmerRepository;
    private final FarmerMapper farmerMapper;
    public List<FarmerDto> getAll() {
        return farmerRepository.findAll().stream().map(farmerMapper::farmerToFarmerDto).toList();
    }

    public FarmerDto getById(Integer id) {
        return farmerMapper.farmerToFarmerDto(getEntityById(id));
    }

    public Farmer getEntityById(Integer id) {
        return farmerRepository.findById(id).orElse(null);
    }
}

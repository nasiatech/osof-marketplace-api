package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.FarmDto;
import com.nasiatech.osofmarketplace.api.dto.FarmDto;
import com.nasiatech.osofmarketplace.business.mapper.FarmMapper;
import com.nasiatech.osofmarketplace.data.entity.Farm;
import com.nasiatech.osofmarketplace.data.repo.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FarmService {
    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;
    public List<FarmDto> getAll() {
        return farmRepository.findAll().stream().map(farmMapper::farmToFarmDto).toList();
    }

    public FarmDto getById(Integer id) {
        return farmMapper.farmToFarmDto(getEntityById(id));
    }

    public Farm getEntityById(Integer id) {
        return farmRepository.findById(id).orElse(null);
    }
}

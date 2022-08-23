package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.SupplyDto;
import com.nasiatech.osofmarketplace.api.dto.SupplyDto;
import com.nasiatech.osofmarketplace.business.mapper.SupplyMapper;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import com.nasiatech.osofmarketplace.data.repo.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyService {
    private final SupplyRepository supplyRepository;
    private final SupplyMapper supplyMapper;
    public List<SupplyDto> getAll() {
        return supplyRepository.findAll().stream().map(supplyMapper::supplyToSupplyDto).toList();
    }

    public SupplyDto getById(Integer id) {
        return supplyMapper.supplyToSupplyDto(getEntityById(id));
    }

    public Supply getEntityById(Integer id) {
        return supplyRepository.findById(id).orElse(null);
    }
}

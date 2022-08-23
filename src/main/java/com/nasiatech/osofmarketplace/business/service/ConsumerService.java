package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.ConsumerDto;
import com.nasiatech.osofmarketplace.api.dto.CategoryDto;
import com.nasiatech.osofmarketplace.api.dto.ConsumerDto;
import com.nasiatech.osofmarketplace.business.mapper.ConsumerMapper;
import com.nasiatech.osofmarketplace.data.entity.Consumer;
import com.nasiatech.osofmarketplace.data.repo.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumerService {
    private final ConsumerRepository consumerRepository;
    private final ConsumerMapper consumerMapper;
    public List<ConsumerDto> getAll() {
        return consumerRepository.findAll().stream().map(consumerMapper::consumerToConsumerDto).toList();
    }

    public ConsumerDto getById(Integer id) {
        return consumerMapper.consumerToConsumerDto(getEntityById(id));
    }

    public Consumer getEntityById(Integer id) {
        return consumerRepository.findById(id).orElse(null);
    }
}

package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.ToolDto;
import com.nasiatech.osofmarketplace.api.dto.ToolDto;
import com.nasiatech.osofmarketplace.business.mapper.ToolMapper;
import com.nasiatech.osofmarketplace.data.entity.Tool;
import com.nasiatech.osofmarketplace.data.repo.ToolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolService {
    private final ToolRepository toolRepository;
    private final ToolMapper toolMapper;
    public List<ToolDto> getAll() {
        return toolRepository.findAll().stream().map(toolMapper::toolToToolDto).toList();
    }

    public ToolDto getById(Integer id) {
        return toolMapper.toolToToolDto(getEntityById(id));
    }

    public Tool getEntityById(Integer id) {
        return toolRepository.findById(id).orElse(null);
    }
}

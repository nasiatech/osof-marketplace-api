package com.nasiatech.osofmarketplace.business.service;


import com.nasiatech.osofmarketplace.api.dto.CategoryDto;
import com.nasiatech.osofmarketplace.api.dto.CategoryDto;
import com.nasiatech.osofmarketplace.business.mapper.CategoryMapper;
import com.nasiatech.osofmarketplace.data.entity.Category;
import com.nasiatech.osofmarketplace.data.repo.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto).toList();
    }

    public CategoryDto getById(Integer id) {
        return categoryMapper.categoryToCategoryDto(getEntityById(id));
    }

    public Category getEntityById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }
}

package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.CategoryDto;
import com.nasiatech.osofmarketplace.data.entity.Category;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CategoryMapper {
    Category categoryDtoToCategory(CategoryDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromCategoryDto(CategoryDto categoryDto, @MappingTarget Category category);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

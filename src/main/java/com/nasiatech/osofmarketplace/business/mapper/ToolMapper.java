package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.ToolDto;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import com.nasiatech.osofmarketplace.data.entity.Tool;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ToolMapper {
    @Mapping(source = "farmerId", target = "farmer.id")
    Tool toolDtoToTool(ToolDto toolDto);

    @Mapping(source = "farmer.id", target = "farmerId")
    ToolDto toolToToolDto(Tool tool);

    @Mapping(source = "farmerId", target = "farmer.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Tool updateToolFromToolDto(ToolDto toolDto, @MappingTarget Tool tool);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

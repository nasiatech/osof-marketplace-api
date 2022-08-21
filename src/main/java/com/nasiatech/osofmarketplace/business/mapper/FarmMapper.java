package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.FarmDto;
import com.nasiatech.osofmarketplace.data.entity.Farm;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FarmMapper {
    @Mapping(source = "farmerId", target = "farmer.id")
    Farm farmDtoToFarm(FarmDto farmDto);

    @Mapping(source = "farmer.id", target = "farmerId")
    FarmDto farmToFarmDto(Farm farm);

    @Mapping(source = "farmerId", target = "farmer.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Farm updateFarmFromFarmDto(FarmDto farmDto, @MappingTarget Farm farm);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

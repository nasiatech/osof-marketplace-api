package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.FarmerDto;
import com.nasiatech.osofmarketplace.data.entity.Farmer;
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
public interface FarmerMapper {
    @Mapping(source = "userId", target = "user.id")
    Farmer farmerDtoToFarmer(FarmerDto farmerDto);

    @Mapping(source = "user.id", target = "userId")
    FarmerDto farmerToFarmerDto(Farmer farmer);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Farmer updateFarmerFromFarmerDto(FarmerDto farmerDto, @MappingTarget Farmer farmer);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

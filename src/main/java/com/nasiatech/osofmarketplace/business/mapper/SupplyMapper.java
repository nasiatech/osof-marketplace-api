package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.SupplyDto;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SupplyMapper {
    @Mapping(source = "supplierId", target = "supplier.id")
    Supply supplyDtoToSupply(SupplyDto supplyDto);

    @Mapping(source = "supplier.id", target = "supplierId")
    SupplyDto supplyToSupplyDto(Supply supply);

    @Mapping(source = "supplierId", target = "supplier.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Supply updateSupplyFromSupplyDto(SupplyDto supplyDto, @MappingTarget Supply supply);
}

package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.SupplierDto;
import com.nasiatech.osofmarketplace.data.entity.Supplier;
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
public interface SupplierMapper {
    @Mapping(source = "userId", target = "user.id")
    Supplier supplierDtoToSupplier(SupplierDto supplierDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "supplyIds", expression = "java(suppliesToSupplyIds(supplier.getSupplies()))")
    SupplierDto supplierToSupplierDto(Supplier supplier);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Supplier updateSupplierFromSupplierDto(SupplierDto supplierDto, @MappingTarget Supplier supplier);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

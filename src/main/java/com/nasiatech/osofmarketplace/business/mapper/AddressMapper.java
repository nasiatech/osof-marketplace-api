package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.AddressDto;
import com.nasiatech.osofmarketplace.data.entity.Address;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {
    @Mapping(source = "userId", target = "user.id")
    Address addressDtoToAddress(AddressDto addressDto);

    @Mapping(source = "user.id", target = "userId")
    AddressDto addressToAddressDto(Address address);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address updateAddressFromAddressDto(AddressDto addressDto, @MappingTarget Address address);
}

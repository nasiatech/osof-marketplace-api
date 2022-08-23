package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.UserDto;
import com.nasiatech.osofmarketplace.data.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "supplierId", target = "supplier.id")
    @Mapping(source = "farmerId", target = "farmer.id")
    @Mapping(source = "consumerId", target = "consumer.id")
    @Mapping(source = "addressId", target = "address.id")
    @Mapping(source = "cartId", target = "cart.id")
    User userDtoToUser(UserDto userDto);

    @InheritInverseConfiguration(name = "userDtoToUser")
    UserDto userToUserDto(User user);

    @InheritConfiguration(name = "userDtoToUser")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserDto(UserDto userDto, @MappingTarget User user);
}

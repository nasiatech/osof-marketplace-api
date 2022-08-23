package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.CartDto;
import com.nasiatech.osofmarketplace.data.entity.Cart;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CartMapper {
    @Mapping(source = "userId", target = "user.id")
    Cart cartDtoToCart(CartDto cartDto);

    @Mapping(source = "user.id", target = "userId")
    CartDto cartToCartDto(Cart cart);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cart updateCartFromCartDto(CartDto cartDto, @MappingTarget Cart cart);
}

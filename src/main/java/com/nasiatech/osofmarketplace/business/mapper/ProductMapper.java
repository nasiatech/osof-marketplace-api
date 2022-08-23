package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.ProductDto;
import com.nasiatech.osofmarketplace.data.entity.Product;
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
public interface ProductMapper {
    @Mapping(source = "farmerId", target = "farmer.id")
    Product productDtoToProduct(ProductDto productDto);

    @Mapping(source = "farmer.id", target = "farmerId")
    ProductDto productToProductDto(Product product);

    @Mapping(source = "farmerId", target = "farmer.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateProductFromProductDto(ProductDto productDto, @MappingTarget Product product);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

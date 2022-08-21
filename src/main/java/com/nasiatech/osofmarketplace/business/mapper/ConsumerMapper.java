package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.ConsumerDto;
import com.nasiatech.osofmarketplace.data.entity.Consumer;
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
public interface ConsumerMapper {
    @Mapping(source = "userId", target = "user.id")
    Consumer consumerDtoToConsumer(ConsumerDto consumerDto);

    @Mapping(source = "user.id", target = "userId")
    ConsumerDto consumerToConsumerDto(Consumer consumer);

    @Mapping(source = "userId", target = "user.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Consumer updateConsumerFromConsumerDto(ConsumerDto consumerDto, @MappingTarget Consumer consumer);

    default Set<Integer> suppliesToSupplyIds(Set<Supply> supplies) {
        return supplies.stream().map(Supply::getId).collect(Collectors.toSet());
    }
}

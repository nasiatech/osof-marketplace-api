package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.AddressDto;
import com.nasiatech.osofmarketplace.business.mapper.AddressMapper;
import com.nasiatech.osofmarketplace.data.entity.Address;
import com.nasiatech.osofmarketplace.data.repo.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    public List<AddressDto> getAll() {
        return addressRepository.findAll().stream().map(addressMapper::addressToAddressDto).toList();
    }

    public AddressDto getById(Integer id) {
        return addressMapper.addressToAddressDto(getEntityById(id));
    }

    public Address getEntityById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }
}

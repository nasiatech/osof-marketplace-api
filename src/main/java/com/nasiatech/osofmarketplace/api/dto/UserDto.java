package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;

public record UserDto(Integer id, String name, Integer addressId, Integer supplierId, Integer farmerId,
                      Integer consumerId) implements Serializable {
}

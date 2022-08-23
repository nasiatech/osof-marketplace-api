package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;

public record UserDto(Integer id, String username, String password, String phone, String email, String name,
                      Integer supplierId, Integer farmerId, Integer consumerId, Integer addressId,
                      Long cartId) implements Serializable {
}

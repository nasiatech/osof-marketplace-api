package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;

public record AddressDto(Integer id, String name, String latitude, String longitude, String town, String city,
                         String region, String country, Integer userId) implements Serializable {
}

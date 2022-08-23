package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;

public record FarmDto(Integer id, String name, Integer farmerId) implements Serializable {
}

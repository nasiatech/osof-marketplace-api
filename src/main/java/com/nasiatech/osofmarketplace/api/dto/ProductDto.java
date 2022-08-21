package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;

public record ProductDto(Integer id, String name, Integer farmId) implements Serializable {
}

package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;
import java.util.Set;

public record ProductDto(Integer id, String name, Integer farmerId, Set<CategoryDto> categories) implements Serializable {
}

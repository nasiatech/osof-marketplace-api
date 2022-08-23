package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;
import java.util.Set;

public record SupplyDto(Integer id, String name, Integer supplierId,
                        Set<CategoryDto> categories) implements Serializable {
}

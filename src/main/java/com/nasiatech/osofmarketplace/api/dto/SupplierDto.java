package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;
import java.util.Set;

public record SupplierDto(Integer id, Integer userId, Set<Integer> supplyIds) implements Serializable {
}

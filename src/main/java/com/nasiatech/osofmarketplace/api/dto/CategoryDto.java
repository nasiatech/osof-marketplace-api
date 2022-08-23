package com.nasiatech.osofmarketplace.api.dto;

import com.nasiatech.osofmarketplace.data.enums.CategoryType;

import java.io.Serializable;

public record CategoryDto(Integer id, String name, CategoryType type) implements Serializable {
}

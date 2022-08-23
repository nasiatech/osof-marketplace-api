package com.nasiatech.osofmarketplace.api.dto;

import java.io.Serializable;

public record CartDto(Long id, Integer userId) implements Serializable {
}

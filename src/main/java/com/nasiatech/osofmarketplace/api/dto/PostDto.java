package com.nasiatech.osofmarketplace.api.dto;

import com.nasiatech.osofmarketplace.data.enums.PostType;

import java.io.Serializable;
import java.time.LocalDateTime;

public record PostDto(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt,
                      PostType type) implements Serializable {
}

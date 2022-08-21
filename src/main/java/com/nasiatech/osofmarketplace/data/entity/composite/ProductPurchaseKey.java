package com.nasiatech.osofmarketplace.data.entity.composite;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductPurchaseKey implements Serializable {
    private static final long serialVersionUID = 7944434424415555137L;
    private Integer productId;
    private Integer consumerId;
}

package com.nasiatech.osofmarketplace.data.entity.composite;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
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
public class SupplyPurchaseKey implements Serializable {
    private Integer supplyId;
    private Integer farmerId;
}

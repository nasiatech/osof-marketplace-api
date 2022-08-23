package com.nasiatech.osofmarketplace.data.entity.relation;

import com.nasiatech.osofmarketplace.data.entity.Farmer;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "osof_supply_purchase")
public class SupplyPurchase {
    @EmbeddedId
    private SupplyPurchaseKey key;

    @MapsId("supplyId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "supply_id", nullable = false)
    private Supply supply;

    @MapsId("farmerId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "farmer_id", nullable = false)
    private Farmer farmer;

    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SupplyPurchaseKey implements Serializable {
        private Integer supplyId;
        private Integer farmerId;
    }
}

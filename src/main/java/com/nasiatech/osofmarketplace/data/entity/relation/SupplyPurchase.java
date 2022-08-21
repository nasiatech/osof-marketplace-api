package com.nasiatech.osofmarketplace.data.entity.relation;

import com.nasiatech.osofmarketplace.data.entity.Farmer;
import com.nasiatech.osofmarketplace.data.entity.Supply;
import com.nasiatech.osofmarketplace.data.entity.composite.SupplyPurchaseKey;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

}

package com.nasiatech.osofmarketplace.data.entity.relation;

import com.nasiatech.osofmarketplace.data.entity.Consumer;
import com.nasiatech.osofmarketplace.data.entity.Product;
import com.nasiatech.osofmarketplace.data.entity.composite.ProductPurchaseKey;
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
public class ProductPurchase {
    @EmbeddedId
    private ProductPurchaseKey key;

    @MapsId("productId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @MapsId("consumerId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "consumer_id", nullable = false)
    private Consumer consumer;

}


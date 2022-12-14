package com.nasiatech.osofmarketplace.data.entity.relation;

import com.nasiatech.osofmarketplace.data.entity.Consumer;
import com.nasiatech.osofmarketplace.data.entity.Product;
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

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "osof_product_purchase")
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

    @Getter
    @Setter
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class ProductPurchaseKey implements Serializable {
        @Serial
        private static final long serialVersionUID = 7944434424415555137L;
        private Integer productId;
        private Integer consumerId;
    }

}


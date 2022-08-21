package com.nasiatech.osofmarketplace.data.entity;

import com.nasiatech.osofmarketplace.data.entity.relation.ProductPurchase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Consumer{
    @Id
    private Integer id;

    @OneToOne(mappedBy = "consumer", orphanRemoval = true)
    private User user;

    @OneToMany(mappedBy = "consumer", orphanRemoval = true)
    private Set<ProductPurchase> productPurchases = new LinkedHashSet<>();

}

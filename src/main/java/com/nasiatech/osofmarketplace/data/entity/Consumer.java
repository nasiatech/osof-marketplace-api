package com.nasiatech.osofmarketplace.data.entity;

import com.nasiatech.osofmarketplace.data.entity.relation.ProductPurchase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "osof_consumer")
public class Consumer{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "consumer", orphanRemoval = true)
    private User user;

    @OneToMany(mappedBy = "consumer", orphanRemoval = true)
    private Set<ProductPurchase> productPurchases = new LinkedHashSet<>();

}

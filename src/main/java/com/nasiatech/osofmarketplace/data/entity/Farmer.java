package com.nasiatech.osofmarketplace.data.entity;

import com.nasiatech.osofmarketplace.data.entity.relation.SupplyPurchase;
import jakarta.persistence.CascadeType;
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
public class Farmer{
    @Id
    private Integer id;

    @OneToOne(mappedBy = "farmer", orphanRemoval = true)
    private User user;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tool> tools = new LinkedHashSet<>();

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Farm> farms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "farmer", orphanRemoval = true)
    private Set<SupplyPurchase> supplyPurchases = new LinkedHashSet<>();

}

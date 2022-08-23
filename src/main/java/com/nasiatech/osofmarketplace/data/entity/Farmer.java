package com.nasiatech.osofmarketplace.data.entity;

import com.nasiatech.osofmarketplace.data.entity.relation.SupplyPurchase;
import com.nasiatech.osofmarketplace.data.entity.relation.ToolRent;
import jakarta.persistence.CascadeType;
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
@Entity @Table(name = "osof_farmer")
public class Farmer{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "farmer", orphanRemoval = true)
    private User user;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Tool> tools = new LinkedHashSet<>();

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Farm> farms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "farmer", orphanRemoval = true)
    private Set<SupplyPurchase> supplyPurchases = new LinkedHashSet<>();

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ToolRent> toolRents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new LinkedHashSet<>();

}

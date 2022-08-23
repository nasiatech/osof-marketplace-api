package com.nasiatech.osofmarketplace.data.entity;

import com.nasiatech.osofmarketplace.data.enums.CategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Entity @Table(name = "osof_category")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Supply> supplies = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CategoryType type;

    @OneToMany(orphanRemoval = true, mappedBy = "parent")
    private Set<Category> subCategories = new LinkedHashSet<>();

    @ManyToOne()
    @JoinColumn(name = "parent_id")
    private Category parent;

}

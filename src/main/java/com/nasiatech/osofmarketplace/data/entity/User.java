package com.nasiatech.osofmarketplace.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "osof_user")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 64)
    private String username;
    private String password;

    @Column(nullable = false, unique = true, length = 64)
    private String phone;

    @Column(nullable = false, unique = true, length = 64)
    private String email;

    @Column(name = "name", nullable = false, length = 128)
    private String name;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "consumer_id")
    private Consumer consumer;



    @OneToOne(mappedBy = "user", orphanRemoval = true)
    private Cart cart;



    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Post> posts = new LinkedHashSet<>();


    @OneToOne(mappedBy = "user", orphanRemoval = true)
    private Address address;

}

package com.nasiatech.osofmarketplace.data.repo;

import com.nasiatech.osofmarketplace.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

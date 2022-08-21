package com.nasiatech.osofmarketplace.data.repo;

import com.nasiatech.osofmarketplace.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

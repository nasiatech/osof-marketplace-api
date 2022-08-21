package com.nasiatech.osofmarketplace.data.repo;

import com.nasiatech.osofmarketplace.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

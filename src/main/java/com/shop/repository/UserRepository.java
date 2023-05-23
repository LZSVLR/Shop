package com.shop.repository;

import com.shop.dto.Product;
import com.shop.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

package com.shop.repository;

import com.shop.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  ProductRepository extends JpaRepository<Product, UUID>
{

}

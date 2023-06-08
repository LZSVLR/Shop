package com.shop.repository;

import com.shop.entity.Client;
import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    @Modifying
    @Transactional
    @Query("UPDATE Item i set i.name = :name WHERE i.id = :id")
    void updateNameById(@Param("name") String name, @Param("id") UUID id);
}

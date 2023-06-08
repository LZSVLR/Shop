package com.shop.repository;

import com.shop.entity.Client;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

  @Modifying
  @Transactional
  @Query("UPDATE Client c set c.name = :name WHERE c.id = :id")
  void updateNameById(@Param("name") String name, @Param("id") UUID id);

}

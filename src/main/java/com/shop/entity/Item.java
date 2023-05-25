package com.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import java.util.UUID;
import lombok.Data;

;

@Entity
@Table(name = "items")
@Data
public class Item {
  @Id
  @Column(name = "id")
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private Double price;

  @ManyToMany(mappedBy = "items")
  private Set<Client> clients;

}

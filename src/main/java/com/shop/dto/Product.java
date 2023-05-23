package com.shop.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text") //  255 сим.
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "value")
    private int value;
//    @Column(name= "user")
//    private User user;

}

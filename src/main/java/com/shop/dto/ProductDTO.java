package com.shop.dto;

// Для чего нужен DTO?
// Передача данных в запрос?  Один из шаблонов проектирования, используется для передачи данных
// между подсистемами приложения. Data Transfer Object, в отличие от business object или data access object
// не должен содержать какого-либо поведения

import lombok.Data;

@Data
public class ProductDTO {

    private String title;
    private String description;
    private int price;
    private int value;
    private Long categoryId;
}
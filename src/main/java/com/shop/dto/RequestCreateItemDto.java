package com.shop.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestCreateItemDto {
    private String name;
    private Double price;
}

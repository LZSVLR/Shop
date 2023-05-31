package com.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class RequestUpdateItemDto {
    private UUID id;
    private String name;
    private Double price;
}

package com.shop.dto;

import com.shop.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class ResponseItemDto {
    private UUID id;
    private String name;
    private Double price;
}

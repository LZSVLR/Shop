package com.shop.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class RequestUpdateClientDto {
    private UUID id;
    private String name;
}

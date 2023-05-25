package com.shop.dto;

import com.shop.entity.Item;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseClientDto {
  private UUID id;
  private String name;
  private List<Item> items;
}

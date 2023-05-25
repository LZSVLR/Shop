package com.shop.mapper;


import com.shop.dto.RequestCreateClientDto;
import com.shop.dto.ResponseClientDto;
import com.shop.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

  public ResponseClientDto map(Client client) {
    return ResponseClientDto.builder()
        .id(client.getId())
        .name(client.getName())
        .build();
  }

  public Client map(RequestCreateClientDto requestCreateClientDto) {
    return Client.builder()
        .name(requestCreateClientDto.getName())
        .build();
  }
}

package com.shop.mapper;


import com.shop.dto.ClientDto;

import com.shop.entity.Client;
import org.springframework.stereotype.Component;

@Component
//map struct
public class ClientMapper {

  //Преобразует клиента в ДТОшку
  public ClientDto map(Client client) {
    return ClientDto.builder()
        .id(client.getId())
        .name(client.getName())
        .build();
  }

  //Преобразует переданную стороннюю ДТОшку в клиента
  public Client map(ClientDto requestCreateClientDto) {
    return Client.builder()
        .name(requestCreateClientDto.getName())
        .build();
  }
}

package com.shop.mapper;


import com.shop.dto.RequestCreateClientDto;
import com.shop.dto.RequestUpdateClientDto;
import com.shop.dto.ResponseClientDto;
import com.shop.entity.Client;
import org.springframework.stereotype.Component;

@Component
//map struct
public class ClientMapper {

  //Преобразует клиента в ДТОшку
  public ResponseClientDto map(Client client) {
    return ResponseClientDto.builder()
        .id(client.getId())
        .name(client.getName())
        .build();
  }

  //Преобразует переданную стороннюю ДТОшку в клиента
  public Client map(RequestCreateClientDto requestCreateClientDto) {
    return Client.builder()
        .name(requestCreateClientDto.getName())
        .build();
  }
  public Client map(RequestUpdateClientDto requestUpdateClientDto) {
    return Client.builder()
            .name(requestUpdateClientDto.getName())
            .build();
  }

}

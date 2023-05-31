package com.shop.service;

import com.shop.dto.RequestCreateClientDto;
import com.shop.dto.RequestUpdateClientDto;
import com.shop.dto.ResponseClientDto;
import com.shop.entity.Client;
import com.shop.mapper.ClientMapper;
import com.shop.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper;


  //создание клиента
  public ResponseClientDto createClient(RequestCreateClientDto createClientDto) {
    Client created = clientRepository.save(clientMapper.map(createClientDto));
    return clientMapper.map(created);
  }

  //вывод объектов базы данных в виде дто списком
  public List<ResponseClientDto> showClients()
  {
    return clientRepository.findAll().stream().map(clientMapper::map).collect(Collectors.toList());
  }
  //обновление клиента
  public ResponseClientDto updateClient(RequestUpdateClientDto updateClientDto)
  {
    //можно через if
    Client updated = clientRepository.findById(updateClientDto.getId()).orElse(null);
    assert updated != null;
    updated.setName(updateClientDto.getName());
    clientRepository.save(updated);
    return clientMapper.map(updated);
  }
  //удаление клиента
  public void delete(UUID id){clientRepository.deleteById(id);}
}


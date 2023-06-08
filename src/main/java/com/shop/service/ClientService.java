package com.shop.service;

import com.shop.dto.ClientDto;

import com.shop.entity.Client;
import com.shop.exception.EntityNotFoundException;
import com.shop.mapper.ClientMapper;
import com.shop.repository.ClientRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper;



  //создание клиента
  public ClientDto createClient(ClientDto createClientDto) {
    Client created = clientRepository.save(clientMapper.map(createClientDto));
    return clientMapper.map(created);
  }

  //вывод объектов базы данных в виде дто списком
  public List<ClientDto> showClients() {
    return clientRepository.findAll().stream().map(clientMapper::map).collect(Collectors.toList());
  }
  //обновление клиента
  @Transactional
  public ClientDto updateClient(ClientDto updateClientDto)
  {
    //не проходит проверка
    if(clientRepository.findById(updateClientDto.getId()).isEmpty())
    {
      throw new EntityNotFoundException("Invalid ID, client was not found.");
    }
   clientRepository.updateNameById(updateClientDto.getName(), updateClientDto.getId());

    return updateClientDto;
  }
  //удаление клиента
  public void delete(UUID id){clientRepository.deleteById(id);}
}


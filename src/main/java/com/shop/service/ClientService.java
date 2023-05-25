package com.shop.service;

import com.shop.dto.RequestCreateClientDto;
import com.shop.dto.ResponseClientDto;
import com.shop.entity.Client;
import com.shop.mapper.ClientMapper;
import com.shop.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

  private final ClientRepository clientRepository;
  private final ClientMapper clientMapper;

  public ResponseClientDto createClient(RequestCreateClientDto createClientDto) {
    Client created = clientRepository.save(clientMapper.map(createClientDto));
    return clientMapper.map(created);
  }
}


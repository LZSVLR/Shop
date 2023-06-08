package com.shop.controllers;

import com.shop.dto.ClientDto;

import com.shop.exception.CreateValidationException;
import com.shop.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

  private final ClientService clientService;

  //Spring Error Handler for Http (ResponseEntity)
  @PostMapping
  public ResponseEntity<ClientDto> create(@RequestBody
                                                  ClientDto createClientDto)  {
    if(createClientDto.getName() == null)
    {
      throw new CreateValidationException("Name can't be null");
    }

    // обработать кейс,когда имя клиента == null.
    // Сделать  это через ErrorHandler и custom exception

    return ResponseEntity.ok(clientService.createClient(createClientDto));
  }

  //Обновление
  @Transactional
  @PutMapping
  public ResponseEntity<ClientDto> update(@RequestBody ClientDto updateClient)
  {

    return ResponseEntity.ok(clientService.updateClient(updateClient));
  }

  //Удаление
  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable UUID id)
  {
      clientService.delete(id);
      return ResponseEntity.ok("User successfully deleted!"+" ID: "+id);
  }
  //Вывод всех
  @GetMapping
  public ResponseEntity<List<ClientDto>> showClients()
  {
    return ResponseEntity.ok(clientService.showClients());
  }
}

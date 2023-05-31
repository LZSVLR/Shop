package com.shop.controllers;

import com.shop.dto.RequestCreateClientDto;
import com.shop.dto.RequestUpdateClientDto;
import com.shop.dto.ResponseClientDto;
import com.shop.entity.Client;
import com.shop.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

  private final ClientService clientService;

  @PostMapping
  public ResponseEntity<ResponseClientDto> create(@RequestBody
                                                  RequestCreateClientDto createClientDto) {
    return ResponseEntity.ok(clientService.createClient(createClientDto));
  }

  //Обновление
  @PutMapping
  public ResponseEntity<ResponseClientDto> update(@RequestBody RequestUpdateClientDto updateClient)
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
  public ResponseEntity<List<ResponseClientDto>> showClients()
  {
    return ResponseEntity.ok(clientService.showClients());
  }
}

package com.shop.controllers;

import com.shop.dto.RequestCreateClientDto;
import com.shop.dto.ResponseClientDto;
import com.shop.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

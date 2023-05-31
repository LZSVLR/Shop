package com.shop.controllers;

import com.shop.dto.*;
import com.shop.service.ClientService;
import com.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ResponseItemDto> create(@RequestBody
                                                    RequestCreateItemDto createItemDto) {
        return ResponseEntity.ok(itemService.createItem(createItemDto));
    }

    //Обновление
    @PutMapping
    public ResponseEntity<ResponseItemDto> update(@RequestBody RequestUpdateItemDto updateItem)
    {
        return ResponseEntity.ok(itemService.updateItem(updateItem));
    }

    //Удаление
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
    {
        itemService.delete(id);
        return ResponseEntity.ok("Item successfully deleted!"+" ID: "+id);
    }
    //Вывод всех
    @GetMapping
    public ResponseEntity<List<ResponseItemDto>> showItems()
    {
        return ResponseEntity.ok(itemService.showItems());
    }
}

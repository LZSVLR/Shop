package com.shop.controllers;

import com.shop.dto.*;
import com.shop.exception.CreateValidationException;
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
    public ResponseEntity<ItemDto> create(@RequestBody
                                                    ItemDto createItemDto) {
        if(createItemDto.getName() == null)
        {
            throw new CreateValidationException("Name can't be null");
        }
        //Повторяющийся кусок кода с client
        return ResponseEntity.ok(itemService.createItem(createItemDto));
    }

    //Обновление
    @PutMapping
    public ResponseEntity<ItemDto> update(@RequestBody ItemDto updateItem)
    {
        return ResponseEntity.ok(itemService.updateItem(updateItem));

    }

    //Удаление
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
    {
        //Нужна проверка на существование объекта в бд?
        itemService.delete(id);
        return ResponseEntity.ok("Item successfully deleted!"+" ID: "+id);
    }
    //Вывод всех
    @GetMapping
    public ResponseEntity<List<ItemDto>> showItems()
    {
        return ResponseEntity.ok(itemService.showItems());
    }
}

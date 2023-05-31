package com.shop.service;

import com.shop.dto.*;
import com.shop.entity.Item;
import com.shop.mapper.ItemMapper;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;


    //создание клиента
    public ResponseItemDto createItem(RequestCreateItemDto createItemDto) {
        Item created = itemRepository.save(itemMapper.map(createItemDto));
        return itemMapper.map(created);
    }

    //вывод объектов базы данных в виде дто списком
    public List<ResponseItemDto> showItems()
    {
        return itemRepository.findAll().stream().map(itemMapper::map).collect(Collectors.toList());
    }
   // обновление клиента
    public ResponseItemDto updateItem(RequestUpdateItemDto updateItemDto)
    {
        //можно через if
        Item updated = itemRepository.findById(updateItemDto.getId()).orElse(null);
        assert updated != null;
        updated.setName(updateItemDto.getName());
        itemRepository.save(updated);
        return itemMapper.map(updated);
    }
    //удаление клиента
    public void delete(UUID id){itemRepository.deleteById(id);}
}

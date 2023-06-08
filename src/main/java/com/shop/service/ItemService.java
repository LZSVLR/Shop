package com.shop.service;

import com.shop.dto.*;
import com.shop.entity.Item;
import com.shop.exception.EntityNotFoundException;
import com.shop.mapper.ItemMapper;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;


    //создание клиента
    public ItemDto createItem(ItemDto createItemDto) {
        Item created = itemRepository.save(itemMapper.map(createItemDto));
        return itemMapper.map(created);
    }

    //вывод объектов базы данных в виде дто списком
    public List<ItemDto> showItems()
    {
        return itemRepository.findAll().stream().map(itemMapper::map).collect(Collectors.toList());
    }
   // обновление клиента
    @Transactional
    public ItemDto updateItem(ItemDto updateItemDto)
    {
        //не проходит проверка
        if(itemRepository.findById(updateItemDto.getId()).isEmpty())
        {
            throw new EntityNotFoundException("Invalid ID, item was not found.");
        }
        itemRepository.updateNameById(updateItemDto.getName(), updateItemDto.getId());
        return updateItemDto;
    }
    //удаление клиента
    public void delete(UUID id){itemRepository.deleteById(id);}
}

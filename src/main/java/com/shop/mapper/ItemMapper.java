package com.shop.mapper;

import com.shop.dto.*;
import com.shop.entity.Client;
import com.shop.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ItemDto map(Item item)
    {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .build();

    }
    //Преобразует переданную стороннюю ДТОшку в item
    public Item map(ItemDto requestCreateItemDto) {
        return Item.builder()
                .name(requestCreateItemDto.getName())
                .price(requestCreateItemDto.getPrice())
                .build();
    }

}

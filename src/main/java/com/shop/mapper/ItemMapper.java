package com.shop.mapper;

import com.shop.dto.*;
import com.shop.entity.Client;
import com.shop.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public ResponseItemDto map(Item item)
    {
        return ResponseItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .build();

    }
    //Преобразует переданную стороннюю ДТОшку в item
    public Item map(RequestCreateItemDto requestCreateItemDto) {
        return Item.builder()
                .name(requestCreateItemDto.getName())
                .price(requestCreateItemDto.getPrice())
                .build();
    }
    //Обновляем
    public Item map(RequestUpdateItemDto requestUpdateItemDto) {
        return Item.builder()
                .name(requestUpdateItemDto.getName())
                .price(requestUpdateItemDto.getPrice())
                .build();
    }
}

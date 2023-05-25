package com.shop.service;

import com.shop.entity.Category;
import com.shop.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> readAll()
    {
        return categoryRepository.findAll();
    }

    //При поиске по id категории возникнет проблема нам возвращается объект optional мы обязаны указать поведение программы,
    //если объект не будет найден
    public Category readByID(Long id)
    {
        return categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Категория не найдена!"));
    }
}

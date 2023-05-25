package com.shop.service;

import com.shop.dto.ProductDTO;
import com.shop.entity.Product;
import com.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    //Создание продукта
    public Product create(ProductDTO dto)
    {
        Product product = Product.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .value(dto.getValue())
                .category(categoryService.readByID(dto.getCategoryId())) //добавление категории
                .build();
        return productRepository.save(product);

    }
    // Вывод списка существующих продуктов
    public List<Product> readAll()
    {
        return productRepository.findAll();
    }
    // Список по id категории
    public List<Product> readByCategoryId(Long id)
    {
        return productRepository.findCategoryById(id);
    }

    // Обновление продукта (проверить)
    public Product update(Product product)
    {
        return productRepository.save(product);
    }
    // Удаленеие продукта.
    public void delete(Long id)
    {
        productRepository.deleteById(id);
    }

}

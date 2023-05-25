package com.shop.controllers;

import com.shop.dto.ProductDTO;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> readAll()
    {
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }

    //Почему не через product?
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto)
    {
        return new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }

    //Почему не через DTO?
    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id)
    {
        productService.delete(id);
        return HttpStatus.OK;
    }
    @GetMapping("/category")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id)
    {
        return new ResponseEntity<>(productService.readByCategoryId(id),HttpStatus.OK);

    }

}

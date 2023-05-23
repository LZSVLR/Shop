package com.shop.controller;


import com.shop.dto.Product;
import com.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //Выводим продукты
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable UUID id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @GetMapping("/product-create")
    public String createProductForm()
    {
        return "product-create";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Product;

@Controller
public class ProductController {
    private final List<Product> products = new ArrayList<>(
        List.of(
            new Product(1L, "Produit 1", BigDecimal.valueOf(999.99)),
            new Product(2L, "Produit 2", BigDecimal.valueOf(499.99)),
            new Product(3L, "Produit 3", BigDecimal.valueOf(299.99))
        )
    );

    private Long counter = (long) products.size();

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("productList", products);
        return "products";
    }

    @GetMapping("/products/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @PostMapping("/products/add")
    public String saveProduct(@ModelAttribute("product") Product product) {
        products.add(product);
        return "redirect:/products";
    }
}
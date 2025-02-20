package com.example.t2305m_springboot.controller;

import com.example.t2305m_springboot.entity.Product;
import com.example.t2305m_springboot.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("search")
    @PreAuthorize("hasAnyAuthority('product')")
    public List<Product> search(@RequestBody(required = false) String name,
                                @RequestBody(required = false) Double minPrice,
                                @RequestBody(required = false) Double maxPrice){
        return productService.filter(name,minPrice,maxPrice);
    }
}
package com.example.t2305m_springboot.service;

import com.example.t2305m_springboot.entity.Product;
import com.example.t2305m_springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> filter(String name, Double minPrice, Double maxPrice){
        return productRepository.filter(name,minPrice,maxPrice);
    }
}

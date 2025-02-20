package com.example.t2305m_springboot.controller;

import com.example.t2305m_springboot.dto.req.CategoryReq;
import com.example.t2305m_springboot.dto.res.CategoryRes;
import com.example.t2305m_springboot.service.CategoryService;
import com.example.t2305m_springboot.service.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private CategoryService categoryService;
    private final RabbitMQProducer producer;
    public CategoryController(CategoryService categoryService, RabbitMQProducer producer) {
        this.categoryService = categoryService;
        this.producer = producer;
    }
    @GetMapping()
    @PreAuthorize("hasAnyAuthority('category')")
    public List<CategoryRes> getAllCategory(){
        producer.sendMessage("Vừa gửi 1 thông báo sang bên RabbitMQ");
        return categoryService.all();
    }

    @PostMapping()
    public ResponseEntity<CategoryRes> createCategory(@RequestBody CategoryReq category){
        return ResponseEntity.ok(categoryService.create(category));
    }

    @GetMapping("search")
    public List<CategoryRes> search(@RequestBody String s){
        return categoryService.searchByName(s);
    }

}
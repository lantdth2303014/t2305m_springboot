package com.example.t2305m_springboot.controller;

import org.example.javastringboots.dto.req.ReviewReq;
import org.example.javastringboots.dto.res.ReviewRes;
import org.example.javastringboots.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<ReviewRes> addReview(@RequestBody ReviewReq reviewReq) {
        return ResponseEntity.ok(reviewService.addReview(reviewReq));
    }

}
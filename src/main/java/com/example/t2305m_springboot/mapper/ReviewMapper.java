package com.example.t2305m_springboot.mapper;

import org.example.javastringboots.dto.req.ReviewReq;
import org.example.javastringboots.dto.res.ReviewRes;
import org.example.javastringboots.entity.Review;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review toEntity(ReviewReq reviewReq);
    ReviewRes toDTO(Review review);
}
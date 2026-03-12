package com.example.untitled.service;

import java.util.List;

import com.example.untitled.DTO.rental;


// 미완성
public interface rentalService {
    // 유저 생성
    void rentalComic();

    // 유저 삭제
    void returnComic();

    List<rental> findAllComics();
}

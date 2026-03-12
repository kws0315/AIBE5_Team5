package com.example.untitled.service;

import java.util.List;

import com.example.untitled.DTO.comic;

public interface comicService {
    // 만화책 등록
    void createComic(comic comic);

    // 만화책 삭제
    void deleteComic(int id);

    // 만화책 조회
    void getComicDetail(int id);

    // 만화책 상세 조회
    List<comic> findAllComics();
}

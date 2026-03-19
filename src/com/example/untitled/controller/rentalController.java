package com.example.untitled.controller;

import com.example.untitled.DTO.rental;                    // 대여 데이터를 담는 DTO
import com.example.untitled.service.rentalService;         // 대여 관련 서비스 인터페이스
import com.example.untitled.service.impl.rentalServiceImpl; // 대여 서비스 구현체

import java.sql.Date;   // 대여일 저장용 Date
import java.util.List;  // 대여 목록 조회 시 사용

public class rentalController {

    // 서비스 객체
    // controller는 대여/반납 요청을 service에 전달함
    private final rentalService service;

    // 생성자
    // rentalController가 생성될 때 rentalService 구현체를 연결
    public rentalController() {
        this.service = new rentalServiceImpl();
    }

    // 만화책 대여 기능
    // 회원 번호(userId)와 만화책 번호(comicId)를 받아 대여 DTO 생성 후 service에 전달
    public boolean rentalComic(int userId, int comicId) {

        // 회원 번호 또는 만화책 번호가 잘못되면 실패 처리
        if (userId <= 0 || comicId <= 0) {
            return false;
        }

        // rental DTO 객체 생성
        rental rental = new rental();
        rental.setUserId(userId);
        rental.setComicId(comicId);
        rental.setRentalDate(new Date(System.currentTimeMillis()));
        rental.setReturnDate(null); //반납전이라 초기값을 null로 지정

        // service에 DTO 전달 후 대여 결과 반환
        return service.rentalComic(rental);
    }

    // 만화책 반납 기능
    // rentalId를 파라미터로 받아 해당 대여 기록을 반납 처리
    public boolean returnComic(int rentalId) {

        // 잘못된 번호면 실패 처리
        if (rentalId <= 0) {
            return false;
        }

        // service에 반납 요청
        return service.returnComic(rentalId);
    }

    // 대여 목록 조회 기능
    public List<rental> getRentalList() {
        return service.getRentalList();
    }
}
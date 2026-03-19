package com.example.untitled.controller;

import com.example.untitled.DTO.user; //회원 데이터 DTO
import com.example.untitled.service.userService; // 회원 서비스 인터페이스
import com.example.untitled.service.impl.userServiceImpl; // 서비스 Impl

import java.sql.Date; //회원 등록일 저장
import java.util.List; //회원 목록 조회

public class userController {

    //서비스를 통해 회원 관련 기능 요청
    private final userService service;

    //userController 생성시  생성자 연결
    public userController() {
        //-----serviceImpl가 구현이 안되서 이부분은 오류 발생 구현 되면 해결예정------
        this.service = new userServiceImpl();

    }
    //회원 등록 기능
    public boolean createUser(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        user user = new user();
        user.setName(name.trim());
        user.setUserRegDate(new Date(System.currentTimeMillis()));

        return service.createUser(user);
    }

    //회원 삭제
    public boolean deleteUser(int userId) {
        if (userId <= 0) {
            return false;
        }
        return service.deleteUser(userId);
    }

    // 회원 목록 조회
    public List<user> getUserList() { //회원 목록 리스트로 반환
        return service.getUserList();
    }
}
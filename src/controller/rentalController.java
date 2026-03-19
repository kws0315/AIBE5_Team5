package controller;

import DTO.rental;                    // 대여 데이터를 담는 DTO
import service.rentalService;         // 대여 관련 서비스 인터페이스
import service.impl.rentalServiceImpl; // 대여 서비스 구현체
import java.util.List;  // 대여 목록 조회 시 사용

public class rentalController {
    // 서비스 객체
    // controller는 대여/반납 요청을 service에 전달함
    private final rentalService service;

    // 생성자
    // rentalController가 생성될 때 rentalService 구현체를 연결
    public rentalController() throws Exception {
        this.service = new rentalServiceImpl();
    }

    // 만화책 대여 기능
    // 회원 번호(userId)와 만화책 번호(comicId)를 받아 대여 DTO 생성 후 service에 전달
    public boolean rentalComic(int userId, int comicId) {
        // 회원 번호 또는 만화책 번호가 잘못되면 실패 처리
        if (userId <= 0 || comicId <= 0) return false;
        return service.rentalComic(userId, comicId);
    }

    // 만화책 반납 기능
    // rentalId를 파라미터로 받아 해당 대여 기록을 반납 처리
    public boolean returnComic(int userId, int comicId) {

        // 잘못된 번호면 실패 처리
        if (userId <= 0 || comicId <= 0) {
            return false;
        }

        // service에 반납 요청
        return service.returnComic(userId, comicId);
    }

    // 대여 목록 조회 기능
    public List<rental> getRentalList(int userId) {
        if (userId <= 0) {
            return List.of();
        }
        return service.getRentalList(userId);
    }
}

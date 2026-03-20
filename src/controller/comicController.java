package controller;

import DTO.comic; //만화책 데이터 import
import service.comicService; // 만화책  관련 서비스 import
import service.impl.comicServiceImpl; //만환책 서비스 implement import

import java.util.List; // 목록 조회

public class comicController {

    private final comicService service; //service로 기능 호출

    public comicController() throws Exception { //생성자
        this.service = new comicServiceImpl();
    }

    //만화책 등록 기능
    public boolean createComic(String title, String author, String description, int series) { //만화책 등록 각 파라미터의 DTO에 담은 후 서비스에 전달
        if (title == null || title.trim().isEmpty()) { //제목이 비어있으면 실패
            return false;
        }
        try {
            service.createComic(title.trim(), author, description, series); //서비스에 DTO전달 뒤 결과 반환
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    //만화책 삭제 기능
    //comicId를 파리미터로 받아와 해당 만화책 삭제 요청
    public boolean deleteComic(int comicId) {
        if (comicId <= 0) { //잘못된 번호 일 때 실패처리
            return false;
        }
        try {
            service.deleteComic(comicId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // 만화책 상세 조회
    public comic getComicDetail(int comicId) {
        if (comicId <= 0) {
            return null; // 잘못된 번호인 경우 null
        }
        try {
            return service.getComicDetail(comicId);
        } catch (Exception e) {
            return null;
        }
    }
    //만화책 목록조회 리스트로 반환
    public List<comic> getComicList() {
        try {
            return service.getComicList();
        } catch (Exception e) {
            return List.of();
        }
    }
}

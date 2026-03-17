package controller;
import DTO.comic;
import service.comicService;
import service.impl.comicServiceImpl;

import java.util.List;
import java.util.Scanner;

public class comicController {
    private comicService comicService;

    public comicController() throws Exception {
        comicService = new comicServiceImpl();
    }

    // 만화책 생성
    public void createComic(Scanner sc) throws Exception {
        System.out.print("제목 : ");
        String title = sc.nextLine();

        System.out.print("작가 : ");
        String author = sc.nextLine();

        System.out.print("설명 : ");
        String description = sc.nextLine();

        System.out.print("권수 : ");
        int series = sc.nextInt();
        sc.nextLine();

        comicService.createComic(title, author, description, series);
    }

    // 만화책 삭제
    public void deleteComic(int comicId) throws Exception { }

    // 만화책 목록
    public List<comic> getComicList() throws Exception {
        return null;
    }
    // 만화책 상세내용
    public comic getComicDetail(int comicId) {
        return null;
    }


}

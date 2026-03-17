package view;

import DAO.comicDAO;
import DTO.comic;
import config.DBconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class comicView {
    public void comicMenu() {
        Scanner sc = new Scanner(System.in);

        try (Connection conn = DBconnection.getConnection()) {
            comicDAO comicDAO = new comicDAO(conn);

            while(true) {
                List<comic> list = comicDAO.getComicList();
                for (comic c : list) {
                    System.out.println(
                            "ID : " + c.getComicId() +
                                    " | 제목 : " + c.getTitle() +
                                    " | 작가 : " + c.getAuthor() +
                                    " | 권수 : " + c.getSeries() +
                                    " | 등록일 : " + c.getComicRegDate()
                    );
                }

                System.out.println("========== 만화책 관리 시스템 ==========");
                System.out.println("1. 만화책 등록");
                System.out.println("2. 만화책 상세페이지");
                System.out.println("3. 만화책 삭제");
                System.out.println("0. 뒤로가기");
                System.out.print("메뉴 선택 : ");

                int menu = sc.nextInt();
                sc.nextLine();

                if (menu == 1) {
                    System.out.print("제목 : ");
                    String title = sc.nextLine();

                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    System.out.print("설명 : ");
                    String description = sc.nextLine();

                    System.out.print("권수 : ");
                    int series = sc.nextInt();
                    sc.nextLine();

                    Date comicRegDate = new Date(System.currentTimeMillis());
                    comic comic = new comic(title, author, description, series, comicRegDate);
                    comicDAO.createComic(comic);
                } else if (menu == 2) {
                    list  = comicDAO.getComicList();

                    System.out.println("========== 만화책 목록 ==========");

                    for (comic c : list) {
                        System.out.println(
                                "ID : " + c.getComicId() +
                                        " | 제목 : " + c.getTitle() +
                                        " | 작가 : " + c.getAuthor() +
                                        " | 권수 : " + c.getSeries() +
                                        " | 등록일 : " + c.getComicRegDate()
                        );
                    }
                } else if (menu == 3) {
                    System.out.print("제목 : ");
                    int comic_id = sc.nextInt();
                    comicDAO.deleteComic(comic_id);
                } else if (menu == 0) {
                    System.out.println("프로그램 종료");
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("MySQL 연결 실패...");
        }
        sc.close();
    }
}

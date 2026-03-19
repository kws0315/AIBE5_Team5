package view;

import DTO.rental;
import controller.rentalController;

import java.util.List;
import java.util.Scanner;

public class rentalView {
    public void rentalMenu() {
        Scanner sc = new Scanner(System.in);
        try {
            rentalController controller = new rentalController();
            while (true) {
                System.out.println("========== 대여 관리 시스템 ==========");
                System.out.println("1. 만화 대여");
                System.out.println("2. 만화 반납");
                System.out.println("3. 사용자별 대여 목록 조회");
                System.out.println("0. 뒤로가기");
                System.out.print("메뉴 선택 : ");

                int menu = sc.nextInt();
                sc.nextLine();

                if (menu == 1) {
                    System.out.print("userId 입력: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("comicId 입력: ");
                    int comicId = sc.nextInt();
                    sc.nextLine();

                    boolean ok = controller.rentalComic(userId, comicId);
                    System.out.println(ok ? "대여 처리 완료" : "대여 처리 실패 (userId/comicId 확인 또는 이미 대여 중)");
                } else if (menu == 2) {
                    System.out.print("userId 입력: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("comicId 입력: ");
                    int comicId = sc.nextInt();
                    sc.nextLine();

                    boolean ok = controller.returnComic(userId, comicId);
                    System.out.println(ok ? "반납 처리 완료" : "반납할 대여 내역이 없습니다.");
                } else if (menu == 3) {
                    System.out.print("조회할 userId 입력: ");
                    int userId = sc.nextInt();
                    sc.nextLine();

                    List<rental> list = controller.getRentalList(userId);
                    if (list.isEmpty()) {
                        System.out.println("조회된 대여 내역이 없습니다.");
                        continue;
                    }

                    System.out.println("========== 대여 목록 ==========");
                    for (rental r : list) {
                        System.out.println(
                                "대여번호: " + r.getRentalId() +
                                        " | 제목: " + r.getTitle() +
                                        " | 작가: " + r.getAuthor() +
                                        " | 권수: " + r.getSeries() +
                                        " | 대여일: " + r.getRentalDate() +
                                        " | 반납일: " + r.getReturnDate()
                        );
                    }
                } else if (menu == 0) {
                    break;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        } catch (Exception e) {
            System.out.println("대여 메뉴 처리 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}

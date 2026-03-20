import DAO.comicDAO;
import DTO.comic;
import config.DBconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import view.comicView;
import view.rentalView;
import view.userView;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        comicView comicView = new comicView();
        userView userView = new userView();
        rentalView rentalView = new rentalView();
        boolean isComicListShownAtEntry = false;

        while(true) {
            System.out.println("========== 만화책 대여 시스템 ==========");
            System.out.println("1. 만화책 목록");
            System.out.println("2. 회원 목록");
            System.out.println("3. 대여 목록");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();
            if (menu == 1) {
                comicView.comicMenu();
            } else if (menu == 2) {
                userView.userMenu();
            } else if (menu == 3) {
                rentalView.rentalMenu();
            } else if (menu == 0) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
        } // While 끝부분

    }
}

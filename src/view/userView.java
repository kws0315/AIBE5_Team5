package view;

import DTO.user;
import controller.userController;

import java.util.List;
import java.util.Scanner;

public class userView {
    public void userMenu() {
        Scanner sc = new Scanner(System.in);
        userController controller = new userController();

        while (true) {
            System.out.println("========== 회원 관리 시스템 ==========");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 삭제");
            System.out.println("3. 회원 목록");
            System.out.println("0. 뒤로가기");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();
            sc.nextLine();

            if (menu == 1) {
                System.out.print("이름 입력: ");
                String name = sc.nextLine();
                boolean ok = controller.createUser(name);
                System.out.println(ok ? "회원 등록 완료" : "회원 등록 실패");
            } else if (menu == 2) {
                System.out.print("삭제할 userId 입력: ");
                int userId = sc.nextInt();
                sc.nextLine();
                boolean ok = controller.deleteUser(userId);
                System.out.println(ok ? "회원 삭제 완료" : "회원 삭제 실패");
            } else if (menu == 3) {
                List<user> list = controller.getUserList();
                if (list.isEmpty()) {
                    System.out.println("회원 목록이 비어 있습니다.");
                    continue;
                }
                System.out.println("========== 회원 목록 ==========");
                for (user u : list) {
                    System.out.println(
                            "ID : " + u.getUserId() +
                                    " | 이름 : " + u.getName() +
                                    " | 등록일 : " + u.getUserRegDate()
                    );
                }
            } else if (menu == 0) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

package controller;
import DTO.user;
import service.impl.userServiceImpl;
import service.userService;
import service.impl.comicServiceImpl;
import service.userService;
import java.util.List;
import java.util.Scanner;

public class userController {
    private userService userService;

    public userController() throws Exception {
        // userService = new userServiceImpl()
        // 이건 추후에 Service 처리되면 주석 해제하도록
    }

    // 유저 생성
    public void createUser(Scanner sc) throws Exception{ };

    // 유저 삭제
    public void deleteUser() { };

    // 유저 목록
    public List<user> getUserList() {
        return null;
    };
}

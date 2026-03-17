package service;

import DTO.user;
import java.util.List;

public interface userService {
    // 유저 생성
    void createUser(user user) throws Exception;

    // 유저 삭제
    void deleteUser(int userId) throws Exception;

    // 유저 목록
    List<user> getUserList() throws Exception;
}

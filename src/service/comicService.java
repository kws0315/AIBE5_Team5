package service;

import DTO.comic;
import java.util.List;

public interface comicService {
    // Controller가 쉽게 넘길 수 있도록 파라미터를 풀어둔 생성 메소드
    void createComic(String title, String author, String description, int series) throws Exception;
    
    // 만화책 전체 목록을 가져오는 메소드
    List<comic> getComicList() throws Exception;
    
    // 특정 만화책의 상세 정보를 가져오는 메소드
    comic getComicDetail(int comicId) throws Exception;
    
    // 만화책을 삭제하는 메소드
    boolean deleteComic(int comicId) throws Exception;
}

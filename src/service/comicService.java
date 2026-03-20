package service;

import DTO.comic;

import java.sql.Date;
import java.util.List;

public interface comicService {
    List<comic> getComicList() throws Exception;

    void createComic(String title, String author, String description, int series) throws Exception;

    void deleteComic(int comicId) throws Exception;

    comic getComicDetail(int comicId) throws Exception;

}

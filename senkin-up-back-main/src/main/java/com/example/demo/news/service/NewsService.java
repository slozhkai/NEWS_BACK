package com.example.demo.news.service;

import com.example.demo.news.dto.request.CreateNewsDTO;
import com.example.demo.news.model.News;
import com.example.demo.user.model.User;

import java.util.List;

public interface NewsService {
    News createNews(CreateNewsDTO request);

    News updateNews(News news);

    void deleteNews(Integer newsId);
    News     getNewsById(Integer newsId);
    List<News> getAllNews();
}

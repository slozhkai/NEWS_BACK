package com.example.demo.news.service.Impl;


import com.example.demo.news.dto.request.CreateNewsDTO;
import com.example.demo.news.model.News;
import com.example.demo.news.repository.NewsRepository;
import com.example.demo.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News createNews(CreateNewsDTO request) {
        var news = new News();
        news.setTitle(request.getTitle());
        news.setPicture(request.getPicture());
        news.setTextContent(request.getTextContent());
        return newsRepository.save(news);
    }

    @Override
    public News updateNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void deleteNews(Integer newsId) {
        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Удаляем самого пользователя
        newsRepository.deleteById(newsId);
    }

    @Override
    public News getNewsById(Integer newsId) {
        return newsRepository.findById(newsId).orElse(null);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}

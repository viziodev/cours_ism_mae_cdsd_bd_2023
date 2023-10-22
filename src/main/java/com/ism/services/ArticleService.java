package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.Article;

public interface ArticleService {
    ArrayList<Article> listerArticles();
    boolean ajouterArticle(Article article);
}

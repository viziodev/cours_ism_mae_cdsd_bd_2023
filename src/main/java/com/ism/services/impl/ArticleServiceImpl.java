package com.ism.services.impl;

import java.util.ArrayList;

import com.ism.entities.Article;
import com.ism.repositories.ArticleRepository;
import com.ism.repositories.CategorieRepository;

import com.ism.services.ArticleService;

public class ArticleServiceImpl implements ArticleService {
     ArticleRepository articleRepository  ;
     CategorieRepository categorieRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategorieRepository categorieRepository) {
        this.articleRepository = articleRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public ArrayList<Article> listerArticles() {
      return articleRepository.findAll();
    }

    @Override
    public boolean ajouterArticle(Article article) {
       if (article.getCategorie().getId()==0) {
         int idCat= categorieRepository.insert(article.getCategorie());
         article.getCategorie().setId(idCat);
       }
       return articleRepository.insert(article)!=0;
    }
    
}

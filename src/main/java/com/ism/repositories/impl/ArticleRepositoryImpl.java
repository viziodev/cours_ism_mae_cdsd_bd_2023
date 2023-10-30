package com.ism.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ism.entities.Article;
import com.ism.entities.Categorie;
import com.ism.repositories.ArticleRepository;
import com.ism.repositories.CategorieRepository;
import com.ism.repositories.DataBase;

public class ArticleRepositoryImpl implements ArticleRepository {

    private final String SQL_INSERT="INSERT INTO `articles` (`qte_stock`,  `categorie_id`,  `libelle`) VALUES (?,?,?)";
    private final String  SQL_SELECT_ALL="SELECT id,libelle,qte_stock,categorie_id FROM `articles`";
    private DataBase dataBase;
    private CategorieRepository categorieRepository;
      //Injection de Dependance
    public ArticleRepositoryImpl(DataBase dataBase, CategorieRepository categorieRepository) {
        this.dataBase = dataBase;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public int insert(Article data) {
       int lastInsertId=0;
            try {
                dataBase.openConnexion();
                dataBase.initPreparedStatement(SQL_INSERT);
                dataBase.getPs().setInt(1,data.getQteStock());
                dataBase.getPs().setInt(2,data.getCategorie().getId());
                dataBase.getPs().setString(3,data.getLibelle());
                  dataBase.executeUpdate();
                  ResultSet rs=  dataBase.getPs().getGeneratedKeys();
                if(rs.next()){
                  lastInsertId=rs.getInt(1) ; 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
          
          
            return lastInsertId; 
    }

    @Override
    public ArrayList<Article> findAll() {
          ArrayList<Article> articles=new ArrayList<>();
                  try {
                      dataBase.openConnexion();
                        dataBase.initPreparedStatement(SQL_SELECT_ALL);
                    ResultSet resultSet=dataBase.executeSelect();
                    while (resultSet.next()) {
                        Categorie categorie=categorieRepository.findById(resultSet.getInt("categorie_id"));
                        Article article=new Article( resultSet.getInt("id")
                                         , resultSet.getString("libelle")
                                         ,resultSet.getInt("qte_stock"),
                                          categorie);

                         articles.add(article);
                           
                      }
                   resultSet.close();
                   dataBase.closeConnexion();
                } catch (SQLException e) {
                    System.out.println("Erreur execution de Requete");
                }
            
            return articles; 
    }
    
}

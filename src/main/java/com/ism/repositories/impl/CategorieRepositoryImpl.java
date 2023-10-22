package com.ism.repositories.impl;

import java.sql.*;

import java.util.ArrayList;

import com.ism.entities.Categorie;
import com.ism.repositories.CategorieRepository;
import com.ism.repositories.DataBase;



public  class CategorieRepositoryImpl implements CategorieRepository {
        private final String SQL_INSERT="INSERT INTO `categories` ( `libelle`) VALUES (?)";
        private final String  SQL_SELECT_ALL="SELECT id,libelle FROM `categories`";
        private final String  SQL_SELECT_BY="SELECT id,libelle FROM `categories` where id=?";
        private DataBase dataBase;
    public CategorieRepositoryImpl(DataBase dataBase) {
            this.dataBase = dataBase;
        }

    @Override
    public int insert(Categorie categorie) {
            int nbreLigne=0;
            try {
                dataBase.openConnexion();
                dataBase.initPreparedStatement(SQL_INSERT);
                dataBase.getPs().setString(1,categorie.getLibelle());
                dataBase.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
          
            return nbreLigne;
    }

    @Override
    public ArrayList<Categorie> findAll() {

           ArrayList<Categorie> categories=new ArrayList<>();
                  try {
                    dataBase.openConnexion();
                     dataBase.initPreparedStatement(SQL_SELECT_ALL);
                    ResultSet resultSet=dataBase.executeSelect();

                    while (resultSet.next()) {
                        Categorie categorie=new Categorie( resultSet.getInt("id")
                                        , resultSet.getString("libelle"));
                         categories.add(categorie);
                           
                      }
                   resultSet.close();
                   dataBase.closeConnexion();
                } catch (SQLException e) {
                    System.out.println("Erreur execution de Requete");
                }
            
            return categories;
    }

    @Override
    public Categorie findById(int id) {
         Categorie categorie=null;
              try {
                    dataBase.openConnexion();
                    dataBase.initPreparedStatement(SQL_SELECT_BY);
                    dataBase.getPs().setInt(1,id);
                    ResultSet resultSet=dataBase.executeSelect();
                    if (resultSet.next()) {
                         categorie=new Categorie( resultSet.getInt("id")
                                        , resultSet.getString("libelle"));
                           
                      }
                   resultSet.close();
                   dataBase.closeConnexion();
                } catch (SQLException e) {
                    System.out.println("Erreur execution de Requete");
                }
            return categorie;
    }

  
   
}

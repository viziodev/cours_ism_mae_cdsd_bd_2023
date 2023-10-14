package com.ism.repositories;

import java.sql.*;

import java.util.ArrayList;

import com.ism.entities.Categorie;



public  class CategorieBdRepository implements CategorieRepository {

    @Override
    public int insert(Categorie categorie) {
        int nbreLigne=0;
        //;
          try {
                //3306
                Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection conn = DriverManager.getConnection(
                 "jdbc:mysql://localhost:8889/spring_formation_dgb" + //
                         "", "root", "root");
                   // PreparedStatement => Requetes parametres  ==> Recommandees
                    String sql="INSERT INTO `categories` ( `libelle`) VALUES (?)";
                     PreparedStatement prepareStatement = conn.prepareStatement(sql);
                     prepareStatement.setString(1, categorie.getLibelle());
                    nbreLigne= prepareStatement.executeUpdate();
                    prepareStatement.close();
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur d'ouverture de BD");
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur de chargement du Driver");
            }
            return nbreLigne;
    }

    @Override
    public ArrayList<Categorie> findAll() {
           //étape 1: charger la classe driver
           ArrayList<Categorie> categories=new ArrayList<>();
            try {
                //3306
                Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection conn = DriverManager.getConnection(
                 "jdbc:mysql://localhost:8889/spring_formation_dgb" + //
                         "", "root", "root");
                  String sql="SELECT id,libelle FROM `categories`";
              /*
                 *   Deux classes execution de requete
                 *   Statement => Requetes non parametres  ==> Non Recommandees
                 *   PreparedStatement => Requetes parametres  ==> Recommandees
               */
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
                 //Convertir des Lignes de BD en Objet JAVA  ==>ORM
                  while (resultSet.next()) {
                    Categorie categorie=new Categorie( resultSet.getInt("id")
                                    , resultSet.getString("libelle"));
                     categories.add(categorie);
                       
                  }
                 //ResultSet ==> List
                 resultSet.close();
                 statement.close();
                 conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur d'ouverture de BD");
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur de chargement du Driver");
            }
            return categories;
    }

    @Override
    public Categorie findById(int id) {
         Categorie categorie=null;
        // TODO Auto-generated method stub
        try {
                //3306
                Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection conn = DriverManager.getConnection(
                 "jdbc:mysql://localhost:8889/spring_formation_dgb" + //
                         "", "root", "root");
                   //Requetes non parametres ou non preparees       
                  String sql="SELECT id,libelle FROM `categories` where id="+id;
                  //Requetes non parametres ou preparees    
                  //  String sql="SELECT id,libelle FROM `categories` where id=?";
              /*
                 *   Deux classes execution de requete
                 *   Statement => Requetes non parametres  ==> Non Recommandees
                 *   PreparedStatement => Requetes parametres  ==> Recommandees
               */
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql);
                 //Convertir des Lignes de BD en Objet JAVA  ==>ORM
                  if (resultSet.next()) {
                     categorie=new Categorie( resultSet.getInt("id")
                                    , resultSet.getString("libelle"));
                       
                  }
                 //ResultSet ==> List
                 resultSet.close();
                 statement.close();
                 conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur d'ouverture de BD");
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println("Erreur de chargement du Driver");
            }
            return categorie;
    }

  
   
}

package com.ism.repositories.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ism.repositories.DataBase;

public  class MysqlImpl  implements DataBase{
    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:8889/spring_formation_dgb";
    private final String user="root";
    private final String password="root";
    private  Connection conn=null;
    private PreparedStatement ps=null;

    @Override
    public PreparedStatement getPs() {
        return ps;
    }

    @Override
    public void openConnexion() {
         try {
            Class.forName(driver);
           conn = DriverManager.getConnection(url,user, password);
        } catch (ClassNotFoundException e) {
              System.out.println("Erreur de chargement du Driver");
        } catch (SQLException e) {
            System.out.println("Erreur d'ouverture de la connexion");
        }
                 
    }

    @Override
    public void closeConnexion() {
        if (conn!=null) {
              try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Erreur de fermeture de BD ");
            }
        } else {
            
        }
    }

    @Override
    public ResultSet executeSelect() {
        ResultSet rs=null;
          try {   
            rs=ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Erreur Execution de la requete");
        }
        return rs;
    }

    @Override
    public int executeUpdate() {
        int nbreLigne=0;
       try {
            nbreLigne=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur Execution de la requete");
        }
        return nbreLigne;
    }

    @Override
    public void initPreparedStatement(String sql) {
           try {
            ps=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

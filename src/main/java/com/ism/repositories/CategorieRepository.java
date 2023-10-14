package com.ism.repositories;

import java.util.ArrayList;

import com.ism.entities.Categorie;

public interface CategorieRepository {
    int insert(Categorie categorie);
    ArrayList<Categorie> findAll();
    Categorie findById(int id);
}

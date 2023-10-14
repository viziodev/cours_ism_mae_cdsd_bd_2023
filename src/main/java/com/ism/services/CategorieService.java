package com.ism.services;

import java.util.ArrayList;

import com.ism.entities.Categorie;

public interface CategorieService {
 boolean categorieExist(Categorie categorie);
 boolean ajouter(Categorie categorie);
 ArrayList<Categorie> lister();
 Categorie rechercherParId(int id);
    
} 
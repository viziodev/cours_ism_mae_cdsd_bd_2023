package com.ism.repositories;



import com.ism.entities.Categorie;

public interface CategorieRepository extends Repository<Categorie> {
    Categorie findById(int id);
}



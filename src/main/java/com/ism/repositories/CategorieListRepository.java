package com.ism.repositories;

import java.util.ArrayList;

import com.ism.entities.Categorie;

public class CategorieListRepository implements CategorieRepository {
    //Couplage Fort
    ArrayList<Categorie> categories =new ArrayList<>();

    @Override
    public int insert(Categorie categorie){
       categories.add(categorie) ;
       return 1;
    }
    @Override
    public     ArrayList<Categorie> findAll(){
        return categories;
    }
    @Override
    public Categorie findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}

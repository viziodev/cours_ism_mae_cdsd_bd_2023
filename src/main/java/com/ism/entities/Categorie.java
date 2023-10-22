package com.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categorie {
    //Caracteristiques
        private int id;
        private String libelle;
        public Categorie(String libelle) {
            this.libelle = libelle;
        }
        
    
}

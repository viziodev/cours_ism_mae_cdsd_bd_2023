package com.ism.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Article {
    private int id;
    private String libelle;
    private int qteStock;
    //ManyToOne
    Categorie categorie;
}

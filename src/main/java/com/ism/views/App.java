package com.ism.views;

import java.util.ArrayList;
import java.util.Scanner;

import com.ism.entities.Article;
import com.ism.entities.Categorie;
import com.ism.repositories.ArticleRepository;
import com.ism.repositories.CategorieRepository;
import com.ism.repositories.DataBase;
import com.ism.repositories.impl.ArticleRepositoryImpl;
import com.ism.repositories.impl.CategorieRepositoryImpl;
import com.ism.repositories.impl.MysqlImpl;
import com.ism.services.ArticleService;
import com.ism.services.CategorieService;
import com.ism.services.impl.ArticleServiceImpl;
import com.ism.services.impl.CategorieServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        //Couplage Fort
          DataBase dataBase =new MysqlImpl();
         CategorieRepository categorieRepository=new CategorieRepositoryImpl(dataBase);
         ArticleRepository articleRepository=new ArticleRepositoryImpl(dataBase,categorieRepository);
         CategorieService categorieService=new CategorieServiceImpl(categorieRepository);
         ArticleService articleService=new ArticleServiceImpl(articleRepository, categorieRepository);


           Scanner cs=new Scanner(System.in);
           int choix;
            do {
                System.out.println("1-Lister les categories");
                System.out.println("2-Ajouter une Categorie");
                System.out.println("3-Lister les Articles");
                System.out.println("4-Ajouter un Article");
                System.out.println("5-Quitter");
                System.out.println("Entrer votre choix ?");
                    choix=cs.nextInt();
                    switch (choix) {
                            case 1:
                                ArrayList<Categorie> categories = categorieService.lister();
                                for (Categorie cat : categories) {
                                    System.out.println(cat);
                                }
                            break;
                            case 2:
                               cs.nextLine();
                               System.out.println("Entrer le libelle");
                               String libelle=cs.nextLine();
                               Categorie categorie=new Categorie(libelle);
                               boolean ok=  categorieService.ajouter(categorie);
                               if(ok){
                                 System.out.println("Categorie ajoutee");
                               }else{
                                System.out.println("Categorie existe deja");
                               }
                                break; 
                          case 3: 
                              articleService.listerArticles()
                                      .forEach(System.out::println);                       
                        default:
                            break;
                    }
            } while (choix !=5);
           cs.close();
           

    }
}

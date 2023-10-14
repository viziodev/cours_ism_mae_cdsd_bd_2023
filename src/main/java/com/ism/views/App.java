package com.ism.views;

import java.util.ArrayList;
import java.util.Scanner;

import com.ism.entities.Categorie;
import com.ism.repositories.CategorieBdRepository;
import com.ism.repositories.CategorieRepository;
import com.ism.services.CategorieService;
import com.ism.services.CategorieServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        //Couplage Fort
         CategorieRepository repository=new CategorieBdRepository();
         CategorieService categorieService=new CategorieServiceImpl(repository);
           Scanner cs=new Scanner(System.in);
           int choix;
            do {
                System.out.println("1-Lister les categories");
                System.out.println("2-Ajouter une Categorie");
                System.out.println("4-Rechercher une Categorie Par Id");
                System.out.println("3-Quitter");
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

                           case 4:
                             System.out.println("Entrer l'id");
                               int id=cs.nextInt();
                               Categorie categorie2 = categorieService.rechercherParId(id);
                               if (categorie2!=null) {
                                 System.out.println(categorie2);
                               } else {
                                   System.out.println("Aucune categorie disponible");
                               }
                              

                           break;
                        default:
                            break;
                    }
            } while (choix !=3);
           cs.close();
           

    }
}

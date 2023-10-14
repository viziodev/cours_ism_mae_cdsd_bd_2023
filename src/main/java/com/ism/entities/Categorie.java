package com.ism.entities;

public class Categorie {
    //Caracteristiques
        private int id;
        private String libelle;
   
        //Services

        
        public Categorie(String libelle) {
            this.libelle = libelle;
        }
        public Categorie() {
        }
         public Categorie(int id, String libelle) {
            this.id = id;
            this.libelle = libelle;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getLibelle() {
            return libelle;
        }
        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }
        @Override
        public String toString() {
            return "Categorie [id=" + id + ", libelle=" + libelle + "]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Categorie other = (Categorie) obj;
            if (libelle == null) {
                if (other.libelle != null)
                    return false;
            } else if (!libelle.equals(other.libelle))
                return false;
            return true;
        }
       
        


        
    
}

package Objet;

import Planete.Planet;
import Vaisseau.Vaisseau;

public class Objet {
    String nom;
    int sante;
    int gaz;

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getSante() { return sante; }
    public void setSante(int sante) { this.sante = sante; }
    public int getGaz() { return gaz; }
    public void setGaz(int gaz) { this.gaz = gaz; }

    public static void trouverObjet(Vaisseau vaisseau,Planet planete){
        int number1= (int)(Math.random()*4+1);
        switch (number1){
            case 1: vaisseau.getInventaire().add(new Carapace());
                System.out.println("Une carapace!!!");
                break;
            case 2:vaisseau.getInventaire().add(new Diesel());
                System.out.println("Du diesel!!!");
                break;
            case 3:vaisseau.getInventaire().add(new Plaster());
                System.out.println("Un plaster!!!");
                break;
            case 4:vaisseau.getInventaire().add(new Refill());
                System.out.println("Un refill!!!");
                break;
            case 5:vaisseau.getInventaire().add(new Tink());
                System.out.println("Une tink!!!");
                break;
        }

    }
}


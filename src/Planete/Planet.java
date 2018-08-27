package Planete;

import Objet.Objet;
import Vaisseau.Vaisseau;

public class Planet {
    String nom;
    int gaz;
    int chancePirate;
    int chanceObjet;


    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getGaz() { return gaz; }
    public void setGaz(int gaz) {  this.gaz = gaz; }
    public int getChancePirate() { return chancePirate; }
    public void setChancePirate(int chancePirate) { this.chancePirate = chancePirate; }
    public int getChanceObjet() { return chanceObjet; }
    public void setChanceObjet(int chanceObjet) { this.chanceObjet = chanceObjet; }

    public void explorer(Vaisseau vaisseau,Planet planet){
        int number= (int)(Math.random()*99+1);
        if (planet.getChancePirate()>number){
            vaisseau.setSante(vaisseau.getSante()-25);
        }
        number= (int)(Math.random()*99+1);
        if (planet.getChanceObjet()>number){
            Objet.trouverObjet(vaisseau, planet);
        }
        vaisseau.setGaz(vaisseau.getGaz()-planet.getGaz());
        vaisseau.getPlanete().push(planet);
    }


}

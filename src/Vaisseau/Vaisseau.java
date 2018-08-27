package Vaisseau;

import Objet.Objet;
import Planete.Planet;
import Planete.Terre;


import java.util.ArrayList;
import java.util.Stack;


public class Vaisseau {
    String nom;
    int gaz;
    ArrayList<Objet> inventaire= new ArrayList<>();
    int sante;
    Stack<Planet> planete= new Stack<>();

    public Vaisseau(Planet planete){
        nom=null;
        gaz=1000;
        sante=100;
        planete.setNom("Terre");
    }

    public String getNom() { return nom;}
    public void setNom(String nom) { this.nom = nom; }
    public int getGaz() { return gaz; }
    public void setGaz(int gaz) { this.gaz = gaz; }
    public int getSante() { return sante; }
    public void setSante(int sante) { this.sante = sante; }
    public ArrayList<Objet> getInventaire() { return inventaire; }
    public void setInventaire(ArrayList<Objet> inventaire) { this.inventaire = inventaire; }
    public Stack<Planet> getPlanete() { return planete; }
    public void setPlanete(Stack<Planet> planete) { this.planete = planete; }

    public static Vaisseau saveVaisseau(Vaisseau vaisseau){
        Vaisseau vaisseau1= new Vaisseau(new Terre());
        vaisseau1.setGaz(vaisseau.gaz);
        vaisseau1.setNom(vaisseau.nom);
        vaisseau1.setSante(vaisseau.sante);
        int a = vaisseau.planete.size();
        for (int i =0;i<a;i++){
            vaisseau1.getPlanete().push(vaisseau.getPlanete().pop());
        }
        a= vaisseau.inventaire.size();
        for (int i=0;i<a;i++){
            vaisseau1.getInventaire().add(vaisseau.inventaire.get(i));
        }
        return vaisseau1;
    }


}

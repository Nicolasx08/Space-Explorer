package Main;

import Planete.*;
import Vaisseau.Vaisseau;

import java.util.Scanner;
import java.util.Stack;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static Planet terre = new Planet();
    public static Vaisseau vaisseau= new Vaisseau(terre);
    public static Stack<Vaisseau> retourArriereListe= new Stack<>();
    public static void main(String[] args) {
        System.out.println("Bonjour, le but est de parcourir le plus de planète possible, chaque planète vaut 1 point!");
        System.out.println("Quelle est le nom de votre vaisseau?");

        vaisseau.setNom(sc.next());
        vaisseau.getPlanete().push(new Terre());
        boolean ok=true;
        while (ok){
            choixSwitch(choix(), vaisseau);
            if (vaisseau.getSante()<=0 || vaisseau.getGaz()<=0){
                ok=false;
            }
        }
        uDie();

    }
    public static int choix(){

        int rep=0;
        boolean ok=false;
        while (ok==false){
            System.out.println("Que voulez-vous faire?");
            System.out.println("1-Examiner le vaisseau");
            System.out.println("2-Explorer une planète");
            System.out.println("3- Utiliser un objet");
            System.out.println("4-Revenir en arrière");
            try {
                rep=sc.nextInt();
            }catch (Exception numero) {
                System.out.println("Entrez un nombre");
                sc.nextLine();
                rep=0;
            }
            if (rep<=4 && rep>=1){
                ok=true;
            }else {
                System.out.println("Entrez un chiffre entre 1-4");
            }
        }

        return rep;
    }
    public static void choixSwitch(int choix, Vaisseau vaisseau){
        switch (choix){
            case 1: System.out.println("nom: "+vaisseau.getNom());
                System.out.println("Gaz: " +vaisseau.getGaz());
                System.out.println("Santé: "+vaisseau.getSante());
                System.out.println("Inventaire: ");
                int a=vaisseau.getInventaire().size();
                if (vaisseau.getInventaire().size()>=1){
                    for (int i=0;i<a;i++){
                        System.out.println(i+"- "+ vaisseau.getInventaire().get(i).getNom());
                    }
                }

                System.out.println("Planète courante: "+vaisseau.getPlanete().peek().getNom());
                break;
            case 2:

                int number=(int)(Math.random()*4+1);
                switch (number){
                    case 1:
                        retourArriereListe.push(Vaisseau.saveVaisseau(vaisseau));
                        terre.explorer(vaisseau,new Davidium());
                        break;
                    case 2:
                        retourArriereListe.push(Vaisseau.saveVaisseau(vaisseau));
                        terre.explorer(vaisseau,new Socrative());
                        break;
                    case 3:
                        retourArriereListe.push(Vaisseau.saveVaisseau(vaisseau));
                        terre.explorer(vaisseau, new Simonium());
                        break;
                    case 4:
                        retourArriereListe.push(Vaisseau.saveVaisseau(vaisseau));
                        terre.explorer(vaisseau,new Pluton());
                        break;
                    case 5:
                        retourArriereListe.push(Vaisseau.saveVaisseau(vaisseau));
                        terre.explorer(vaisseau,new Marxime());
                        break;
                }
                break;
            case 3:
                if (vaisseau.getInventaire().size()!=0){
                    System.out.println("Quelle objet voulez-vous utiliser?");
                    boolean ok=true;
                    boolean ok1=true;
                    int rep=0;
                    while (ok){
                        while (ok1){
                            for (int i=0;i<vaisseau.getInventaire().size();i++){
                                System.out.println((i+1)+"- "+ vaisseau.getInventaire().get(i).getNom());
                            }

                            try {
                                rep=sc.nextInt();
                            }catch (Exception lettre){
                                System.out.println("Entrez un chiffre");
                                sc.nextLine();
                                rep=0;
                            }
                            if (rep!=0){
                                ok1=false;
                            }
                        }


                        if (rep<=vaisseau.getInventaire().size() && rep>=0){
                            vaisseau.setSante(vaisseau.getSante()+vaisseau.getInventaire().get(rep-1).getSante());
                            if (vaisseau.getSante()>100){
                                vaisseau.setSante(100);
                            }
                            vaisseau.setGaz(vaisseau.getGaz()+vaisseau.getInventaire().get(rep-1).getGaz());
                            if (vaisseau.getGaz()>1000){
                                vaisseau.setGaz(1000);
                            }
                            vaisseau.getInventaire().remove(rep-1);
                            ok=false;
                        }
                        else {
                            System.out.println("Entrez un chiffre valide");
                        }
                    }
                }else {
                    System.out.println("Vous n'avez aucun objet.");
                }
                break;
            case 4:
                if (retourArriereListe.size()!=0){
                    vaisseau=last();
                }
                else {
                    System.out.println("c'est le vaisseau de votre première action.");
                }

                break;


        }
    }
    public static void uDie(){
        System.out.println("La partie est fini! Vous êtes mort.");
        if (vaisseau.getSante()<=0){
            System.out.println(vaisseau.getNom()+ " n'a plus de vie.");
        }
        if (vaisseau.getGaz()<=0){
            System.out.println(vaisseau.getNom()+ " manque de gaz.");
        }
        Stack<Planet> trajet= new Stack<>();
        int a=vaisseau.getPlanete().size();
        for (int i=0;i<a;i++ ){
            trajet.push(vaisseau.getPlanete().pop());
        }
        System.out.print("Trajet parcouru: ");
        for (int i=0;i<a;i++){
            System.out.print(trajet.pop().getNom()+" -->");
        }
    }
    public static Vaisseau last(){
        Vaisseau vaisseau2= new Vaisseau(new Terre());
        vaisseau2.setSante(retourArriereListe.peek().getSante());
        vaisseau2.setNom(retourArriereListe.peek().getNom());
        vaisseau2.setGaz(retourArriereListe.peek().getGaz());
        int a= retourArriereListe.peek().getInventaire().size();
        for (int i=0;i<a;i++){
            vaisseau2.getInventaire().add(retourArriereListe.peek().getInventaire().get(i));
        }
        a=retourArriereListe.peek().getPlanete().size();
        for (int i=0;i<a;i++){
            vaisseau2.getPlanete().push(retourArriereListe.peek().getPlanete().pop());
        }
        retourArriereListe.pop();
        return vaisseau2;
    }
}

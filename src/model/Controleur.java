package model;

import java.util.ArrayList;

import java.util.Scanner;

import view.VueAventurier;


public class Controleur {
	public ArrayList<Carte> cartes = new ArrayList<>();
	public ArrayList<Aventurier> joueurs = new ArrayList<>();
	public Grille grille;
	public ArrayList<Tresor> tresors = new ArrayList<>();

	public VueAventurier vueAventurier;
        public Aventurier avCourant;
        public int action = 0;

        public Controleur(){
            avCourant = joueurs.get(0);
            this.grille = new Grille();
            for(int i=1; i<=4; i++){
                joueurs.add(new Aventurier(grille.getTuile(i, 3)));
            }
            
            for(Aventurier a : joueurs){
                System.out.println(a.getTuile().getX());
                System.out.println(a.getTuile().getY() + "\n");
            }
            avCourant = joueurs.get(2);
            assecherTuile(avCourant);
        }

	public void ajouterAction() {
            action += 1;
	}

	public void assecherTuileCourante() {
		throw new UnsupportedOperationException();
	}

	public void actionAutre() {
		throw new UnsupportedOperationException();
	}

	public void deplacerAventurier(String aNomTuile, Aventurier aAv) {
		throw new UnsupportedOperationException();
	}

	public Aventurier getAventurierCourant() {
            return avCourant;
	}
        
        public ArrayList getAventuriers() {
            return joueurs;
        }

	public void assecherTuile(Aventurier aAv) {
            Scanner input = new Scanner(System.in);
            //On récupère les tuiles asséchables
            ArrayList<Tuile> tuilesAssechables = avCourant.getTuilesAssechables();
            //On les affiche
            for(Tuile t : tuilesAssechables) {
                System.out.println(t.getX()+" - "+t.getY());
            }
            //On demande la tuile à assécher au joueur
            System.out.println("X : ");
            int x = input.nextInt();
            System.out.println("Y : ");
            int y = input.nextInt();
            Tuile myTuile = new Tuile(x, y);
            //On vérifie si elle existe. Existe -> on assèche la tuile
            for(Tuile t : tuilesAssechables) {
                if (t.getX() == myTuile.getX() && t.getY() == myTuile.getY()) {
                    System.out.println("Tuile trouvée");
                    avCourant.assecher(myTuile);
                    ajouterAction();
                    break;
                }
            }
	}
        
        public void deplacerAventurierCourant(Tuile nvTuile){
            avCourant.deplacement(nvTuile);
        }
        
        public ArrayList<Tuile> getTuilesAdjacentes(){
            ArrayList<Tuile> r = new ArrayList();
            Tuile tuileC = avCourant.getTuile();
            
            if(grille.getTuile(tuileC.getX() - 1, tuileC.getY()).getEtatTuile() != Tuile.ETAT_TUILE_COULEE)
                r.add(grille.getTuile(tuileC.getX() - 1, tuileC.getY() - 1));
            
            if (grille.getTuile(tuileC.getX(), tuileC.getY() - 1).getEtatTuile() != Tuile.ETAT_TUILE_COULEE)
                r.add(grille.getTuile(tuileC.getX(), tuileC.getY() - 1));
            
            if (grille.getTuile(tuileC.getX() + 1, tuileC.getY()).getEtatTuile() != Tuile.ETAT_TUILE_COULEE)
                r.add(grille.getTuile(tuileC.getX() + 1, tuileC.getY()));
                
            if (grille.getTuile(tuileC.getX(), tuileC.getY() + 1).getEtatTuile() != Tuile.ETAT_TUILE_COULEE)
                r.add(grille.getTuile(tuileC.getX(), tuileC.getY() + 1));
            
            return r;
        }
            
        public void finTour() {
            JoueurSuivant();
        }
        
        private void JoueurSuivant() {
            int nbJoueurs = joueurs.size();
            if (avCourant.equals(joueurs.get(joueurs.size()-1))) { // Si le joueur courant est le dernier de l'AL
                avCourant = joueurs.get(0);
            } else {
                int i = 0;
                boolean trouve = false;
                Aventurier j;
                while ((i < joueurs.size()) && !trouve ) { // Recherche du joueur dans l'AL
                    j = joueurs.get(i);
                    if (j.equals(avCourant)) {
                        trouve = true;
                    } else {
                        i =+ 1;
                    }
                }
                avCourant = joueurs.get(getNumJoueur(avCourant)+1);
            }
	}
        
        public int getNumJoueur(Aventurier j) {
            int i = 0;
            boolean trouve = false;
            while ((i < joueurs.size()) && !trouve ) { // Recherche du joueur dans l'AL
                j = joueurs.get(i);
                if (j.equals(avCourant)) {
                    trouve = true;
                } else {
                    i =+ 1;
                }
            }
            return i;
        }
}
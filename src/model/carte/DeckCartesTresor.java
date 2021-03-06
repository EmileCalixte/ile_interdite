/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.carte;

import java.util.ArrayList;
import java.util.Collections;
import model.TypeTresor;
import util.Parameters;

/**
 *
 * @author aubriotv
 */
public class DeckCartesTresor {
    
    private ArrayList<CarteTresor> deckCartes;
    private ArrayList<CarteTresor> defausseCartes;
    
    public DeckCartesTresor(){
        deckCartes = new ArrayList<>();
        defausseCartes = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            deckCartes.add(new CartePiece("Pierre", TypeTresor.pierreSacree));
            deckCartes.add(new CartePiece("Zephyr", TypeTresor.statueDuZephyr));
            deckCartes.add(new CartePiece("Cristal", TypeTresor.cristalArdent));
            deckCartes.add(new CartePiece("Calice", TypeTresor.caliceDeLOnde));
        }
        for (int i = 1; i <= 3; i++){
            deckCartes.add(new CarteBonus("Helicoptere"));
        }
        for (int i = 1; i <= 2; i++){
            deckCartes.add(new CarteBonus("SacsDeSable"));
        }
        for (int i = 1; i <= 2; i++){
            deckCartes.add(new CarteMonteeDesEaux());
        }
        shuffleCards();
        dispArray(deckCartes);
    }
    
    public void shuffleCards() {
        //if (Parameters.ALEAS) {
            Collections.shuffle(deckCartes);
            Collections.shuffle(deckCartes);
            Collections.shuffle(deckCartes);
        //}
    }
    
    private void dispArray(ArrayList<CarteTresor> arrayList){
        for (CarteTresor c : arrayList){
            if ("tresor".equals(c.getTypeCarte())){
                CartePiece d = (CartePiece) c;
                System.out.println(d.getTypeCarte()+" : "+d.getNomTresor());
            } else if ("action_speciale".equals(c.getTypeCarte())){
                CarteBonus d = (CarteBonus) c;
                System.out.println(d.getTypeCarte()+" : "+d.getPouvoir());
            } else if ("montee_eaux".equals(c.getTypeCarte())){
                System.out.println(c.getTypeCarte());
            }
        }
    }
    
    public CarteTresor tirerCarte(){
        CarteTresor c = deckCartes.remove(0);
        refillDeck();
        return c;
    }
    
    public void defausserCarte(CarteTresor c){
        defausseCartes.add(0, c);
    }
    
    public void replacerDansLaPile(CarteTresor c){
        deckCartes.add(0, c);
    }
    
    private void refillDeck(){
        if (deckCartes.isEmpty()) {
            deckCartes.addAll(defausseCartes);
            defausseCartes.clear();
            shuffleCards();
        }
    }
}


package model;

import java.util.ArrayList;

public class Grille {
	public ArrayList<Tuile> _tuiles = new ArrayList<Tuile>();
        
        public Grille(){
            
        }

	public ArrayList<Tuile> getTuilesAdjacentes(Tuile t) {
		throw new UnsupportedOperationException();
	}

	public Tuile getTuile(String aNom) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Tuile> getTuilesAdjEtDiag(Tuile aTuile) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Tuile> getToutesLesTuiles() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Tuile> getTuilesNonSeches() {
		throw new UnsupportedOperationException();
	}
}

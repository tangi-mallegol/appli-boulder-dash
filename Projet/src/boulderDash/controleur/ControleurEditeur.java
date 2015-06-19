package boulderDash.controleur;

import boulderDash.modele.Plateau;
import boulderDash.vue.FenetreEditeur;
import boulderDash.vue.FenetreTaillePlateau;

public class ControleurEditeur extends Controleur{
	private Plateau plateau;
	
	public ControleurEditeur(){
		
	}
	
	public void nouvelleCarte(FenetreEditeur fEditeur){
		new FenetreTaillePlateau(this, fEditeur);
	}
	
	public void initPlateau(int x, int y, FenetreEditeur fEditeur){
		plateau = new Plateau(x, y);
		plateau.addObserver(fEditeur.getpPlateau());
		plateau.initPanneauPlateau();
	}
}
package boulderDash.controleur;

import boulderDash.vue.FenetreEditeur;
import boulderDash.vue.FenetreJeu;

public class ControleurAccueil {
	
	public ControleurAccueil(){
		
	}
	
	public void OuvrirEditeur(){
		new FenetreEditeur(new ControleurEditeur());
	}
	
	public void OuvrirJeu(){
		new FenetreJeu(new ControleurJeu());
	}
}

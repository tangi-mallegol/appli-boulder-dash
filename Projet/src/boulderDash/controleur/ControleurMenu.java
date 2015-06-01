package boulderDash.controleur;

import boulderDash.vue.FenetreEditeur;
import boulderDash.vue.FenetreJeu;

public class ControleurMenu {
	
	public ControleurMenu(){
		
	}
	
	public void OuvrirEditeur(){
		new FenetreEditeur(new ControleurEditeur());
	}
	
	public void OuvrirJeu(){
		//new FenetreJeu(new ControleurJeu());
	}
}

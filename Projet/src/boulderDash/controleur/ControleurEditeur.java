package boulderDash.controleur;

import java.io.IOException;

import boulderDash.modele.GenererGrille;
import boulderDash.vue.FenetreJeu;
import boulderDash.vue.FenetreTaillePlateau;

public class ControleurEditeur extends Controleur{

	public ControleurEditeur(){
		
	}
	
	public void nouvelleCarte(){
		FenetreTaillePlateau fTaillePlateau = new FenetreTaillePlateau(this);
	}
	
	public void initPlateau(int x, int y){
		
	}
}

package boulderDash.controleur;

import java.awt.GridLayout;
import java.io.IOException;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.GenererGrille;
import boulderDash.modele.Plateau;
import boulderDash.modele.elementsJeu.MurSimple;
import boulderDash.vue.FenetreJeu;
import boulderDash.vue.FenetrePrincipale;
import boulderDash.vue.composant.elementsJeu.PanneauMurAcier;
import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

public class ControleurJeu extends Controleur{
	
	public ControleurJeu(){
		
		
	}
	
	public void initNiveau(String nomNiveau, FenetreJeu fj){
		GenererGrille genererGrille = new GenererGrille(nomNiveau);
		
		Plateau plateau;
		try {
			plateau = genererGrille.creerPlateau(fj);
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
					
			
			
			
			
		
	}
	
}

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
		GenererGrille genererGrille = new GenererGrille(1);
		
		Plateau plateau;
		plateau.addObserver(fj);
		try {
			plateau = genererGrille.creerPlateau();		
			
			ElementJeu tabElementsJeu[][] = plateau.getTabElementsJeu();
			
			/*for(int i = 0; i < plateau.getY(); i++){
				for(int j = 0; j < plateau.getX(); j++){
					if(tabElementsJeu[j][i] == null)
						add(new PanneauVide());
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurAcier"))
						add(new PanneauMurAcier());
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurSimple"))
						add(new PanneauMurSimple());					
				}
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
}

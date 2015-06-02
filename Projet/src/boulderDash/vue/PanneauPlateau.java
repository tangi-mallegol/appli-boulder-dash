package boulderDash.vue;

import java.awt.GridLayout;

import javax.swing.JPanel;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.Plateau;
import boulderDash.vue.composant.elementsJeu.PanneauMurAcier;
import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

public class PanneauPlateau extends JPanel{
	public PanneauPlateau(){
		GenererGrille genererGrille = new GenererGrille(1);
		
		Plateau plateau = genererGrille.creerPlateau();
		
		setLayout(new GridLayout(plateau.getY(),plateau.getX()));
		
		
		
		ElementJeu tabElementsJeu[][] = plateau.getTabElementsJeu();
		
		
		
		for(int i = 0; i < plateau.getY(); i++){
			for(int j = 0; j < plateau.getX(); j++){
				if(tabElementsJeu[j][i] == null)
					add(new PanneauVide());
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurAcier"))
					add(new PanneauMurAcier());
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurSimple"))
					add(new PanneauMurSimple());
					
			}
		}
	}
}

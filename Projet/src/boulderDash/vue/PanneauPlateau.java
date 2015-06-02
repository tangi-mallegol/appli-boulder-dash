package boulderDash.vue;

import javax.swing.JPanel;

import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;

public class PanneauPlateau extends JPanel{
	public PanneauPlateau(){
		PanneauMurSimple pMurSimple = new PanneauMurSimple();
		
		add(pMurSimple);
	}
}

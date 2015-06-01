package boulderDash.vue;

import java.awt.BorderLayout;

import boulderDash.controleur.ControleurJeu;

public class FenetreEditeur extends FenetrePrincipale{
	private ControleurJeu controleurJeu;
	private PanneauInfoJeu pInfoJeu;
	
	public FenetreEditeur(ControleurJeu controleurJeu){
		this.controleurJeu = controleurJeu;
		pInfoJeu = new PanneauInfoJeu();
		add(pInfoJeu, BorderLayout.EAST);
	}
}

package boulderDash.vue;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import boulderDash.controleur.ControleurJeu;
import boulderDash.vue.composant.MenuJeu;

public class FenetreJeu extends FenetrePrincipale{
	private ControleurJeu controleurJeu;
	
	public FenetreJeu(ControleurJeu controleurJeu){
		super();
		this.controleurJeu = controleurJeu;
		
		PanneauPlateau pPlateau = new PanneauPlateau();
		add(pPlateau, BorderLayout.CENTER);
		
		MenuJeu menuJeu = new MenuJeu(this);
		
		setJMenuBar(menuJeu);
	}
}

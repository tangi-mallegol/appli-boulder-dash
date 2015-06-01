package boulderDash.vue;

import java.awt.BorderLayout;

import boulderDash.controleur.ControleurEditeur;
import boulderDash.vue.composant.MenuEditeur;

public class FenetreEditeur extends FenetrePrincipale{
	private ControleurEditeur controleurEditeur;
	private PanneauInfoEditeur pInfoEditeur;
	
	public FenetreEditeur(ControleurEditeur controleurEditeur){
		super();
		this.controleurEditeur = controleurEditeur;
		pInfoEditeur = new PanneauInfoEditeur();
		add(pInfoEditeur, BorderLayout.EAST);
		
		MenuEditeur menuEditeur = new MenuEditeur(this);
		setJMenuBar(menuEditeur);
	}
}

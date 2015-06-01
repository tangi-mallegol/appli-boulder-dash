package boulderDash.vue;

import javax.swing.JLabel;

import boulderDash.controleur.ControleurJeu;
import boulderDash.vue.composant.MenuJeu;

public class FenetreJeu extends FenetrePrincipale{
	private ControleurJeu controleurJeu;
	
	public FenetreJeu(ControleurJeu controleurJeu){
		super();
		this.controleurJeu = controleurJeu;
		
		MenuJeu menuJeu = new MenuJeu(this);
		
		setJMenuBar(menuJeu);
		
		add(new JLabel("COUCOU"));
	}
}

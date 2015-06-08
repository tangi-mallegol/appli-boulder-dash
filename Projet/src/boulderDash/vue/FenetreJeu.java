package boulderDash.vue;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import boulderDash.controleur.ControleurJeu;
import boulderDash.vue.composant.MenuJeu;

public class FenetreJeu extends FenetrePrincipale implements Observer{
	private ControleurJeu controleurJeu;
	
	public FenetreJeu(ControleurJeu controleurJeu){
		super();
		this.controleurJeu = controleurJeu;
		
		/*PanneauPlateau pPlateau = new PanneauPlateau();
		add(pPlateau, BorderLayout.CENTER);*/
		
		MenuJeu menuJeu = new MenuJeu(this, controleurJeu);
		
		setJMenuBar(menuJeu);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}
}

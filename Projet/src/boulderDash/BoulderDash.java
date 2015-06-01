package boulderDash;

import javax.swing.UIManager;

import boulderDash.controleur.ControleurAccueil;
import boulderDash.vue.FenetreAccueil;


public class BoulderDash {
	public static void main(String[] args) {
		// Choix du LookAndFeel pour l'habillage graphique.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new FenetreAccueil(new ControleurAccueil());
	}
}
package boulderDash;

import javax.swing.UIManager;

import boulderDash.controleur.ControleurMenu;
import boulderDash.vue.MenuAccueil;


public class BoulderDash {
	public static void main(String[] args) {
		// Choix du LookAndFeel pour l'habillage graphique.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new MenuAccueil(new ControleurMenu());
	}
}
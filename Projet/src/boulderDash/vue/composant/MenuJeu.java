package boulderDash.vue.composant;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuJeu extends JMenuBar{
	public MenuJeu(){
		JMenu nouveau = new JMenu("Nouvelle Partie");
		JMenu charger = new JMenu("Charger une partie");
		JMenu aide = new JMenu("Aide");
		JMenu quitter = new JMenu("Quitter");
		
		add(nouveau);
	}

}

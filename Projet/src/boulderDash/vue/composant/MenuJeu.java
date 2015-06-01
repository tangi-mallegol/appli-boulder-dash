package boulderDash.vue.composant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import boulderDash.controleur.ControleurAccueil;
import boulderDash.vue.FenetreAccueil;
import boulderDash.vue.FenetreJeu;

public class MenuJeu extends JMenuBar{
	private FenetreJeu fJeu;
	public MenuJeu(FenetreJeu fJeu){
		this.fJeu = fJeu;
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem nouveau = new JMenuItem("Nouvelle Partie");
		JMenuItem charger = new JMenuItem("Charger une partie");
		JMenuItem accueil = new JMenuItem("Accueil");
		JMenuItem aide = new JMenuItem("Aide");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		EcouteurMenuJeu ecouteurMenuJeu = new EcouteurMenuJeu();
		nouveau.addActionListener(ecouteurMenuJeu);
		charger.addActionListener(ecouteurMenuJeu);
		accueil.addActionListener(ecouteurMenuJeu);
		aide.addActionListener(ecouteurMenuJeu);
		quitter.addActionListener(ecouteurMenuJeu);
		
		menu.add(nouveau);
		menu.add(charger);
		menu.add(accueil);
		menu.add(aide);
		menu.add(quitter);
		
		add(menu);
	}
	
	private class EcouteurMenuJeu implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Quitter"))
				fJeu.dispose();
			
			if(e.getActionCommand().equals("Accueil")){
				fJeu.dispose();
				new FenetreAccueil(new ControleurAccueil());
			}
		}		
	}
}

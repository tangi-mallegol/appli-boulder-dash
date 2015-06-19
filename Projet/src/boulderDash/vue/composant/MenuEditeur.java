package boulderDash.vue.composant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import boulderDash.controleur.ControleurAccueil;
import boulderDash.controleur.ControleurEditeur;
import boulderDash.vue.FenetreAccueil;
import boulderDash.vue.FenetreEditeur;

public class MenuEditeur extends JMenuBar{
	private FenetreEditeur fEditeur;
	private ControleurEditeur controleurEditeur;
	
	public MenuEditeur(FenetreEditeur fEditeur, ControleurEditeur controleurEditeur){
		this.fEditeur = fEditeur;
		this.controleurEditeur = controleurEditeur;
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem nouveau = new JMenuItem("Nouvelle carte");
		JMenuItem charger = new JMenuItem("Charger une carte");
		JMenuItem accueil = new JMenuItem("Accueil");
		JMenuItem aide = new JMenuItem("Aide");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		EcouteurMenuEditeur ecouteurMenuEditeur = new EcouteurMenuEditeur();
		nouveau.addActionListener(ecouteurMenuEditeur);
		charger.addActionListener(ecouteurMenuEditeur);
		accueil.addActionListener(ecouteurMenuEditeur);
		aide.addActionListener(ecouteurMenuEditeur);
		quitter.addActionListener(ecouteurMenuEditeur);
		
		menu.add(nouveau);
		menu.add(charger);
		menu.add(accueil);
		menu.add(aide);
		menu.addSeparator();
		menu.add(quitter);
		
		add(menu);
	}
	
	private class EcouteurMenuEditeur implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Nouvelle carte"))
				controleurEditeur.nouvelleCarte(fEditeur);
			
			if(e.getActionCommand().equals("Quitter"))
				fEditeur.dispose();
			
			if(e.getActionCommand().equals("Accueil")){
				fEditeur.dispose();
				new FenetreAccueil(new ControleurAccueil());
			}
		}		
	}
}

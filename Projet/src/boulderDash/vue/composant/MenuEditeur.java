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
	private JMenuItem nouveau, charger, sauvegarder, accueil, aide , quitter;
	
	public MenuEditeur(FenetreEditeur fEditeur, ControleurEditeur controleurEditeur){
		this.fEditeur = fEditeur;
		this.controleurEditeur = controleurEditeur;
		
		JMenu menu = new JMenu("Menu");
		
		nouveau = new JMenuItem("Nouvelle carte");
		charger = new JMenuItem("Charger une carte");
		sauvegarder = new JMenuItem("Sauvegarder");
		accueil = new JMenuItem("Accueil");
		aide = new JMenuItem("Aide");
		quitter = new JMenuItem("Quitter");
		
		EcouteurMenuEditeur ecouteurMenuEditeur = new EcouteurMenuEditeur();
		nouveau.addActionListener(ecouteurMenuEditeur);
		charger.addActionListener(ecouteurMenuEditeur);
		sauvegarder.addActionListener(ecouteurMenuEditeur);
		accueil.addActionListener(ecouteurMenuEditeur);
		aide.addActionListener(ecouteurMenuEditeur);
		quitter.addActionListener(ecouteurMenuEditeur);
		
		menu.add(nouveau);
		menu.add(charger);
		menu.add(sauvegarder);
		menu.add(accueil);
		menu.add(aide);
		menu.addSeparator();
		menu.add(quitter);
		
		add(menu);
	}
	
	private class EcouteurMenuEditeur implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == nouveau)
				controleurEditeur.nouvelleCarte(fEditeur);
			
			if(e.getSource() == quitter)
				fEditeur.dispose();
			
			if(e.getSource() == accueil){
				fEditeur.dispose();
				new FenetreAccueil(new ControleurAccueil());
			}
			
			if(e.getSource() == sauvegarder){
				controleurEditeur.saveMAP();
			}
		}		
	}
}

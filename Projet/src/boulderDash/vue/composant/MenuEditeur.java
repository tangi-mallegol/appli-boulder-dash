package boulderDash.vue.composant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
	private JMenuItem nouveau, sauvegarder, accueil, quitter;
	
	public MenuEditeur(FenetreEditeur fEditeur, ControleurEditeur controleurEditeur){
		this.fEditeur = fEditeur;
		this.controleurEditeur = controleurEditeur;
		
		JMenu menu = new JMenu("Menu");
		JMenu charger = new JMenu("Charger une carte");
		
		nouveau = new JMenuItem("Nouvelle carte");
		sauvegarder = new JMenuItem("Sauvegarder");
		accueil = new JMenuItem("Accueil");
		quitter = new JMenuItem("Quitter");
		
		EcouteurMenuNiveaux ecouteurMenuNiveaux = new EcouteurMenuNiveaux();
		
		File repertoireNiveaux = new File("./donnees/niveaux/");
		String[] listeNiveaux = repertoireNiveaux.list();
		JMenuItem[] niveaux = new JMenuItem[listeNiveaux.length];
		for(int i=0; i<listeNiveaux.length; i++){
			niveaux[i] = new JMenuItem(listeNiveaux[i].substring(0, listeNiveaux[i].length()-4));			
			niveaux[i].addActionListener(ecouteurMenuNiveaux);
			charger.add(niveaux[i]);
		}
		
		EcouteurMenuEditeur ecouteurMenuEditeur = new EcouteurMenuEditeur();
		nouveau.addActionListener(ecouteurMenuEditeur);
		charger.addActionListener(ecouteurMenuEditeur);
		sauvegarder.addActionListener(ecouteurMenuEditeur);
		accueil.addActionListener(ecouteurMenuEditeur);
		quitter.addActionListener(ecouteurMenuEditeur);
		
		menu.add(nouveau);
		menu.add(charger);
		menu.add(sauvegarder);
		menu.add(accueil);
		menu.addSeparator();
		menu.add(quitter);
		
		add(menu);
	}
	
	private class EcouteurMenuNiveaux implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			controleurEditeur.initNiveau(e.getActionCommand(),fEditeur);	
		}
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

package boulderDash.vue.composant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import boulderDash.controleur.ControleurAccueil;
import boulderDash.controleur.ControleurJeu;
import boulderDash.vue.FenetreAccueil;
import boulderDash.vue.FenetreJeu;

public class MenuJeu extends JMenuBar{
	private FenetreJeu fJeu;
	private ControleurJeu controleurJeu;
	private JMenuItem[] niveaux;
	private JMenuItem nouveau, accueil, aide, quitter;
	
	public MenuJeu(FenetreJeu fJeu, ControleurJeu controleurJeu){
		this.fJeu = fJeu;
		this.controleurJeu = controleurJeu;
		
		EcouteurMenuJeu ecouteurMenuJeu = new EcouteurMenuJeu();
		EcouteurMenuNiveaux ecouteurMenuNiveaux = new EcouteurMenuNiveaux();
		
		JMenu menu = new JMenu("Menu");
		JMenu charger = new JMenu("Charger un niveau");	
		
		nouveau = new JMenuItem("Nouvelle Partie");	
		accueil = new JMenuItem("Accueil");
		aide = new JMenuItem("Aide");
		quitter = new JMenuItem("Quitter");
		
		File repertoireNiveaux = new File("./donnees/niveaux/");
		String[] listeNiveaux = repertoireNiveaux.list();
		JMenuItem[] niveaux = new JMenuItem[listeNiveaux.length];
		for(int i=0; i<listeNiveaux.length; i++){
			niveaux[i] = new JMenuItem(listeNiveaux[i].substring(0, listeNiveaux[i].length()-4));			
			niveaux[i].addActionListener(ecouteurMenuNiveaux);
			charger.add(niveaux[i]);
		}
		
		nouveau.addActionListener(ecouteurMenuJeu);
		accueil.addActionListener(ecouteurMenuJeu);
		aide.addActionListener(ecouteurMenuJeu);
		quitter.addActionListener(ecouteurMenuJeu);
		
		menu.add(nouveau);
		menu.add(charger);
		menu.add(accueil);
		menu.add(aide);
		menu.addSeparator();
		menu.add(quitter);
		
		add(menu);
	}
	
	private class EcouteurMenuNiveaux implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			controleurJeu.initNiveau(e.getActionCommand(),fJeu);	
		}
	}
	
	private class EcouteurMenuJeu implements ActionListener{
		public void actionPerformed(ActionEvent e) {			
			if(e.getSource() == nouveau)
				controleurJeu.NouvellePartie(fJeu);
			if(e.getSource() == accueil){
				fJeu.dispose();
				new FenetreAccueil(new ControleurAccueil());
			}				
			if(e.getSource() == aide)
				controleurJeu.OuvrirAide();
			if(e.getSource() == quitter)
				fJeu.dispose();
		}
	}
}

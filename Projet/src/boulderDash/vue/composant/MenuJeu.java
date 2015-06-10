package boulderDash.vue.composant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import boulderDash.controleur.ControleurAccueil;
import boulderDash.controleur.ControleurJeu;
import boulderDash.vue.FenetreAccueil;
import boulderDash.vue.FenetreJeu;

public class MenuJeu extends JMenuBar{
	private FenetreJeu fJeu;
	private ControleurJeu controleurJeu;
	private JMenuItem[] niveaux;
	
	public MenuJeu(FenetreJeu fJeu, ControleurJeu controleurJeu){
		this.fJeu = fJeu;
		this.controleurJeu = controleurJeu;
		
		EcouteurMenuJeu ecouteurMenuJeu = new EcouteurMenuJeu();
		
		JMenu menu = new JMenu("Menu");
		
		JMenuItem nouveau = new JMenuItem("Nouvelle Partie");
		JMenu charger = new JMenu("Charger un niveau");
		
		File repertoireNiveaux = new File("./donnees/niveaux/");
		String[] listeNiveaux = repertoireNiveaux.list();
		JMenuItem[] niveaux = new JMenuItem[listeNiveaux.length];
		for(int i=0; i<listeNiveaux.length; i++){
			niveaux[i] = new JMenuItem(listeNiveaux[i].substring(0, listeNiveaux[i].length()-4));			
			niveaux[i].addActionListener(ecouteurMenuJeu);
			charger.add(niveaux[i]);
		}
		
		JMenuItem accueil = new JMenuItem("Accueil");
		JMenuItem aide = new JMenuItem("Aide");
		JMenuItem quitter = new JMenuItem("Quitter");
		
		
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
			/*Integer i;
			for(i=0; i<niveaux.length; i++)
				if(e.getSource() == niveaux[i])
					controleurJeu.initNiveau(i.toString(), fJeu);*/
			
			
			if(e.getActionCommand().equals("Quitter"))
				fJeu.dispose();
			
			if(e.getActionCommand().equals("Accueil")){
				fJeu.dispose();
				new FenetreAccueil(new ControleurAccueil());
			}
		}		
	}
}

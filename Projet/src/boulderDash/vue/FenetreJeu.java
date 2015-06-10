package boulderDash.vue;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import boulderDash.controleur.ControleurJeu;
import boulderDash.modele.ElementJeu;
import boulderDash.vue.composant.MenuJeu;
import boulderDash.vue.composant.elementsJeu.*;

public class FenetreJeu extends FenetrePrincipale implements Observer{
	private ControleurJeu controleurJeu;
	private PanneauPlateau pPlateau;
	
	public FenetreJeu(ControleurJeu controleurJeu){
		super();
		this.controleurJeu = controleurJeu;	
		
		PanneauInfoJeu pInfoJeu = new PanneauInfoJeu();
		add(pInfoJeu, BorderLayout.EAST);
		
		MenuJeu menuJeu = new MenuJeu(this, controleurJeu);
		setJMenuBar(menuJeu);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ElementJeu tabElementsJeu[][] = (ElementJeu[][]) arg1;
		
		PanneauPlateau pPlateau = new PanneauPlateau(tabElementsJeu.length, tabElementsJeu[0].length);
		
		for(int i = 0; i < tabElementsJeu[0].length; i++){
			for(int j = 0; j < tabElementsJeu.length; j++){
				if(tabElementsJeu[j][i] == null)
					pPlateau.add(new PanneauVide());
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurAcier"))
					pPlateau.add(new PanneauMurAcier());
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurSimple"))
					pPlateau.add(new PanneauMurSimple());
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurMagique"))
					pPlateau.add(new PanneauMurMagique());					
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Terre"))
					pPlateau.add(new PanneauTerre());
				else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage"))
					pPlateau.add(new PanneauPersonnage());
			}
		}
		add(pPlateau, BorderLayout.CENTER);
		this.pack();		
		this.repaint();
		this.setVisible(true);
	}
}

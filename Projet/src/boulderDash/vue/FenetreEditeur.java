package boulderDash.vue;

import java.awt.BorderLayout;
import java.util.Observable;

import boulderDash.controleur.ControleurEditeur;
import boulderDash.modele.ElementJeu;
import boulderDash.vue.composant.MenuEditeur;
import boulderDash.vue.composant.elementsJeu.PanneauMurAcier;
import boulderDash.vue.composant.elementsJeu.PanneauMurMagique;
import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;
import boulderDash.vue.composant.elementsJeu.PanneauPersonnage;
import boulderDash.vue.composant.elementsJeu.PanneauPierre;
import boulderDash.vue.composant.elementsJeu.PanneauTerre;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

public class FenetreEditeur extends FenetrePrincipale{
	private ControleurEditeur controleurEditeur;
	private PanneauInfoEditeur pInfoEditeur;
	private PanneauPlateau pPlateau;
	
	public FenetreEditeur(ControleurEditeur controleurEditeur){
		super();
		this.controleurEditeur = controleurEditeur;
		pInfoEditeur = new PanneauInfoEditeur();
		add(pInfoEditeur, BorderLayout.EAST);
		
		MenuEditeur menuEditeur = new MenuEditeur(this, controleurEditeur);
		setJMenuBar(menuEditeur);
	}
	
	public void update(Observable arg0, Object arg1) {
		//Si la notification vient de Plateau alors c'est une nouvelle partie 
		if(arg0.getClass().getName().equals("boulderDash.modele.Plateau")){			
			ElementJeu tabElementsJeu[][] = (ElementJeu[][]) arg1;
			
			pPlateau = new PanneauPlateau(tabElementsJeu.length, tabElementsJeu[0].length);
			
			for(int i = 0; i < tabElementsJeu[0].length; i++){
				for(int j = 0; j < tabElementsJeu.length; j++){
					if(tabElementsJeu[j][i] == null)
						pPlateau.add(new PanneauVide());
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurAcier"))
						pPlateau.addPanneauElementJeu(new PanneauMurAcier(), j, i);
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurSimple"))
						pPlateau.addPanneauElementJeu(new PanneauMurSimple(), j, i);
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurMagique"))
						pPlateau.addPanneauElementJeu(new PanneauMurMagique(), j, i);
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Terre"))
						pPlateau.addPanneauElementJeu(new PanneauTerre(), j, i);
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre"))
						pPlateau.addPanneauElementJeu(new PanneauPierre(), j, i);
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage"))
						pPlateau.addPanneauElementJeu(new PanneauPersonnage(), j, i);
				}
			}
			add(pPlateau, BorderLayout.CENTER);
			this.pack();
			this.setLocationRelativeTo(null);
			this.repaint();
			this.setVisible(true);
		}
	}
	
	public PanneauPlateau getpPlateau() {
		return pPlateau;
	}

}
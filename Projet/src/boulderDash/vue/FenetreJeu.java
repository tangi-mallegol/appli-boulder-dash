package boulderDash.vue;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
		
		this.addKeyListener(new EcouteurClavier());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//Si la notification vient de Plateau alors c'est une nouvelle partie 
		if(arg0.getClass().getName().equals("boulderDash.modele.Plateau")){			
			ElementJeu tabElementsJeu[][] = (ElementJeu[][]) arg1;
			
			pPlateau = new PanneauPlateau(tabElementsJeu.length, tabElementsJeu[0].length);
			
			for(int i = 0; i < tabElementsJeu[0].length; i++){
				for(int j = 0; j < tabElementsJeu.length; j++){
					if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide"))
						pPlateau.addPanneauElementJeu(new PanneauVide(), j, i);
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
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant"))
						pPlateau.addPanneauElementJeu(new PanneauDiamant(), j, i);
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

	public class EcouteurClavier implements KeyListener{
		public void keyPressed(KeyEvent e) {
			
			int source = e.getKeyCode();
			
            if(source==KeyEvent.VK_UP)
            	controleurJeu.moveUP();
            else if(source==KeyEvent.VK_DOWN)
            	controleurJeu.moveDOWN();
            else if(source==KeyEvent.VK_RIGHT)
            	controleurJeu.moveRIGHT();
            else if(source==KeyEvent.VK_LEFT)
            	controleurJeu.moveLEFT();
		}

		public void keyReleased(KeyEvent e) {}

		public void keyTyped(KeyEvent e) {}
		
	}
}

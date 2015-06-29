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
	private PanneauInfoJeu pInfoJeu;
	
	public FenetreJeu(ControleurJeu controleurJeu){
		super();
		this.controleurJeu = controleurJeu;	
		
		pInfoJeu = new PanneauInfoJeu();
		add(pInfoJeu, BorderLayout.EAST);
		
		MenuJeu menuJeu = new MenuJeu(this, controleurJeu);
		setJMenuBar(menuJeu);
		this.addKeyListener(new EcouteurClavier());
		
	}
	
	public PanneauInfoJeu getPanneauInfoJeu(){
		return this.pInfoJeu;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		//Si la notification vient de Plateau alors c'est une nouvelle partie 
		if(arg0.getClass().getName().equals("boulderDash.modele.Plateau") && !arg1.getClass().getName().equals("[Ljava.lang.String;")){			
			ElementJeu tabElementsJeu[][] = (ElementJeu[][]) arg1;
			
			//Si c'est la première initialisation, pPlateau ne sera pas présent : nullPointerException
			try{
				this.remove(pPlateau);
			}catch(Exception e){}
			
			
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
		public void keyTyped(KeyEvent e)    {}
	}
}

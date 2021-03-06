package boulderDash.vue;

import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import boulderDash.controleur.ControleurEditeur;
import boulderDash.modele.ElementJeu;
import boulderDash.vue.composant.MenuEditeur;
import boulderDash.vue.composant.elementsJeu.PanneauDiamant;
import boulderDash.vue.composant.elementsJeu.PanneauMurAcier;
import boulderDash.vue.composant.elementsJeu.PanneauMurMagique;
import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;
import boulderDash.vue.composant.elementsJeu.PanneauPersonnage;
import boulderDash.vue.composant.elementsJeu.PanneauPierre;
import boulderDash.vue.composant.elementsJeu.PanneauTerre;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

public class FenetreEditeur extends FenetrePrincipale implements Observer{
	private ControleurEditeur controleurEditeur;
	private PanneauInfoEditeur pInfoEditeur;
	private PanneauPlateau pPlateau;
	
	public FenetreEditeur(ControleurEditeur controleurEditeur){
		super();
		this.controleurEditeur = controleurEditeur;
		pInfoEditeur = new PanneauInfoEditeur();
		add(pInfoEditeur, BorderLayout.EAST);
		
		this.addMouseListener(new EcouteurSouris());
		
		MenuEditeur menuEditeur = new MenuEditeur(this, controleurEditeur);
		setJMenuBar(menuEditeur);
	}
	
	public void update(Observable arg0, Object arg1) {
		if(arg0.getClass().getName().equals("boulderDash.modele.Plateau")){	
			if(arg1.getClass().getName().equals("[[LboulderDash.modele.ElementJeu;")){
				ElementJeu tabElementsJeu[][] = (ElementJeu[][]) arg1;
				
				pPlateau = new PanneauPlateau(tabElementsJeu.length, tabElementsJeu[0].length);
				
				for(int i = 0; i < tabElementsJeu[0].length; i++){
					for(int j = 0; j < tabElementsJeu.length; j++){
						if(tabElementsJeu[j][i] == null)
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
			}else{
				String tabModif[] = (String[]) arg1;
				
				if(tabModif[0].equals("Vide"))
					pPlateau.modifPanneauElementJeu(new PanneauVide(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("MurAcier"))
					this.pPlateau.modifPanneauElementJeu(new PanneauMurAcier(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("MurSimple"))
					this.pPlateau.modifPanneauElementJeu(new PanneauMurSimple(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("MurMagique"))
					this.pPlateau.modifPanneauElementJeu(new PanneauMurMagique(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("Terre"))
					this.pPlateau.modifPanneauElementJeu(new PanneauTerre(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("Pierre"))
					this.pPlateau.modifPanneauElementJeu(new PanneauPierre(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("Personnage"))
					this.pPlateau.modifPanneauElementJeu(new PanneauPersonnage(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
				else if(tabModif[0].equals("Diamant"))
					this.pPlateau.modifPanneauElementJeu(new PanneauDiamant(), Integer.parseInt(tabModif[1]), Integer.parseInt(tabModif[2]));
								
				this.repaint();
				this.setVisible(true);
			}
		}
	}
	
	public PanneauPlateau getpPlateau() {
		return pPlateau;
	}	

	public class EcouteurSouris implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			controleurEditeur.addElement(e.getX()/16, ((e.getY()/16)-2), pInfoEditeur.getElementEnCours());
		}

		public void mouseEntered(java.awt.event.MouseEvent e)  {}
		public void mouseExited(java.awt.event.MouseEvent e)   {}
		public void mousePressed(java.awt.event.MouseEvent e)  {}
		public void mouseReleased(java.awt.event.MouseEvent e) {}
		
	}
	
}
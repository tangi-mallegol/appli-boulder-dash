package boulderDash.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import boulderDash.vue.composant.elementsJeu.PanneauPersonnage;

public class PanneauPlateau extends JPanel implements Observer{
	private PanneauElementJeu[][] tabPanneauxElementsJeu;
	
	public PanneauPlateau(int x, int y){
		setLayout(new GridLayout(y,x));
		setSize(new Dimension(16*x, 16*y));
		
		tabPanneauxElementsJeu = new PanneauElementJeu[x][y];
	}
	
	public void addPanneauElementJeu(PanneauElementJeu panneauElementJeu, int x, int y){		
		tabPanneauxElementsJeu[x][y] = panneauElementJeu;
		add(tabPanneauxElementsJeu[x][y]);
	}
	
	public void deplace(int x1, int y1, int x2, int y2){
		System.out.println(SwingUtilities.getWindowAncestor(this).getClass().getName());
		//x1 et y1 sont les coordonnées du personnage
		//tabPanneauxElementsJeu[x2][y2].removeAll();
		PanneauElementJeu e1 = tabPanneauxElementsJeu[x1][y1];
		PanneauElementJeu e2 = tabPanneauxElementsJeu[x2][y2];
		remove(tabPanneauxElementsJeu[x1][y1]);
		remove(tabPanneauxElementsJeu[x2][y2]);
		if(tabPanneauxElementsJeu[x1][y1].getClass().getName().equals("boulderDash.vue.composant.elementsJeu.PanneauPersonnage")){
			PanneauPersonnage p = (PanneauPersonnage)e1;
			//System.out.println("test");
			p.Stop();
			
			//System.out.println(p.getComponent(0).getClass().getName());
			tabPanneauxElementsJeu[x1][y1] = e2;
			tabPanneauxElementsJeu[x2][y2] = p;
			p.Move();
			//tabPanneauxElementsJeu[x2][y2].add(p.getComponent(0));
			//System.out.println(p.getComponentCount());
			
		}
		else{
			PanneauPersonnage p = (PanneauPersonnage)tabPanneauxElementsJeu[x1][y1];
			tabPanneauxElementsJeu[x1][y1] = tabPanneauxElementsJeu[x2][y2];
			tabPanneauxElementsJeu[x2][y2] = p;
		}
		
		//tabPanneauxElementsJeu[x2][y2].add(tabPanneauxElementsJeu[x1][y1].getComponent(0));
		//tabPanneauxElementsJeu[x1][y1].removeAll();
		add(tabPanneauxElementsJeu[x1][y1]);
		add(tabPanneauxElementsJeu[x2][y2]);
		this.repaint();
		tabPanneauxElementsJeu[x1][y1].repaint();
		tabPanneauxElementsJeu[x2][y2].repaint();
	}

	public void update(Observable arg0, Object arg1) {
		if(arg0.getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage")){
			
			String[] tabLocation = (String[])arg1;
			
			if(tabLocation[2].equals("HAUT"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])+1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]));
			if(tabLocation[2].equals("BAS"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]));	
			
			if(tabLocation[2].equals("DROITE"))
				deplace(Integer.parseInt(tabLocation[0])-1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]));						
			if(tabLocation[2].equals("GAUCHE"))
				deplace(Integer.parseInt(tabLocation[0])+1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]));			
		}
	}
}
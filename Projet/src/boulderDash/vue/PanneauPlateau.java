package boulderDash.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

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
		//x1 et y1 sont les coordonnées du personnage
		tabPanneauxElementsJeu[x2][y2].removeAll();
		tabPanneauxElementsJeu[x2][y2].add(tabPanneauxElementsJeu[x1][y1].getComponent(0));
		tabPanneauxElementsJeu[x1][y1].removeAll();
		
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
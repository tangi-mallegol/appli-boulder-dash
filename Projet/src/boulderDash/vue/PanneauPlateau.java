package boulderDash.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import boulderDash.vue.composant.elementsJeu.PanneauPersonnage;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

import boulderDash.vue.composant.elementsJeu.PanneauVide;

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
	
	public void modifPanneauElementJeu(PanneauElementJeu panneauElementJeu, int x, int y){
		remove(tabPanneauxElementsJeu[x][y]);
		tabPanneauxElementsJeu[x][y] = panneauElementJeu;
		add(tabPanneauxElementsJeu[x][y],x+tabPanneauxElementsJeu.length*y);
		tabPanneauxElementsJeu[x][y].repaint();
		this.repaint();
	}
	
	public void deplace(int x1, int y1, int x2, int y2, char direction){
		//System.out.println(SwingUtilities.getWindowAncestor(this).getClass().getName());
		//x1 et y1 sont les coordonnées du personnage
		//tabPanneauxElementsJeu[x1][y1].removeAll();
		PanneauElementJeu e1 = tabPanneauxElementsJeu[x1][y1];
		PanneauElementJeu e2 = tabPanneauxElementsJeu[x2][y2];
		remove(tabPanneauxElementsJeu[x1][y1]);
		remove(tabPanneauxElementsJeu[x2][y2]);
		if(tabPanneauxElementsJeu[x1][y1].getClass().getName().equals("boulderDash.vue.composant.elementsJeu.PanneauPersonnage")){
			PanneauPersonnage p = (PanneauPersonnage)e1;
			p.Stop();
			//int index1 = tabPanneauxElementsJeu[x1][y1];
			int x = e2.getX();
			int y = e2.getY();
			int xx = p.getX();
			int yy = p.getY();
			
			tabPanneauxElementsJeu[x2][y2] = p;
			tabPanneauxElementsJeu[x1][y1] = new PanneauVide();
			
			tabPanneauxElementsJeu[x1][y1].setBounds(xx, yy, 16, 16);
			p.setBounds(x, y, 16, 16);
			//this.add(e2, 1);
			//this.add(p, 2);
			add(tabPanneauxElementsJeu[x2][y2]);
			add(tabPanneauxElementsJeu[x1][y1]);
			switch(direction){
				case 'g':
					p.Move(4);
					break;
				case 'd':
					p.Move(5);
					break;
				case 'h':
					p.Move(3);
					break;
				case 'b':
					p.Move(2);
					break;
				default:
					p.Move();
					break;
			}
			//tabPanneauxElementsJeu[x2][y2].add(p.getComponent(0));			
		}
		else{
			//int index1 = tabPanneauxElementsJeu[x1][y1];
			int x = e2.getX();
			int y = e2.getY();
			int xx = e1.getX();
			int yy = e1.getY();
			e2.setBounds(xx, yy, 16, 16);
			e1.setBounds(x, y, 16, 16);
			tabPanneauxElementsJeu[x1][y1] = e2;
			tabPanneauxElementsJeu[x2][y2] = e1;
			//this.add(e2, 1);
			//this.add(p, 2);
			add(tabPanneauxElementsJeu[x1][y1]);
			add(tabPanneauxElementsJeu[x2][y2]);
			//PanneauPersonnage p = (PanneauPersonnage)tabPanneauxElementsJeu[x1][y1];
			//tabPanneauxElementsJeu[x1][y1] = e2;
			//tabPanneauxElementsJeu[x2][y2] = p;
			//add(tabPanneauxElementsJeu[x1][y1]);
			//add(tabPanneauxElementsJeu[x2][y2]);
		}
		
		//tabPanneauxElementsJeu[x2][y2].add(tabPanneauxElementsJeu[x1][y1].getComponent(0));
		//tabPanneauxElementsJeu[x1][y1].removeAll();
		
		
		this.repaint();
		//tabPanneauxElementsJeu[x1][y1].repaint();
		//tabPanneauxElementsJeu[x2][y2].repaint();
	}

	public void update(Observable arg0, Object arg1) {
		if(arg0.getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage")){
			
			String[] tabLocation = (String[])arg1;
			
			if(tabLocation[2].equals("HAUT"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])+1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'h');
			if(tabLocation[2].equals("BAS"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'b');	
			if(tabLocation[2].equals("DROITE"))
				deplace(Integer.parseInt(tabLocation[0])-1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'d');						
			if(tabLocation[2].equals("GAUCHE"))
				deplace(Integer.parseInt(tabLocation[0])+1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'g');			
		}
	}
}

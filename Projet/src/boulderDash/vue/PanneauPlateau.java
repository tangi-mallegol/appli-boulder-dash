package boulderDash.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import boulderDash.vue.composant.elementsJeu.PanneauDiamant;
import boulderDash.vue.composant.elementsJeu.PanneauPersonnage;
import boulderDash.vue.composant.elementsJeu.PanneauPierre;
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
		PanneauElementJeu e1 = tabPanneauxElementsJeu[x1][y1];
		PanneauElementJeu e2 = tabPanneauxElementsJeu[x2][y2];
		remove(tabPanneauxElementsJeu[x1][y1]);
		remove(tabPanneauxElementsJeu[x2][y2]);
		if(tabPanneauxElementsJeu[x1][y1].getClass().getName().equals("boulderDash.vue.composant.elementsJeu.PanneauPersonnage")){
			PanneauPersonnage p = (PanneauPersonnage)e1;
			p.Stop();
			int x = e2.getX();
			int y = e2.getY();
			int xx = p.getX();
			int yy = p.getY();
			
			tabPanneauxElementsJeu[x2][y2] = p;
			tabPanneauxElementsJeu[x1][y1] = new PanneauVide();
			
			tabPanneauxElementsJeu[x1][y1].setBounds(xx, yy, 16, 16);
			p.setBounds(x, y, 16, 16);
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
		}		
		
		if(tabPanneauxElementsJeu[x1][y1].getClass().getName().equals("boulderDash.vue.composant.elementsJeu.PanneauPierre")){
			PanneauPierre pP = (PanneauPierre)e1;
			int x = e2.getX();
			int y = e2.getY();
			int xx = pP.getX();
			int yy = pP.getY();
			
			tabPanneauxElementsJeu[x2][y2] = pP;
			tabPanneauxElementsJeu[x1][y1] = new PanneauVide();
			
			tabPanneauxElementsJeu[x1][y1].setBounds(xx, yy, 16, 16);
			pP.setBounds(x, y, 16, 16);
			add(tabPanneauxElementsJeu[x2][y2]);
			add(tabPanneauxElementsJeu[x1][y1]);		
		}
		
		if(tabPanneauxElementsJeu[x1][y1].getClass().getName().equals("boulderDash.vue.composant.elementsJeu.PanneauDiamant")){
			PanneauDiamant pD = (PanneauDiamant)e1;
			int x =  e2.getX();
			int y =  e2.getY();
			int xx = pD.getX();
			int yy = pD.getY();
			
			tabPanneauxElementsJeu[x2][y2] = pD;
			tabPanneauxElementsJeu[x1][y1] = new PanneauVide();
			
			tabPanneauxElementsJeu[x1][y1].setBounds(xx, yy, 16, 16);
			pD.setBounds(x, y, 16, 16);
			add(tabPanneauxElementsJeu[x2][y2]);
			add(tabPanneauxElementsJeu[x1][y1]);		
		}
		tabPanneauxElementsJeu[x1][y1].repaint();
		tabPanneauxElementsJeu[x2][y2].repaint();
		this.repaint();
	}

	public void update(Observable arg0, Object arg1) {
		if(arg0.getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage")){
			
			String[] tabLocation = (String[])arg1;
			
			if(tabLocation[2].equals("HAUT"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])+1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'h');
			if(tabLocation[2].equals("BAS"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'b');	
			
			if(tabLocation[3].equals("OUI")){
				if(tabLocation[2].equals("DROITE")){
					deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0])+1, Integer.parseInt(tabLocation[1]),'d');
					deplace(Integer.parseInt(tabLocation[0])-1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'d');						
				}
				if(tabLocation[2].equals("GAUCHE")){
					deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0])-1, Integer.parseInt(tabLocation[1]),'g');
					deplace(Integer.parseInt(tabLocation[0])+1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'g');
				}
			}
			
			if(tabLocation[3].equals("NON")){
				if(tabLocation[2].equals("DROITE"))
					deplace(Integer.parseInt(tabLocation[0])-1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'d');						
				if(tabLocation[2].equals("GAUCHE"))
					deplace(Integer.parseInt(tabLocation[0])+1,Integer.parseInt(tabLocation[1]), Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'g');
			}
			
		}else if(arg0.getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre")){
			String[] tabLocation = (String[])arg1;
			if(tabLocation[2].equals("BAS"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'b');
			if(tabLocation[2].equals("DROITE"))				
				deplace(Integer.parseInt(tabLocation[0])-1,Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'d');
			if(tabLocation[2].equals("GAUCHE"))				
				deplace(Integer.parseInt(tabLocation[0])+1,Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'g');
		}else if(arg0.getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant")){
			String[] tabLocation = (String[])arg1;
			if(tabLocation[2].equals("BAS"))
				deplace(Integer.parseInt(tabLocation[0]),Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'b');
			if(tabLocation[2].equals("DROITE"))				
				deplace(Integer.parseInt(tabLocation[0])-1,Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'d');
			if(tabLocation[2].equals("GAUCHE"))				
				deplace(Integer.parseInt(tabLocation[0])+1,Integer.parseInt(tabLocation[1])-1, Integer.parseInt(tabLocation[0]), Integer.parseInt(tabLocation[1]),'g');
		}
	}
	
}

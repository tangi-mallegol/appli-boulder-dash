package boulderDash.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.GenererGrille;
import boulderDash.modele.Plateau;
import boulderDash.vue.composant.elementsJeu.PanneauMurAcier;
import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

public class PanneauPlateau extends JPanel implements Observer{
	private PanneauElementJeu[][] tabPanneauxElementsJeu;
	private int xPerso;
	private int yPerso;
	
	public PanneauPlateau(int x, int y){
		setLayout(new GridLayout(y,x));
		setSize(new Dimension(16*x, 16*y));
		
		tabPanneauxElementsJeu = new PanneauElementJeu[x][y];
	}
	
	public void addPanneauElementJeu(PanneauElementJeu panneauElementJeu, int x, int y){
		if(panneauElementJeu.getClass().getName().equals("boulderDash.vue.composant.elementsJeu.PanneauPersonnage")){
			xPerso = x;
			yPerso = y;
		}			
		
		tabPanneauxElementsJeu[x][y] = panneauElementJeu;
		add(tabPanneauxElementsJeu[x][y]);
	}

	public void update(Observable arg0, Object arg1) {
		System.out.println(arg1);
		if(arg0.getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage")){
			System.out.println(xPerso+" "+yPerso);
			tabPanneauxElementsJeu[(int)arg1/10][(int)arg1%10] = tabPanneauxElementsJeu[xPerso][yPerso];
			
			xPerso = (int)arg1/10;
			yPerso = (int)arg1%10;
			
			tabPanneauxElementsJeu[(int)arg1/10][(int)arg1%10].repaint();
			tabPanneauxElementsJeu[(int)arg1/10][(int)arg1%10].setVisible(true);
			
			repaint();
			setVisible(true);
			
			
		}
	}
}
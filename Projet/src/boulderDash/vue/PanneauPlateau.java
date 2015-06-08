package boulderDash.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.GenererGrille;
import boulderDash.modele.Plateau;
import boulderDash.vue.composant.elementsJeu.PanneauMurAcier;
import boulderDash.vue.composant.elementsJeu.PanneauMurSimple;
import boulderDash.vue.composant.elementsJeu.PanneauVide;

public class PanneauPlateau extends JPanel{
	public PanneauPlateau(int x, int y){
		Window window = SwingUtilities.windowForComponent(this);
		if (window instanceof JFrame) {
			JFrame frame = (JFrame) window;
	 
			frame.setSize(new Dimension(16*x+150, 16*y));
		}
		
		
		setLayout(new GridLayout(y,x));
		
		
	}
}

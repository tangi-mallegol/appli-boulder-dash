package boulderDash.vue.composant.elementsJeu;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import boulderDash.vue.PanneauElementJeu;

public class PanneauMurSimple extends PanneauElementJeu implements Observer{
	public PanneauMurSimple(){
		JLabel imageLabel = new JLabel();

		ImageIcon ii;
		try {
			ii = new ImageIcon(ImageIO.read(new File("./donnees/brickwall.gif")));
			imageLabel.setIcon(ii);
	        imageLabel.setBounds(20,20,ii.getIconWidth(),ii.getIconHeight());

	        add(imageLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
}

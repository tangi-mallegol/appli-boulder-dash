package boulderDash.vue.composant.elementsJeu;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import boulderDash.vue.PanneauElementJeu;

public class PanneauPierre extends PanneauElementJeu{
	
	public PanneauPierre(){
		JLabel imageLabel = new JLabel();

		ImageIcon ii;
		try {
			ii = new ImageIcon(ImageIO.read(new File("./donnees/images/boulder.gif")));
			imageLabel.setIcon(ii);
	        imageLabel.setBounds(16,16,ii.getIconWidth(),ii.getIconHeight());

	        add(imageLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

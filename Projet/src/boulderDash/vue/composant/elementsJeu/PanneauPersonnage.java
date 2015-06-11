package boulderDash.vue.composant.elementsJeu;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import boulderDash.vue.PanneauElementJeu;

public class PanneauPersonnage extends PanneauElementJeu implements Observer{
	public PanneauPersonnage(){
		JLabel imageLabel = new JLabel();

		ImageIcon ii;
		try {
			ii = new ImageIcon(ImageIO.read(new File("./donnees/images/steelwall.gif")));
			imageLabel.setIcon(ii);
	        imageLabel.setBounds(16,16,ii.getIconWidth(),ii.getIconHeight());

	        add(imageLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
}
	
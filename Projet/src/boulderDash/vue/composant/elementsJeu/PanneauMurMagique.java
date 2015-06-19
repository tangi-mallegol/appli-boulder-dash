package boulderDash.vue.composant.elementsJeu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import boulderDash.vue.PanneauElementJeu;

public class PanneauMurMagique extends PanneauElementJeu implements Observer{

	private JLabel[] TableauImage;
	
	public PanneauMurMagique(){
		BufferedImage ii = null;
		try {
			ii = ImageIO.read(new File("./donnees/images/magicwall.gif"));
			//imageLabel.setIcon(ii);
	        //imageLabel.setBounds(16,16,ii.getIconWidth(),ii.getIconHeight());

	        //add(imageLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TableauImage = new JLabel[4];
		for(int i = 0; i < 4; i ++){
			TableauImage[i] = new JLabel();
			TableauImage[i].setIcon(new ImageIcon(ii.getSubimage(16*i +8*i,0,16,16)));
			TableauImage[i].setBounds(0, 0, 16, 16);
		}
		add(TableauImage[0]);
		Move();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void Move(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			int i = 0;
			public void run(){
				remove(TableauImage[i%4]);
				i++;
				add(TableauImage[i%4]);
				repaint();
			}
		}, 500,50);
	}

	public JLabel[] getTableauImage() {
		return TableauImage;
	}

	public void setTableauImage(JLabel[] tableauImage) {
		TableauImage = tableauImage;
	}
	
}

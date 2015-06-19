package boulderDash.vue.composant.elementsJeu;

import java.awt.Component;
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
import javax.swing.JPanel;

import boulderDash.vue.PanneauElementJeu;

public class PanneauPersonnage extends PanneauElementJeu implements Observer{
	private JLabel[][] TableauImage;
	
	public PanneauPersonnage(){
		BufferedImage ii = null;
		try {
			ii = ImageIO.read(new File("./donnees/images/rockford.gif"));
			//imageLabel.setIcon(ii);
	        //imageLabel.setBounds(16,16,ii.getIconWidth(),ii.getIconHeight());
	        //add(imageLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TableauImage = new JLabel[6][8];
		TableauImage[0][0] = new JLabel();
		TableauImage[0][0].setIcon(new ImageIcon(ii.getSubimage(8 ,8 ,16,16)));
		TableauImage[0][0].setBounds(0, 0, 16, 16);
		for(int i = 1; i < 6; i ++){
			System.out.println("i = " + i);
			for(int j = 0; j < 8; j ++){
				System.out.println("j = " + j);
				TableauImage[i][j] = new JLabel();
				TableauImage[i][j].setIcon(new ImageIcon(ii.getSubimage(7 + 16*j +8*j,7 + 16*i + 8*i ,16,16)));
				TableauImage[i][j].setBounds(0, 0, 16, 16);
			}
		}
		//add(TableauImage[0][0]);
		Move();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void Move(){
		Sprite sprite = new Sprite(this);
		sprite.start();
	}
	
	public class Sprite extends Thread{
		
		private int i;
		private PanneauPersonnage p;
		
		public Sprite(PanneauPersonnage p){
			i = 0;
			this.p = p;
		}
		
		public void run(){
			try {
				sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
				p.remove(TableauImage[4][i%8]);
				i++;
				//System.out.println("["+ i%6 + ":" + 0 + "]");
				p.add(TableauImage[4][i%8]);
				p.repaint();
				try {
					sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public void left(){
			
		}
		
		public void right(){
			
		}
		
		public void haut(){
			
		}
		
		public void bas(){
			
		}
		
	}
}
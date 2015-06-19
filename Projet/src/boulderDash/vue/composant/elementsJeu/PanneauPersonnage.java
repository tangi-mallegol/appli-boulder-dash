package boulderDash.vue.composant.elementsJeu;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import boulderDash.vue.PanneauElementJeu;

public class PanneauPersonnage extends PanneauElementJeu implements Observer{
	private JLabel[][] TableauImage;
	public Sprite sprite;
	
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
			//System.out.println("i = " + i);
			for(int j = 0; j < 8; j ++){
				//System.out.println("j = " + j);
				TableauImage[i][j] = new JLabel();
				TableauImage[i][j].setIcon(new ImageIcon(ii.getSubimage(7 + 16*j +8*j,7 + 16*i + 8*i ,16,16)));
				TableauImage[i][j].setBounds(0, 0, 16, 16);
			}
		}
		//add(TableauImage[0][0]);
		//sprite.run();
		Move();
	}

	
	public void Move(){
		sprite = new Sprite(this, 2);
		sprite.start();
	}
	
	public void Stop(){
		try{
			sprite.StopMove();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Move(int etat){
		if(sprite != null)
			sprite.stop();
		sprite = new Sprite(this, etat);
		sprite.start();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	public class Sprite extends Thread{
		
		private int i;
		private PanneauPersonnage p;
		private int etat;
		/*
		 * Ici, on défini les etats en fonction de l'emplacement des images dans TableauImage :
		 * 
		 * 1 : Ne bouge pas / Descend
		 * 2 : Monte
		 * 3 : Va à gauche
		 * 4 : Va à droite
		 * 
		 */
		
		
		public Sprite(PanneauPersonnage p, int etat){
			this.etat = etat;
			i = 0;
			this.p = p;
		}
		
		public void run(){
			try {
				sleep(50);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
				//On met le sprite de direction pendant 3 frame car boulder arrête de bouger au bout d'un moment
				if(i>3)
					etat = 1;
				p.removeAll();
				i++;
				p.add(TableauImage[etat][i%8]);
				p.repaint();
				try {
					//On met un temps de 50 ms entre chaque changement de frame
					sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public int getEtat(){
			return this.etat;
		}
		
		public void StopMove(){
			stop();
		}
		
	}
}
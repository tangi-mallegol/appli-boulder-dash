package boulderDash.modele.elementsJeu;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import boulderDash.modele.ElementJeu;

public class MurSimple implements ElementJeu{
	
	//Traduit en .csv par -
	
	private int x,y;
	
	public MurSimple(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {return x;}
	public int getY() {return y;}
	
	public void setLocation(Integer x, Integer y, String action){
		this.x = x;
		this.y = y;
	}
}
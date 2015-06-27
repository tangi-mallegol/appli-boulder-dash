package boulderDash.modele.elementsJeu;

import boulderDash.modele.ElementJeu;

public class Vide implements ElementJeu{
	private int x,y;
	
	public Vide(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Vide(){}

	public int getX() {return x;}
	public int getY() {return y;}
}

package boulderDash.modele.elementsJeu;

import boulderDash.modele.ElementJeu;

public class Terre implements ElementJeu{

	//Traduit par = sur le .csv
	
	private int x,y;
	
	public Terre(int x, int y){
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
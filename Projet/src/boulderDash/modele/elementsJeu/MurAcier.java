package boulderDash.modele.elementsJeu;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.Plateau;

public class MurAcier implements ElementJeu{
	private int x,y;
	
	public MurAcier(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {return x;}
	public int getY() {return y;}

	//Traduit par = sur le .csv
	
	
}

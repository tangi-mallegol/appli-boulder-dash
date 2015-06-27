package boulderDash.modele.elementsJeu;
import java.util.Observable;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.Plateau;

public class Pierre extends Observable implements ElementJeu{
	private int x, y;
	private Plateau plateau;

	//Traduit par o sur le .csv
	
	public Pierre(int x, int y, Plateau plateau){
		this.x = x;
		this.y = y;
		this.plateau = plateau;
	}

	public int getX() {return x;}
	public int getY() {return y;}

	public void setLocation(Integer x, Integer y){
		String[] tabLocation = new String[3];
		
		if(this.y<y && this.x==x){
			tabLocation[0] = x.toString();
			tabLocation[1] = y.toString();
			tabLocation[2] = "BAS";
		}else if(this.y<y && this.x>x){
			tabLocation[0] = x.toString();
			tabLocation[1] = y.toString();
			tabLocation[2] = "GAUCHE";
			System.out.println("GAUCHE");
		}else if(this.y<y && this.x<x){
			tabLocation[0] = x.toString();
			tabLocation[1] = y.toString();
			tabLocation[2] = "DROITE";
			System.out.println("Droite");
		}
			
		plateau.deplaceElement(this.x, this.y, x, y);
		
		this.x = x;
		this.y = y;			
		
		setChanged();
		
		notifyObservers(tabLocation);
	}
}

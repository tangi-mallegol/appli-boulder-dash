package boulderDash.modele.elementsJeu;

import java.util.Observable;

import boulderDash.modele.ElementJeu;

public class Personnage extends Observable implements ElementJeu{
	private int x, y;
	
	public Personnage(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setLocation(int x, int y){
		this.x = x;
		this.y = y;
		setChanged();
		
		notifyObservers((x*10+y));

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
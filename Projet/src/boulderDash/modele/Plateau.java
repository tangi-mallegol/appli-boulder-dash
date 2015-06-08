package boulderDash.modele;

import java.util.Observable;

import boulderDash.modele.elementsJeu.MurAcier;
import boulderDash.modele.elementsJeu.MurSimple;

public class Plateau extends Observable{
	ElementJeu tabElementsJeu[][];
	private int x, y;

	public Plateau(int x, int y){
		this.x = x;
		this.y = y;
		
		tabElementsJeu = new ElementJeu[x][y];
		
		for(int i=0; i<x; i++)
			tabElementsJeu[i][0] = new MurAcier();		
		for(int i=0; i<y; i++)
				tabElementsJeu[0][i] = new MurAcier();
		
		for(int i=x-1; i>0; i--)
			tabElementsJeu[i][y-1] = new MurAcier();
		
		for(int i=y-1; i>0; i--)
			tabElementsJeu[x-1][i] = new MurAcier();		
	}

	public void addMurSimple(int x, int y){
		tabElementsJeu[x][y] = new MurSimple();
	}
	
	public void majPlateau(){
		notifyObservers(tabElementsJeu);
	}
	
	public ElementJeu[][] getTabElementsJeu() {
		return tabElementsJeu;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

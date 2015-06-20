package boulderDash.modele;

import java.util.Observable;

import boulderDash.modele.elementsJeu.*;

public class Plateau extends Observable{
	private ElementJeu tabElementsJeu[][];
	private int x, y;
	private Personnage personnage;

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

	public void addMurMagique(int x, int y){
		tabElementsJeu[x][y] = new MurMagique();
	}
	
	public void addTerre(int x, int y){
		tabElementsJeu[x][y] = new Terre();
	}
	
	public void addPierre(int x, int y){
		tabElementsJeu[x][y] = new Pierre();
	}
	
	public void addPersonnage(int x, int y){
		personnage = new Personnage(x, y, this);
		tabElementsJeu[x][y] = personnage;
	}
	
	public void initPanneauPlateau(){
		setChanged();
		notifyObservers(tabElementsJeu);
	}
	
	public void modifPanneauPlateau(String element, Integer x, Integer y){
		String[] tabLocationModif = {element, x.toString(), y.toString()};
		setChanged();
		notifyObservers(tabLocationModif);
	}
	
	public ElementJeu[][] getTabElementsJeu() {
		return tabElementsJeu;
	}

	public Personnage getPersonnage() {
		return personnage;
	}
}

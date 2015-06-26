package boulderDash.modele;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import boulderDash.modele.elementsJeu.*;
import boulderDash.vue.composant.elementsJeu.PanneauTerre;

public class Plateau extends Observable{
	private ElementJeu tabElementsJeu[][];
	private List lElementsMobiles;
	private int x, y;
	private Personnage personnage;
	private String nomCarte;

	public Plateau(int x, int y){
		this.x = x;
		this.y = y;
		
		tabElementsJeu = new ElementJeu[x][y];
		lElementsMobiles = new LinkedList<ElementJeu>();	
	}
	
	public Plateau(int x, int y, String nomCarte){
		this(x,y);
		this.nomCarte = nomCarte;
		
		for(int i=0; i<x; i++)
			tabElementsJeu[i][0] = new MurAcier();		
		for(int i=0; i<y; i++)
			tabElementsJeu[0][i] = new MurAcier();
		
		for(int i=x-1; i>0; i--)
			tabElementsJeu[i][y-1] = new MurAcier();		
		for(int i=y-1; i>0; i--)
			tabElementsJeu[x-1][i] = new MurAcier();
		
		for(int i = 1; i < tabElementsJeu[0].length-1; i++)
			for(int j = 1; j < tabElementsJeu.length-1; j++)
				tabElementsJeu[j][i] = new Terre();
	}

	public void addMurAcier(int x, int y)	{ tabElementsJeu[x][y] = new MurAcier();	}	
	public void addMurSimple(int x, int y)	{ tabElementsJeu[x][y] = new MurSimple(); 	}
	public void addMurMagique(int x, int y)	{ tabElementsJeu[x][y] = new MurMagique();	}	
	public void addTerre(int x, int y)		{ tabElementsJeu[x][y] = new Terre(); 		}
	public void addVide(int x, int y)		{ tabElementsJeu[x][y] = new Vide(); 		}
	
	public void addPierre(int x, int y){
		Pierre pierre = new Pierre(x,y,this);
		lElementsMobiles.add(pierre);
		tabElementsJeu[x][y] = pierre;
	}
	
	public void addDiamant(int x, int y) {
		Diamant diamant = new Diamant(x,y,this);
		lElementsMobiles.add(diamant);
		tabElementsJeu[x][y] = diamant;
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
	
	public void verifElementsMobiles(){
		
	}
	
	//Deplace un element : l'ancienne position sera remplacee par l'element Vide
	public void deplaceElement(int x1, int y1, int x2, int y2){
		tabElementsJeu[x2][y2] = tabElementsJeu[x1][y1];
		tabElementsJeu[x1][y1] = new Vide();
	}
	
	public ElementJeu[][] getTabElementsJeu() 	{ return tabElementsJeu; }
	public Personnage getPersonnage()			{ return personnage; 	 }	
	public String getNomCarte()					{ return nomCarte; 		 }
}

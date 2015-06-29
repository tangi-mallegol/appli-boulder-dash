package boulderDash.modele;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import boulderDash.modele.elementsJeu.*;
import boulderDash.vue.composant.elementsJeu.PanneauTerre;

public class Plateau extends Observable{
	private ElementJeu tabElementsJeu[][];
	private List<ElementJeu> lElementsMobiles;
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
			tabElementsJeu[i][0] = new MurAcier(i,0);		
		for(int i=0; i<y; i++)
			tabElementsJeu[0][i] = new MurAcier(0,i);
		
		for(int i=x-1; i>0; i--)
			tabElementsJeu[i][y-1] = new MurAcier(i,y-1);		
		for(int i=y-1; i>0; i--)
			tabElementsJeu[x-1][i] = new MurAcier(x-1,i);
		
		for(int i = 1; i < tabElementsJeu[0].length-1; i++)
			for(int j = 1; j < tabElementsJeu.length-1; j++)
				tabElementsJeu[j][i] = new Terre(j,i);
	}

	public void addMurAcier(int x, int y)	{ tabElementsJeu[x][y] = new MurAcier(x,y);	}	
	public void addMurSimple(int x, int y)	{ tabElementsJeu[x][y] = new MurSimple(x,y);}
	public void addMurMagique(int x, int y)	{ tabElementsJeu[x][y] = new MurMagique(x,y);}	
	public void addTerre(int x, int y)		{ tabElementsJeu[x][y] = new Terre(x,y); 	}
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
		int xElement, yElement;
		for(int i=0; i<lElementsMobiles.size(); i++){
			xElement = lElementsMobiles.get(i).getX();
			yElement = lElementsMobiles.get(i).getY();
			
			if(tabElementsJeu[xElement][yElement+1].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide"))
				tomberBas(tabElementsJeu[xElement][yElement]);
			
			if(tabElementsJeu[xElement+1][yElement+1].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide") &&
			   tabElementsJeu[xElement+1][yElement].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide") &&
			   tabElementsJeu[xElement][yElement+1].getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre"))
				tomberDroite(tabElementsJeu[xElement][yElement]);
			
			if(tabElementsJeu[xElement-1][yElement+1].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide")&&
			   tabElementsJeu[xElement-1][yElement].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide") &&
			   tabElementsJeu[xElement][yElement+1].getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre"))
				tomberGauche(tabElementsJeu[xElement][yElement]);
		}
	}
	
	public void supprDiamant(int x, int y){
		for(int i=0; i<lElementsMobiles.size(); i++){
			if(lElementsMobiles.get(i).getX() == x && lElementsMobiles.get(i).getY() == y)
				lElementsMobiles.remove(i);
		}
	}
	
	public void tomberBas(ElementJeu elementJeu){
		int xElement, yElement;
		xElement = elementJeu.getX();
		yElement = elementJeu.getY();
		
		if(elementJeu.getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant")){
			Diamant diamant = (Diamant)elementJeu;
			diamant.setLocation(xElement, yElement+1);
		}else if(elementJeu.getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre")){
			Pierre pierre = (Pierre)elementJeu;
			pierre.setLocation(xElement, yElement+1);
		}
		
		modifPanneauPlateau("Vide", xElement, yElement);
		modifPanneauPlateau(elementJeu.getClass().getName().substring(31), xElement, yElement+1);
		
		verifElementsMobiles();
	}
	
	public void tomberDroite(ElementJeu elementJeu){
		int xElement, yElement;
		xElement = elementJeu.getX();
		yElement = elementJeu.getY();
		
		if(elementJeu.getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant")){
			Diamant diamant = (Diamant)elementJeu;
			diamant.setLocation(xElement+1, yElement+1);
		}else if(elementJeu.getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre")){
			Pierre pierre = (Pierre)elementJeu;
			pierre.setLocation(xElement+1, yElement+1);
		}
		
		modifPanneauPlateau("Vide", xElement, yElement);
		modifPanneauPlateau(elementJeu.getClass().getName().substring(31), xElement, yElement+1);

		verifElementsMobiles();
	}
	
	public void tomberGauche(ElementJeu elementJeu){
		int xElement, yElement;
		xElement = elementJeu.getX();
		yElement = elementJeu.getY();
		
		if(elementJeu.getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant")){
			Diamant diamant = (Diamant)elementJeu;
			diamant.setLocation(xElement-1, yElement+1);
		}else if(elementJeu.getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre")){
			Pierre pierre = (Pierre)elementJeu;
			pierre.setLocation(xElement-1, yElement+1);
		}
		
		modifPanneauPlateau("Vide", xElement, yElement);
		modifPanneauPlateau(elementJeu.getClass().getName().substring(31), xElement, yElement+1);

		verifElementsMobiles();
	}
	
	//Deplace un element : l'ancienne position sera remplacee par l'element Vide
	public void deplaceElement(int x1, int y1, int x2, int y2){
		tabElementsJeu[x2][y2] = tabElementsJeu[x1][y1];
		tabElementsJeu[x1][y1] = new Vide();
	}
	

	
	public void setNomCarte(String nomCarte) 	  { this.nomCarte = nomCarte; }
	
	public ElementJeu[][] getTabElementsJeu() 	  { return tabElementsJeu;	 }
	public Personnage getPersonnage()			  { return personnage; 	 	 }	
	public String getNomCarte()					  { return nomCarte; 		 }
	public List<ElementJeu> getlElementsMobiles() {	return lElementsMobiles; }
}

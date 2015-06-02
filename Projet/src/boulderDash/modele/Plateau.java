package boulderDash.modele;

import boulderDash.modele.elementsJeu.MurAcier;
import boulderDash.modele.elementsJeu.MurSimple;

public class Plateau {
	ElementJeu tabElementsJeu[][];
	private int x, y;

	public Plateau(int x, int y){
		this.x = x;
		this.y = y;
		
		tabElementsJeu = new ElementJeu[x][y];
		
		for(int i=0; i<tabElementsJeu[0].length; i++)
				tabElementsJeu[0][i] = new MurAcier();
		
		for(int i=0; i<tabElementsJeu.length; i++)
			tabElementsJeu[i][0] = new MurAcier();
		
		/*for(int i=tabElementsJeu[0].length; i>1; i--)
			tabElementsJeu[0][i] = new MurAcier();
		
		for(int i=tabElementsJeu.length; i>1; i--)
			tabElementsJeu[i][0] = new MurAcier();*/
	}

	public void addMurSimple(int x, int y){
		tabElementsJeu[x][y] = new MurSimple();
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

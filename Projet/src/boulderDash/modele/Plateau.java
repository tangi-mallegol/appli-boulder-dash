package boulderDash.modele;

import boulderDash.modele.elementsJeu.MurAcier;

public class Plateau {
	ElementJeu tabElementsJeu[][];
	
	public Plateau(int x, int y){
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

	public ElementJeu[][] getTabElementsJeu() {
		return tabElementsJeu;
	}
}

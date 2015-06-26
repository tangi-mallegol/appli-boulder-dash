package boulderDash.modele.elementsJeu;
import boulderDash.modele.ElementJeu;
import boulderDash.modele.Plateau;

public class Pierre implements ElementJeu{
	private int x, y;

	//Traduit par o sur le .csv
	
	public Pierre(int x, int y, Plateau plateau){
		this.x = x;
		this.y = y;
	}
	
	
	
}

package boulderDash.modele.elementsJeu;
import boulderDash.modele.ElementJeu;
import boulderDash.modele.Plateau;

public class Diamant implements ElementJeu{
	private int x,y;
	private Plateau plateau;

	//Traduit par D sur le .csv
	
	public Diamant(int x, int y, Plateau plateau){
		this.x = x;
		this.y = y;
		this.plateau = plateau;
	}
}

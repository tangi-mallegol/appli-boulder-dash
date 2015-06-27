package boulderDash.modele.elementsJeu;

import java.util.Observable;

import boulderDash.modele.ElementJeu;
import boulderDash.modele.Plateau;

public class Personnage extends Observable implements ElementJeu{
	private int x, y;
	private Plateau plateau;
	
	public Personnage(int x, int y, Plateau plateau){
		this.x = x;
		this.y = y;
		this.plateau = plateau;
	}
	
	public void moveUP(){
		setLocation(x, y-1);
	}
	
	public void moveDOWN(){
		setLocation(x, y+1);
	}
	
	public void moveRIGHT(){
		setLocation(x+1, y);
	}
	
	public void moveLEFT(){
		setLocation(x-1, y);
	}
	
	public void setLocation(Integer x, Integer y){
		String[] tabLocation = new String[3];
		
		boolean bDeplaceOK = true;		
		
		if(plateau.getTabElementsJeu()[x][y].getClass().getName().equals("boulderDash.modele.elementsJeu.MurSimple") ||
		   plateau.getTabElementsJeu()[x][y].getClass().getName().equals("boulderDash.modele.elementsJeu.MurAcier")  ||
		   plateau.getTabElementsJeu()[x][y].getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre") )
			bDeplaceOK = false;
		
		if(plateau.getTabElementsJeu()[x][y].getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant"))
				plateau.supprDiamant(x, y);
		
		if(bDeplaceOK){			
			if(this.x<x){
				tabLocation[0] = x.toString();
				tabLocation[1] = y.toString();
				tabLocation[2] = "DROITE";
			}else if(this.x>x){
				tabLocation[0] = x.toString();
				tabLocation[1] = y.toString();
				tabLocation[2] = "GAUCHE";
			}
			
			if(this.y<y){
				tabLocation[0] = x.toString();
				tabLocation[1] = y.toString();
				tabLocation[2] = "BAS";
			}else if(this.y>y){
				tabLocation[0] = x.toString();
				tabLocation[1] = y.toString();
				tabLocation[2] = "HAUT";
			}
				
			plateau.deplaceElement(this.x, this.y, x, y);
			
			this.x = x;
			this.y = y;			
			
			setChanged();
			
			notifyObservers(tabLocation);
		}

	}

	public int getX() {return x;}
	public int getY() {return y;}
}
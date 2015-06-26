package boulderDash.controleur;

import boulderDash.modele.GenererCSV;
import boulderDash.modele.Plateau;
import boulderDash.vue.FenetreEditeur;
import boulderDash.vue.FenetreTaillePlateau;

public class ControleurEditeur extends Controleur{
	private Plateau plateau;
	
	public ControleurEditeur(){
		
	}
	
	public void nouvelleCarte(FenetreEditeur fEditeur){
		new FenetreTaillePlateau(this, fEditeur);
	}
	
	public void initPlateau(int x, int y, String nomCarte, FenetreEditeur fEditeur){
		plateau = new Plateau(x, y, nomCarte);
		plateau.addObserver(fEditeur);
		plateau.initPanneauPlateau();
	}
	
	public void addElement(int x, int y, String element){
		if(element.equals("Personnage"))
			plateau.addPersonnage(x, y);
		
		if(element.equals("MurSimple"))
			plateau.addMurSimple(x, y);
		
		if(element.equals("Terre"))
			plateau.addTerre(x, y);
		
		if(element.equals("Pierre"))
			plateau.addPierre(x, y);
		
		plateau.modifPanneauPlateau(element, x, y);
	}
	
	public void saveMAP(){
		GenererCSV genererCSV = new GenererCSV(plateau);
		genererCSV.GenererEtSauvegarder();		
	}
}
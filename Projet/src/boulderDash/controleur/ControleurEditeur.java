package boulderDash.controleur;

import java.io.IOException;

import boulderDash.modele.GenererCSV;
import boulderDash.modele.GenererGrille;
import boulderDash.modele.Plateau;
import boulderDash.modele.elementsJeu.Diamant;
import boulderDash.modele.elementsJeu.Pierre;
import boulderDash.vue.FenetreEditeur;
import boulderDash.vue.FenetreJeu;
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
	
	public void initNiveau(String nomNiveau, FenetreEditeur fEditeur){
		String nomNiveauEnCours = nomNiveau;
		GenererGrille genererGrille = new GenererGrille(nomNiveau);
		
		try {
			plateau = genererGrille.creerPlateau(fEditeur);
			plateau.setNomCarte(nomNiveau);
			plateau.addObserver(fEditeur);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
		
		if(element.equals("Diamant"))
			plateau.addDiamant(x, y);
		
		if(element.equals("Vide"))
			plateau.addVide(x, y);
		
		if(element.equals("MurAcier"))
			plateau.addMurAcier(x, y);
		
		plateau.modifPanneauPlateau(element, x, y);
	}
	
	public void saveMAP(){
		GenererCSV genererCSV = new GenererCSV(plateau);
		genererCSV.GenererEtSauvegarder();		
	}
}
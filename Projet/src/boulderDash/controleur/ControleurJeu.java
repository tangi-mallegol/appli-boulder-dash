package boulderDash.controleur;

import java.io.IOException;

import boulderDash.modele.GenererGrille;
import boulderDash.modele.InfoJeu;
import boulderDash.modele.Plateau;
import boulderDash.modele.elementsJeu.Diamant;
import boulderDash.modele.elementsJeu.Pierre;
import boulderDash.vue.FenetreJeu;

public class ControleurJeu extends Controleur{
	private Plateau plateau;
	private String nomNiveauEnCours;
	private InfoJeu infoJeu;
	
	public ControleurJeu(){}
	
	public void initNiveau(String nomNiveau, FenetreJeu fj){
		nomNiveauEnCours = nomNiveau;
		GenererGrille genererGrille = new GenererGrille(nomNiveau);
		
		try {
			plateau = genererGrille.creerPlateau(fj);	
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		plateau.getPersonnage().addObserver(fj.getpPlateau());
		
		for(int i=0; i<plateau.getlElementsMobiles().size(); i++){
			if(plateau.getlElementsMobiles().get(i).getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant")){
				Diamant diamant = (Diamant)plateau.getlElementsMobiles().get(i);
				diamant.addObserver(fj.getpPlateau());
			}else{
				Pierre pierre = (Pierre)plateau.getlElementsMobiles().get(i);
				pierre.addObserver(fj.getpPlateau());
			}
		}
		plateau.verifElementsMobiles();
	}
	
	public void initInfoJeu(FenetreJeu fj){
		infoJeu = new InfoJeu();
		infoJeu.addObserver(fj.getPanneauInfoJeu());
	}
	
	public void NouvellePartie(FenetreJeu fj){
		System.out.println("Nouvelle partie!");
		initNiveau(nomNiveauEnCours, fj);
	}
	
	public void OuvrirAide(){
	}
	
	public void moveUP(){		
		plateau.getPersonnage().moveUP();
		plateau.verifElementsMobiles();
	}
	
	public void moveDOWN(){
		plateau.getPersonnage().moveDOWN();
		plateau.verifElementsMobiles();
	}
	
	public void moveLEFT(){
		plateau.getPersonnage().moveLEFT();
		plateau.verifElementsMobiles();
	}
	
	public void moveRIGHT(){
		plateau.getPersonnage().moveRIGHT();
		plateau.verifElementsMobiles();
	}
}

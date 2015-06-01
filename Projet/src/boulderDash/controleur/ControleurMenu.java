package boulderDash.controleur;

public class ControleurMenu {
	
	private boolean Bclique = false;
	
	public ControleurMenu(){
		
	}
	
	public void OuvrirEditeur(){
		if(!Bclique){
			Bclique = true;
			new FenetreEditeur(new ControleurEditeur());
		}
	}
	
	public void OuvrirJeu(){
		if(!Bclique){
			Bclique = true;
			new FenetreJeu(new ControleurJeu());
		}
	}
}

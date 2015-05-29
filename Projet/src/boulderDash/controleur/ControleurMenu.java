package boulderDash.controleur;

public class ControleurMenu {
	
	private boolean Bclique = false;
	
	public ControleurMenu(){
		
	}
	
	public ControleurEditeur NewControlleurEditeur(){
		if(!Bclique){
			Bclique = true;
			return new ControleurEditeur();
		}
		return null;
	}
	
	public ControleurJeu NewControlleurJeu(){
		if(!Bclique){
			Bclique = true;
			return new ControleurJeu();
		}
		return null;
	}
}

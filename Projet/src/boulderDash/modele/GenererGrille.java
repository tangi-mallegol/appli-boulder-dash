package boulderDash.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenererGrille {
	
	private int x;
	private int y;
	private List<String> ListeElements;
	private int niveau;
	
	public GenererGrille(int niveau){
		/* Pour la lecture des .txt, on part du principe que la carte est entouré de steelwall.
		 * Les steelwall seront representés par des "="
		 * Pour calculer les tailles, on utilisera donc ces murs
		 */
		this.niveau = niveau;
		
		
	}
	
	public Plateau creerPlateau() throws IOException{
		//Recupération des fichiers
		this.ListeElements = new LinkedList<String>();
		File file = null;
		try{
			file = new File("./donnees/niveaux/" + this.niveau + ".csv");
		}
		catch(Exception e){
			
		}
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
        BufferedReader br = new BufferedReader(fr);
        int i = 0;
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            //On ajoute les lignes
        	ListeElements.add(line);
        	System.out.println(line + "\n");
        }

        try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //Création d'une nouvelle instance de Plateau
        this.x = ListeElements.get(1).split(";").length;
        this.y = ListeElements.size();
        System.out.println(this.x + " : " + this.y);
        Plateau plateau = new Plateau(this.x, this.y);
        //Plateau.addTerre();
        //Plateau.addMurSimple();
        
        String[] ArrayListString;
        int index_ligne = 0;
        int index_colonne = 0;
        for(String line : ListeElements){
        	ArrayListString = line.split(";");
        	this.x = ArrayListString.length;
        	for(String char_ : ArrayListString){
        		switch(char_){
        		/*case "0" :
        			Plateau.addTerre();
        			break;*/
        		case "-":
        			plateau.addMurSimple(index_colonne,index_ligne);
        			break;
        		/*case "+":
        			Plateau.addPierre();
        			break;*/
        		}
        		index_colonne ++;
        	}
        	index_colonne = 0;
        	index_ligne ++;
        }
        return plateau;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	/*public static void main(String[] args){
		GenererGrille grille = new GenererGrille(1);
		try {
			grille.creerPlateau();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
}

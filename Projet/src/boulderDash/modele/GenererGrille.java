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

import boulderDash.vue.FenetreJeu;
import boulderDash.vue.FenetrePrincipale;

public class GenererGrille<F extends FenetrePrincipale> {
	
	private int x;
	private int y;
	private List<String> ListeElements;
	private String nom;
	
	public GenererGrille(String nom){
		/* Pour la lecture des .txt, on part du principe que la carte est entouré de steelwall.
		 * Les steelwall seront representés par des "="
		 * Pour calculer les tailles, on utilisera donc ces murs
		 */
		this.nom = nom;
	}
	
	public Plateau creerPlateau(F fj) throws IOException{
		//Recupération des fichiers
		this.ListeElements = new LinkedList<String>();
		File file = null;
		try{
			file = new File("./donnees/niveaux/" + this.nom + ".csv");
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
        	//System.out.println(line + "\n");
        }

        try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //Création d'une nouvelle instance de Plateau
        
        //Calcul du nombre de case en longueur
        this.x = ListeElements.get(1).split(";").length;
        
        //Calcul du nombre de case en hauteur
        this.y = ListeElements.size();
        
        //Création du plateau avec en paramètre les dimensions du plateau pour le niveau selectionné
        Plateau plateau = new Plateau(this.x, this.y);
        plateau.addObserver(fj);
        
        String[] tabCaractereString;
        int index_ligne = 0;
        int index_colonne = 0;
        for(String line : ListeElements){
        	tabCaractereString = line.split(";");
        	this.x = tabCaractereString .length;
        	
        	for(String sCaractere : tabCaractereString){
        		
        		char caractere = sCaractere.charAt(0);
        		switch(caractere){
        		case '=' :
        			plateau.addMurAcier(index_colonne,index_ligne);
        			break;
        		case '0' :
        			plateau.addTerre(index_colonne,index_ligne);
        			break;
        		case '-':
        			plateau.addMurSimple(index_colonne,index_ligne);
        			break;
        		case 'R':
        			plateau.addPersonnage(index_colonne,index_ligne);
        			break;
        		case '+':
        			plateau.addPierre(index_colonne,index_ligne);
        			break;
        		case 'D':
        			plateau.addDiamant(index_colonne,index_ligne);
        			break;
        		case 'X':
        			plateau.addMurMagique(index_colonne,index_ligne);
        			break;
        		case ' ':
        			plateau.addVide(index_colonne,index_ligne);
        			break;
        		}
        		index_colonne ++;
        	}
        	index_colonne = 0;
        	index_ligne ++;
        }
        plateau.initPanneauPlateau();
        return plateau;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}	
}

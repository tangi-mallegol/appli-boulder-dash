package boulderDash.modele;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenererCSV {
	private Plateau plateau;
	
	public GenererCSV(Plateau plateau){
		this.plateau = plateau;
	}
	
	public void GenererEtSauvegarder(){
		String adressedufichier = "./donnees/niveaux/"+ plateau.getNomCarte() + ".csv";
		System.out.println(adressedufichier);
		
		ElementJeu[][] tabElementsJeu = plateau.getTabElementsJeu();
		
		try {
			FileWriter fw = new FileWriter(adressedufichier, true);
			BufferedWriter output = new BufferedWriter(fw);
			for(int i = 0; i < tabElementsJeu[0].length; i++){
				for(int j = 0; j < tabElementsJeu.length; j++){
					if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurAcier"))
						output.write("=");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurSimple"))
						output.write("-");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.MurMagique"))
						output.write("X");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Terre"))
						output.write("0");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Pierre"))
						output.write("+");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Personnage"))
						output.write("R");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Diamant"))
						output.write("D");
					else if(tabElementsJeu[j][i].getClass().getName().equals("boulderDash.modele.elementsJeu.Vide"))
						output.write(" ");
					
					if(j!=tabElementsJeu.length-1)
						output.write(";");
				}
				output.write("\n");
			}
			output.flush();			
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

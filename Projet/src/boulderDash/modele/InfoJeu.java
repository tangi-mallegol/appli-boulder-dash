package boulderDash.modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class InfoJeu extends Observable{
	private int score;
	private int temps;
	private int nb_diamant;
	
	public InfoJeu(){
		score = 0;
		temps = 0;
		nb_diamant = 0;
		//Timer qui compte le nombre de seconde passées
		/*Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run(){
				temps++;
				setChanged();
				notifyObservers(new Integer[]{score, temps, nb_diamant});
				
			}
		}, 500,1000);*/
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public int getNb_diamant() {
		return nb_diamant;
	}

	public void setNb_diamant(int nb_diamant) {
		this.nb_diamant = nb_diamant;
	}
	

}

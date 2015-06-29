package boulderDash.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauInfoJeu extends JPanel implements Observer{
	private JLabel temps, score;
	
	public PanneauInfoJeu(){
		setBackground(Color.WHITE);
		setSize(new Dimension(100,200));
		setLayout(new GridLayout(2,1));
		
		temps = new JLabel("TEMPS : 00:00:00");
		score = new JLabel("SCORE : 0");
		
		add(temps);
		add(score);
		//add(new JLabel("BOULDER DASH POWER"));
	}

	public void update(Observable o, Object arg) {
		System.out.println("update");
		//this.removeAll();
		Integer[] tableau_param = (Integer[])arg;
		int secondes = tableau_param[1]%60;
		int minutes = tableau_param[1]/60;
		int heures = tableau_param[1]/3600;
		//System.out.println("TEMPS : " + (heures < 10 ? "0" + heures : heures) +":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (secondes < 10 ? "0" + secondes : secondes));
		//System.out.println(this.countComponents());
		temps.setText("TEMPS : " + (heures < 10 ? "0" + heures : heures) +":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (secondes < 10 ? "0" + secondes : secondes));
		temps.repaint();
		score.setText("SCORE : " + tableau_param[0]);
		score.repaint();
		
		
		
		//repaint();
		//System.out.println(this.countComponents());
		//revalidate();
	}
}

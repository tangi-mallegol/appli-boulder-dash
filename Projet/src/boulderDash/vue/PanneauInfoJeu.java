package boulderDash.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauInfoJeu extends JPanel implements Observer{
	public PanneauInfoJeu(){
		setBackground(Color.WHITE);
		setSize(new Dimension(100,200));
		setLayout(new GridLayout(2,1));
		add(new JLabel("TEMPS : 00:00:00"));
		add(new JLabel("SCORE : 0"));
		//add(new JLabel("BOULDER DASH POWER"));
	}

	public void update(Observable o, Object arg) {
		System.out.println("update");
		this.removeAll();
		Integer[] tableau_param = (Integer[])arg;
		int secondes = tableau_param[1]%60;
		int minutes = tableau_param[1]/60;
		int heures = tableau_param[1]/3600;
		//System.out.println("TEMPS : " + (heures < 10 ? "0" + heures : heures) +":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (secondes < 10 ? "0" + secondes : secondes));
		System.out.println(this.countComponents());
		add(new JLabel("TEMPS : " + (heures < 10 ? "0" + heures : heures) +":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (secondes < 10 ? "0" + secondes : secondes)));
		add(new JLabel("SCORE : " + tableau_param[0]));
		System.out.println(this.countComponents());
		revalidate();
	}
}

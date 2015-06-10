package boulderDash.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauInfoJeu extends JPanel{
	public PanneauInfoJeu(){
		setBackground(Color.WHITE);
		setSize(new Dimension(100,200));
		setLayout(new GridLayout(3,1));
		
		add(new JLabel("TEMPS : 50:00:00"));
		add(new JLabel("SCORE : MAX SCORE"));
		add(new JLabel("BOULDER DASH POWER"));
	}
}

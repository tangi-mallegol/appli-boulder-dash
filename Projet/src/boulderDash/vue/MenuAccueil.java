package boulderDash.vue;

import boulderDash.controleur.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuAccueil extends JFrame{
	
	private JButton bEditeur;
	private JButton bJeu;
	private ControleurMenu ControleurMenu;
	
	public MenuAccueil(ControleurMenu ControllerMenu){
		setTitle("Boulder Dash");
		setSize(300, 250);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
		bEditeur = new JButton("Editer");
		bJeu 	 = new JButton("Jouer");
		
		add(new JLabel("Bienvenue sur notre putain de jeu trop bien !"), BorderLayout.NORTH);
		add(bEditeur, BorderLayout.CENTER);
		add(bJeu, BorderLayout.SOUTH);		
	}
	
	private class EditeurListener implements ActionListener{		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}

package boulderDash.vue;

import boulderDash.controleur.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreAccueil extends JFrame{
	
	private JButton bEditeur;
	private JButton bJeu;
	private ControleurMenu controleurMenu;
	
	public FenetreAccueil(ControleurMenu ControllerMenu){
		setTitle("Boulder Dash");
		setSize(300, 250);
		setResizable(true);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		controleurMenu = new ControleurMenu();
		
		Ecouteur ecouteur = new Ecouteur(this);
		
		bEditeur = new JButton("Editer");
		bEditeur.addActionListener(ecouteur);
		
		bJeu 	 = new JButton("Jouer");
		bJeu.addActionListener(ecouteur);
		
		add(new JLabel("Bienvenue sur notre putain de jeu trop bien !"), BorderLayout.NORTH);
		add(bEditeur, BorderLayout.CENTER);
		add(bJeu, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	private class Ecouteur implements ActionListener{
		private FenetreAccueil menuAccueil;
		
		public Ecouteur(FenetreAccueil menuAccueil){
			this.menuAccueil = menuAccueil;
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==bEditeur){
				menuAccueil.dispose();
				controleurMenu.OuvrirEditeur();
			}else if(e.getSource()==bJeu){
				menuAccueil.dispose();
				controleurMenu.OuvrirJeu();				
			}
		}
	}
}

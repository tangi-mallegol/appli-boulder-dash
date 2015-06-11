package boulderDash.vue;

import boulderDash.controleur.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreAccueil extends JFrame{
	
	private JButton bEditeur;
	private JButton bJeu;
	private ControleurAccueil controleurMenu;
	
	public FenetreAccueil(ControleurAccueil ControllerMenu){
		setTitle("Boulder Dash");
		setSize(350, 125);
		setResizable(true);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		controleurMenu = new ControleurAccueil();
		
		Ecouteur ecouteur = new Ecouteur(this);
		
		bEditeur = new JButton("Editer");
		bEditeur.addActionListener(ecouteur);
		
		bJeu 	 = new JButton("Jouer");
		bJeu.addActionListener(ecouteur);
		
		JLabel lBienvenue = new JLabel("Bienvenue sur BoulderDash !");
		JLabel lQueFaire = new JLabel("Que voulez-vous faire ?");
		Font font = new Font("Berlin Sans FB Demi", Font.PLAIN, 16);
		
		lBienvenue.setFont(font);
		lBienvenue.setHorizontalAlignment(JLabel.CENTER);
		lBienvenue.setVerticalAlignment(JLabel.CENTER);
		
		lQueFaire.setHorizontalAlignment(JLabel.CENTER);
		lQueFaire.setVerticalAlignment(JLabel.CENTER);
		
		JPanel pHaut = new JPanel(new GridLayout(2,1));
		pHaut.add(lBienvenue);
		pHaut.add(lQueFaire);
		
		JPanel pCentre = new JPanel();
		pCentre.add(bJeu);
		pCentre.add(bEditeur);
		
		add(pHaut, BorderLayout.NORTH);
		add(pCentre, BorderLayout.CENTER);
		
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

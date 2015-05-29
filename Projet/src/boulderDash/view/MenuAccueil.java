package boulderDash.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import boulderDash.controller.ControllerMenu;

public class MenuAccueil {
	
	private JButton Editeur;
	private JButton Jeu;
	private EditeurListener EditeurListener;
	private JeuListener JeuListener;
	private ControllerMenu ControlleurMenu;
	
	public MenuAccueil(ControllerMenu ControllerMenu){
		this.Editeur = new JButton();
		this.Jeu = new JButton();
		this.EditeurListener = new EditeurListener();
		this.JeuListener = new JeuListener();
		this.ControlleurMenu = ControllerMenu;
	}
	
	private class EditeurListener implements ActionListener{
		
		public EditeurListener(){
			super();
		}
		
		public void actionPerformed(ActionEvent e) {
			// On renvoi vers le panneau editeur
		}
	}
	
	
	private class JeuListener implements ActionListener{
		
		public JeuListener(){
			super();
		}
		
		public void actionPerformed(ActionEvent e) {
			// On renvoi vers le panneau de jeu
		}
	}
}

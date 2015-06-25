package boulderDash.vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import boulderDash.vue.composant.elementsJeu.*;

public class PanneauInfoEditeur extends JPanel{
	private PanneauElementJeu[] tabpElementsJeu;
	private JPanel pElements;
	private JPanel pGridElements;
	private JPanel pInfos;
	private JButton bSauvegarder;
	private PanneauElementJeu pElementEnCours;
	private String sElementEnCours;
	
	public PanneauInfoEditeur(){
		setLayout(new BorderLayout());
		sElementEnCours = "Terre";
		GridLayout layoutpElements = new GridLayout(3,4);
		layoutpElements.setHgap(5);
		layoutpElements.setVgap(5);
		
		pGridElements = new JPanel(layoutpElements);
		
		tabpElementsJeu = new PanneauElementJeu[9];
		
		tabpElementsJeu[0] = new PanneauPersonnage();
		//tabpElementsJeu[1] = new PanneauMurAcier();
		tabpElementsJeu[1] = new PanneauVide();
		tabpElementsJeu[2] = new PanneauTerre();
		tabpElementsJeu[3] = new PanneauMurSimple();
		tabpElementsJeu[4] = new PanneauPierre();
		tabpElementsJeu[5] = new PanneauPierre();
		tabpElementsJeu[6] = new PanneauPierre();
		tabpElementsJeu[7] = new PanneauPierre();
		tabpElementsJeu[8] = new PanneauPierre();
		
		
		EcouteurPElementsJeu ecouteurPElementsJeu = new EcouteurPElementsJeu();
		
		for(int i = 0; i<tabpElementsJeu.length; i++){
			tabpElementsJeu[i].addMouseListener(ecouteurPElementsJeu);
			pGridElements.add(tabpElementsJeu[i]);
		}
		
		pElements = new JPanel();		
		pElements.add(pGridElements);		
		
		pInfos = new JPanel();
		bSauvegarder = new JButton();
		bSauvegarder.setLabel("Sauvegarder");
		bSauvegarder.addMouseListener(new EcouteurSauvegarde());
		pElementEnCours = new PanneauPersonnage();
		pInfos.add(pElementEnCours);
		pInfos.add(bSauvegarder);
		
		add(pElements, BorderLayout.CENTER);
		add(pInfos, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public String getElementEnCours(){ return sElementEnCours; }
	
	public class EcouteurPElementsJeu implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			sElementEnCours = e.getSource().getClass().getName().substring(45, e.getSource().getClass().getName().length());
			System.out.println(sElementEnCours);
		}

		public void mouseEntered(MouseEvent e)  {}
		public void mouseExited(MouseEvent e)   {}
		public void mousePressed(MouseEvent e)  {}
		public void mouseReleased(MouseEvent e) {}
	}
	
	public class EcouteurSauvegarde implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			System.out.println("Mouse Listener MouseClicked");
			FenetreEditeur f = (FenetreEditeur) SwingUtilities.getWindowAncestor((Component) e.getSource());
			f.GenererTableauDonnées();
			//System.out.println(SwingUtilities.getWindowAncestor());
		}
		
		public void mouseEntered(MouseEvent e)  {}
		public void mouseExited(MouseEvent e)   {}
		public void mousePressed(MouseEvent e)  {}
		public void mouseReleased(MouseEvent e) {}
	}
}

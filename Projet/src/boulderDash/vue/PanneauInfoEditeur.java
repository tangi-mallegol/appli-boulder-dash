package boulderDash.vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
		
		tabpElementsJeu = new PanneauElementJeu[10];
		
		tabpElementsJeu[0] = new PanneauPersonnage();
		tabpElementsJeu[1] = new PanneauMurAcier();
		tabpElementsJeu[2] = new PanneauVide();
		tabpElementsJeu[3] = new PanneauTerre();
		tabpElementsJeu[4] = new PanneauMurSimple();
		tabpElementsJeu[5] = new PanneauPierre();
		tabpElementsJeu[6] = new PanneauPierre();
		tabpElementsJeu[7] = new PanneauPierre();
		tabpElementsJeu[8] = new PanneauPierre();
		tabpElementsJeu[9] = new PanneauPierre();
		
		
		EcouteurSouris ecouteurSouris = new EcouteurSouris();
		
		for(int i = 0; i<tabpElementsJeu.length; i++){
			tabpElementsJeu[i].addMouseListener(ecouteurSouris);
			pGridElements.add(tabpElementsJeu[i]);
		}
		
		pElements = new JPanel();		
		pElements.add(pGridElements);		
		
		pInfos = new JPanel();
		
		pElementEnCours = new PanneauPersonnage();
		pInfos.add(pElementEnCours);
		
		add(pElements, BorderLayout.CENTER);
		add(pInfos, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public String getElementEnCours(){ return sElementEnCours; }
	
	public class EcouteurSouris implements MouseListener{
		public void mouseClicked(MouseEvent e) {
			sElementEnCours = e.getSource().getClass().getName().substring(45, e.getSource().getClass().getName().length());
			System.out.println(sElementEnCours);
		}

		public void mouseEntered(MouseEvent e)  {}
		public void mouseExited(MouseEvent e)   {}
		public void mousePressed(MouseEvent e)  {}
		public void mouseReleased(MouseEvent e) {}
	}
}

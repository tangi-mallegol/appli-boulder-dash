package boulderDash.vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import boulderDash.controleur.ControleurEditeur;

public class FenetreTaillePlateau extends JFrame{
	private ControleurEditeur controleurEditeur;
	private JTextField tfX, tfY, tfNom;
	private JButton bAnnuler, bValider;
	private FenetreEditeur fEditeur;
	
	public FenetreTaillePlateau(ControleurEditeur controleurEditeur, FenetreEditeur fEditeur){
		this.controleurEditeur = controleurEditeur;
		this.fEditeur = fEditeur;
		
		setTitle("Boulder Dash");
		setSize(350, 125);
		setResizable(true);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4, 2));
		
		tfX = new JTextField();
		tfY = new JTextField();
		tfNom = new JTextField();
		
		bAnnuler = new JButton("Annuler");
		bValider = new JButton("Valider");
		
		EcouteurTaillePlateau ecouteurTaillePlateau = new EcouteurTaillePlateau(this);
		bAnnuler.addActionListener(ecouteurTaillePlateau);
		bValider.addActionListener(ecouteurTaillePlateau);
		
		add(new JLabel("Largeur :"));
		add(tfX);
		add(new JLabel("Hauteur :"));
		add(tfY);
		add(new JLabel("Nom :"));
		add(tfNom);
		add(bAnnuler);
		add(bValider);
		
		setVisible(true);
	}
	
	public class EcouteurTaillePlateau implements ActionListener{
		private FenetreTaillePlateau fTaillePlateau;
		
		public EcouteurTaillePlateau(FenetreTaillePlateau fTaillePlateau){
			this.fTaillePlateau = fTaillePlateau;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bAnnuler){
				fTaillePlateau.dispose();
			}
			
			if(e.getSource() == bValider){
				fTaillePlateau.dispose();
				controleurEditeur.initPlateau(Integer.parseInt(tfX.getText()), Integer.parseInt(tfY.getText()), tfNom.getText(), fEditeur);
			}				
		}		
	}
}

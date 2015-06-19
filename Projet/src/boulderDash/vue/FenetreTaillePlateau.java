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
	private JTextField tfX, tfY;
	private JButton bAnnuler, bValider;
	
	public FenetreTaillePlateau(ControleurEditeur controleurEditeur){
		this.controleurEditeur = controleurEditeur;
		
		setTitle("Boulder Dash");
		setSize(350, 125);
		setResizable(true);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(3, 2));
		
		tfX = new JTextField();
		tfY = new JTextField();
		
		bAnnuler = new JButton("Annuler");
		bValider = new JButton("Valider");
		
		EcouteurTaillePlateau ecouteurTaillePlateau = new EcouteurTaillePlateau(this);
		bAnnuler.addActionListener(ecouteurTaillePlateau);
		bValider.addActionListener(ecouteurTaillePlateau);
		
		add(new JLabel("Largeur :"));
		add(tfX);
		add(new JLabel("Hauteur :"));
		add(tfY);
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
			if(e.getSource() == bAnnuler)
				fTaillePlateau.dispose();
			
			if(e.getSource() == bValider){
				controleurEditeur.initPlateau(Integer.parseInt(tfX.getText()), Integer.parseInt(tfY.getText()));
			}				
		}
		
	}
}

package boulderDash.vue;

import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;

public abstract class FenetrePrincipale extends JFrame implements Observer{
	public FenetrePrincipale(){
		setTitle("Boulder Dash");
		setSize(1000, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		setVisible(true);
	}
}

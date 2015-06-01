package boulderDash.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauInfoEditeur extends JPanel{

	private JPanel TableauElement;
	private JPanel Infos;
	
	public PanneauInfoEditeur(){
		super(new BorderLayout());
		this.TableauElement = new JPanel(new GridLayout(3,4));
		this.Infos = new JPanel(new FlowLayout());
		this.add(this.TableauElement, BorderLayout.CENTER);
		this.add(this.Infos, BorderLayout.SOUTH);
		RemplirTableau();
		
	}
	
	private void RemplirTableau(){
		ImageIcon amoeba = new ImageIcon("./donnees/amoeba.gif");
		JLabel ButtonAmoeba = new JLabel(amoeba);
		this.TableauElement.add(ButtonAmoeba);
	}
	
	
}

package boulderDash.modele;

import java.awt.Rectangle;

import javax.swing.JPanel;

public interface ElementJeu{
	public int getX();
	public int getY();
	public void setLocation(Integer x, Integer y, String action);
}
package boulderDash.vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanneauInfoEditeur extends JPanel{

	private JPanel pTableauElement;
	private JPanel pInfos;
	
	public PanneauInfoEditeur(){
		super(new BorderLayout());
		GridLayout gridlayout = new GridLayout(3,4);
		gridlayout.setHgap(5);
		gridlayout.setVgap(5);
		this.pTableauElement = new JPanel(gridlayout);
		this.pInfos = new JPanel(new FlowLayout());
		this.add(this.pTableauElement, BorderLayout.CENTER);
		this.add(this.pInfos, BorderLayout.SOUTH);
		RemplirTableau();
	}
	
	private void RemplirTableau(){
		BufferedImage bigImg;
		try {
			bigImg = ImageIO.read(new File("./donnees/amoeba.gif"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		/*BufferedImage[] sprites = new BufferedImage[8];
		for (int i = 0; i < 8; i++)
		{
	        sprites[i] = bigImg.getSubimage(16*i + 8 * (i < 0 ? 0 : i), 0, 16, 16 );
		}*/
		
		JLabel LabelAmoeba = new JLabel(new ImageIcon(bigImg.getSubimage(0,0,16,16)));
		this.pTableauElement.add(LabelAmoeba);
		
		/*ImageIcon amoeba = new ImageIcon("./donnees/amoeba.gif");
		JLabel ButtonAmoeba = new JLabel(amoeba);
		this.TableauElement.add(ButtonAmoeba);*/

		
		ImageIcon boulder = new ImageIcon("./donnees/boulder.gif");
		JLabel ButtonBoulder = new JLabel(boulder);
		this.pTableauElement.add(ButtonBoulder);

		ImageIcon brickwall = new ImageIcon("./donnees/brickwall.gif");
		JLabel ButtonBrickWall = new JLabel(brickwall);
		this.pTableauElement.add(ButtonBrickWall);
		
		/*
		
		ImageIcon butterfly = new ImageIcon("./donnees/butterfly.gif");
		JLabel ButtonButterFly = new JLabel(butterfly);
		this.TableauElement.add(ButtonButterFly);
		*/
		
		try {
			bigImg = ImageIO.read(new File("./donnees/butterfly.gif"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		JLabel LabelButterFly = new JLabel(new ImageIcon(bigImg.getSubimage(0,0,16,16)));
		this.pTableauElement.add(LabelButterFly);
		
		
		/*
		ImageIcon diamond = new ImageIcon("./donnees/diamond.gif");
		JLabel ButtonDiamond = new JLabel(diamond);
		this.TableauElement.add(ButtonDiamond);
		*/
		
		try {
			bigImg = ImageIO.read(new File("./donnees/diamond.gif"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		JLabel LabelDiamond = new JLabel(new ImageIcon(bigImg.getSubimage(0,0,16,16)));
		this.pTableauElement.add(LabelDiamond);
		
		
		ImageIcon dirt = new ImageIcon("./donnees/dirt.gif");
		JLabel ButtonDirt = new JLabel(dirt);
		this.pTableauElement.add(ButtonDirt);
		
		
		
		
		/*
		ImageIcon firefly = new ImageIcon("./donnees/firefly.gif");
		JLabel ButtonFirefly = new JLabel(firefly);
		this.TableauElement.add(ButtonFirefly);
		*/
		
		try {
			bigImg = ImageIO.read(new File("./donnees/firefly.gif"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		JLabel LabelFirefly = new JLabel(new ImageIcon(bigImg.getSubimage(0,0,16,16)));
		this.pTableauElement.add(LabelFirefly);
		
		/*
		ImageIcon magicwall = new ImageIcon("./donnees/magicwall.gif");
		JLabel ButtonMagicWall = new JLabel(magicwall);
		this.TableauElement.add(ButtonMagicWall);
		*/
		
		try {
			bigImg = ImageIO.read(new File("./donnees/magicwall.gif"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		JLabel LabelMagicWall = new JLabel(new ImageIcon(bigImg.getSubimage(0,0,16,16)));
		this.pTableauElement.add(LabelMagicWall);
		
		/*
		ImageIcon rockford = new ImageIcon("./donnees/rockford.gif");
		JLabel ButtonRockford = new JLabel(rockford);
		this.TableauElement.add(ButtonRockford);
		*/
		
		try {
			bigImg = ImageIO.read(new File("./donnees/rockford.gif"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		JLabel LabelRockford = new JLabel(new ImageIcon(bigImg.getSubimage(7,7,16,16)));
		this.pTableauElement.add(LabelRockford);
		
		
		ImageIcon steelwall = new ImageIcon("./donnees/steelwall.gif");
		JLabel ButtonSteelWall = new JLabel(steelwall);
		this.pTableauElement.add(ButtonSteelWall);
	}
	
	
}

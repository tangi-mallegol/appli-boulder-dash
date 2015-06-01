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
		this.TableauElement.add(LabelAmoeba);
		/*ImageIcon amoeba = new ImageIcon("./donnees/amoeba.gif");
		JLabel ButtonAmoeba = new JLabel(amoeba);
		this.TableauElement.add(ButtonAmoeba);

		ImageIcon boulder = new ImageIcon("./donnees/amoeba.gif");
		JLabel ButtonBoulder = new JLabel(boulder);
		this.TableauElement.add(ButtonBoulder);

		ImageIcon brickwall = new ImageIcon("./donnees/brickwall.gif");
		JLabel ButtonBrickWall = new JLabel(brickwall);
		this.TableauElement.add(ButtonBrickWall);
		
		ImageIcon butterfly = new ImageIcon("./donnees/butterfly.gif");
		JLabel ButtonButterFly = new JLabel(butterfly);
		this.TableauElement.add(ButtonButterFly);
		
		ImageIcon diamond = new ImageIcon("./donnees/diamond.gif");
		JLabel ButtonDiamond = new JLabel(diamond);
		this.TableauElement.add(ButtonDiamond);
		
		ImageIcon dirt = new ImageIcon("./donnees/dirt.gif");
		JLabel ButtonDirt = new JLabel(dirt);
		this.TableauElement.add(ButtonDirt);
		
		ImageIcon firefly = new ImageIcon("./donnees/firefly.gif");
		JLabel ButtonFirefly = new JLabel(firefly);
		this.TableauElement.add(ButtonFirefly);
		
		ImageIcon magicwall = new ImageIcon("./donnees/magicwall.gif");
		JLabel ButtonMagicWall = new JLabel(magicwall);
		this.TableauElement.add(ButtonMagicWall);
		
		ImageIcon rockford = new ImageIcon("./donnees/rockford.gif");
		JLabel ButtonRockford = new JLabel(rockford);
		this.TableauElement.add(ButtonRockford);
		
		ImageIcon steelwall = new ImageIcon("./donnees/steelwall.gif");
		JLabel ButtonSteelWall = new JLabel(steelwall);
		this.TableauElement.add(ButtonSteelWall);*/
	}
	
	
}

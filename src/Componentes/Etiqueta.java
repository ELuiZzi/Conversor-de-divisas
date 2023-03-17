package Componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Etiqueta extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1412943041752961675L;
	String name;

	Image background = null;
	// Image entered = null;

	public Etiqueta(String name) {
		this.name = name;
		setOpaque(true);
		setBackground(new Color(0, 0, 0, 0));
	}

	protected void paintComponent(Graphics g) {
		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar imagen en Etiqueta");
			
		}
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		
		
	}

	public void paintEntered(Graphics g, String imgName) {

		try {
			background = ImageIO.read(new File("recursos\\imagenes\\entered/" + imgName + ".png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagenes Entered");
		}
		super.paintComponent(g);
		g.drawImage(background, getX(), getY(), getWidth(), getHeight(), null);
	

	}

	public void paintPressed(Graphics g, String imgName) {

		try {
			background = ImageIO.read(new File("recursos\\imagenes\\pressed/" + imgName + ".png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagenes Pressed");
		}
		super.paintComponent(g);
		g.drawImage(background, getX(), getY(), getWidth(), getHeight(), null);
	

	}

}

package Componentes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ToggleButton extends JToggleButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1412943041752961675L;
	String name;

	Image background = null;
	// Image entered = null;

	public ToggleButton(String name) {
		this.name = name;
	}

	protected void paintComponent(Graphics g) {
		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/" + name + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		setBackground(new Color(0, 0, 0, 0));
	}

	public void paintEntered(Graphics g, String imgName) {

		try {
			background = ImageIO.read(new File("recursos\\imagenes\\entered/" + imgName + ".png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagenes Entered");
		}
		super.paintComponent(g);
		g.drawImage(background, getX(), getY(), getWidth(), getHeight(), null);
		setBackground(new Color(0, 0, 0, 0));

	}

	public void paintPressed(Graphics g, String imgName) {

		try {
			background = ImageIO.read(new File("recursos\\imagenes\\pressed/" + imgName + ".png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagenes Pressed");
		}
		super.paintComponent(g);
		g.drawImage(background, getX(), getY(), getWidth(), getHeight(), null);
		setBackground(new Color(0, 0, 0, 0));

	}

}

package Componentes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JToggleButton;

public class ToggleButton extends JToggleButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1412943041752961675L;


	Image background = null;
	// Image entered = null;

	public ToggleButton() {

	}


	public void paintMonedas(Graphics g) {

		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/tgb1.png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagenes Moneda");
		}
		super.paintComponent(g);
		g.drawImage(background, getX(), getY(), getWidth(), getHeight(), null);
	

	}

	public void paintMasas(Graphics g) {

		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/tgb2.png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagenes Masa");
		}
		super.paintComponent(g);
		g.drawImage(background, getX(), getY(), getWidth(), getHeight(), null);
	
		
	}

}

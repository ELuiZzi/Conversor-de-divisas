package Componentes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class MontoTextField extends JTextField {
	String name = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2574885836885776664L;

	public MontoTextField(String name) {
		super();
		this.name = name;
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		Image background = null;
		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/" + name + ".png"));
		} catch (IOException e) {
			System.out.println("Error al cargar imagen de MontoTextField");
		}
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);

	}

}

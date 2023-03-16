package Componentes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ListaMonedasComboBox extends JComboBox<String> {

	
	public ListaMonedasComboBox() {
		super();
		setOpaque(false);
	}
	
	
	protected void paintComponent(Graphics g) {
		Image background = null;
		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/div1.png"));
		} catch (IOException e) {
		System.out.println("Error al cargar imágenes");
		}
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		
		
		
	}
	
}

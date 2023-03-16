package Componentes;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class MontoTextField extends JTextField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2574885836885776664L;


	public MontoTextField() {
		super();
		setOpaque(false);
	}
	
	
	protected void paintComponent(Graphics g) {
		Image background = null;
		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/mon2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		
		
		
	}
	
}

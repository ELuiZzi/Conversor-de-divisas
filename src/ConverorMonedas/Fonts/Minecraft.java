package ConverorMonedas.Fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Minecraft {

	public static Font getFont() {
		Font customFont = null;
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("recursos\\fonts/Minecraft.ttf"))
					.deriveFont(Font.PLAIN, 23);
		} catch (FontFormatException | IOException e1) {
			JOptionPane.showMessageDialog(null, "Error al cargar las fuentes de texto");
		}
		return customFont;
	}

}

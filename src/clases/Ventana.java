package clases;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.*;

import ConverorMonedas.Clases.ListaMonedas;
import ConverorMonedas.Componentes.ConversorMonedasPanel;
import ConversorMasas.Clases.ListaEquivalencias;
import ConversorMasas.Componentes.ConversorMasasPanel;

public class Ventana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1572483098288955376L;

	public Ventana() {
		this.mostrarMonedas();
		initComponents();
	}

	private void initComponents() {

		setTitle("Conversor");
		setSize(466, 675);
		setLayout(null);
		setLocationRelativeTo(null); // Centra la ventana en la pantalla
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Termina el programa al cerrar la ventana
		setResizable(true);
		setUndecorated(true);

		// Agrega los componentes que desees mostrar dentro de la ventana

		conversorMonedasPanel = new ConversorMonedasPanel();
		conversorMasasPanel = new ConversorMasasPanel();
		seleccionador = new JToggleButton();

		conversorMasasPanel.setBounds(0, 0, 466, 675);
		conversorMonedasPanel.setBounds(0, 0, 466, 675);
		seleccionador.setBounds(45, 5, 35, 30);
		seleccionador.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("Removiendo");

				if (seleccionador.isSelected()) {
					remove(conversorMonedasPanel);
					add(conversorMasasPanel);
				} else {
					remove(conversorMasasPanel);
					add(conversorMonedasPanel);
				}
				repaint();
			}
		});

		add(seleccionador);
		add(conversorMonedasPanel);

		setVisible(true); // Ventana sea visible

	}

	private void mostrarMonedas() {
		try {
			ListaMonedas.cargarMonedas();
			

		} catch (IOException e) {

		}
		ListaEquivalencias.cargarMasas();
	}

	JToggleButton seleccionador;
	JPanel conversorMonedasPanel;
	JPanel conversorMasasPanel;

}

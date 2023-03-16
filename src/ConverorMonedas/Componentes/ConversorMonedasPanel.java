package ConverorMonedas.Componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.swing.*;

import Componentes.*;
import ConverorMonedas.Clases.ConversorApi;
import ConverorMonedas.Clases.ListaMonedas;
import ConverorMonedas.Clases.Moneda;
import ConverorMonedas.Fonts.Minecraft;
import clases.Redondear;

public class ConversorMonedasPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3384152912848043583L;

	public ConversorMonedasPanel() {

		setLayout(null);
		addComponents();
		cargarListas();
	}

	protected void paintComponent(Graphics g) {

		Image background = null;
		try {
			background = ImageIO.read(new File("recursos\\imagenes\\background/fondo1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error al cargar las imágenes");
		}
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	}

	private void addComponents() {

		refresh = new Etiqueta("car1");
		cerrarBoton = new Etiqueta("cerr1");
		minimizarBoton = new Etiqueta("min1");
		cartel = new Etiqueta("tit1");
		montoTitulo = new Etiqueta("mon1");
		deTitulo = new Etiqueta("de1");
		paraTitulo = new Etiqueta("par1");
		desplegar1 = new Etiqueta("mas1");
		desplegar2 = new Etiqueta("mas1");
		invertirBoton = new Etiqueta("int1");
		convertirBoton = new Etiqueta("conv1");
		restuladoTitulo = new Etiqueta("res1");

		montoTextField = new MontoTextField();
		resultadoTextField = new MontoTextField();

		deComboBox = new ListaMonedasComboBox();
		paraComboBox = new ListaMonedasComboBox();

		// Cursor
		Cursor mano = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

		// Posiciones 466,675
		refresh.setBounds(5, 5, 30, 32);
		cerrarBoton.setBounds(431, 5, 25, 25);
		minimizarBoton.setBounds(401, 5, 25, 25);
		cartel.setBounds((466 - 280) / 2, 0, 280, 100);
		montoTitulo.setBounds((466 - 100) / 2, 120, 100, 22);
		montoTextField.setBounds((466 - 200) / 2, 150, 200, 55);
		deTitulo.setBounds(70, 234, 40, 20);
		deComboBox.setBounds(70, 257, 250, 60);
		paraTitulo.setBounds(70, 385, 60, 20);
		paraComboBox.setBounds(70, 407, 250, 60);
		desplegar1.setBounds(330, 257, 60, 60);
		desplegar2.setBounds(330, 407, 60, 60);
		invertirBoton.setBounds(280, 332, 110, 60);
		convertirBoton.setBounds((466 - 230) / 2, 492, 230, 70);
		restuladoTitulo.setBounds((466 - 100) / 2, 580, 100, 20);
		resultadoTextField.setBounds((466 - 200) / 2, 608, 200, 55);

		montoTextField.setForeground(Color.black);
		montoTextField.setBorder(null);
		montoTextField.setHorizontalAlignment(JTextField.CENTER);
		montoTextField.setFont(Minecraft.getFont());

		resultadoTextField.setForeground(Color.black);
		resultadoTextField.setBorder(null);
		resultadoTextField.setHorizontalAlignment(JTextField.CENTER);
		resultadoTextField.setFont(Minecraft.getFont());
		resultadoTextField.setEditable(false);

		// Configs

		deComboBox.setUI(new CustomComboBoxUI());
		paraComboBox.setUI(new CustomComboBoxUI());

		deComboBox.setFont(Minecraft.getFont());
		paraComboBox.setFont(Minecraft.getFont());

		// Cursor
		cerrarBoton.setCursor(mano);
		minimizarBoton.setCursor(mano);
		desplegar1.setCursor(mano);
		desplegar2.setCursor(mano);
		invertirBoton.setCursor(mano);
		convertirBoton.setCursor(mano);

		// Border
		convertirBoton.setBorder(null);

		// Listeners
		refresh.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				refresh.repaint();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				refresh.paintPressed(getGraphics(), "car3");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				refresh.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				refresh.paintEntered(getGraphics(), "car2");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				deComboBox.removeAllItems();
				paraComboBox.removeAllItems();
				mostrarMonedas();
				cargarListas();

			}
		});

		cerrarBoton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ConversorMonedasPanel.this);
				frame.dispose();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				cerrarBoton.paintEntered(getGraphics(), "cerr2");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				cerrarBoton.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				cerrarBoton.paintPressed(getGraphics(), "cerr3");

			}
		});

		minimizarBoton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				minimizarBoton.paintPressed(getGraphics(), "min3");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minimizarBoton.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				minimizarBoton.paintEntered(getGraphics(), "min2");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ConversorMonedasPanel.this);
				frame.setState(Frame.ICONIFIED);
			}
		});

		desplegar1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				desplegar1.repaint();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				desplegar1.paintPressed(getGraphics(), "mas3");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				desplegar1.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				desplegar1.paintEntered(getGraphics(), "mas2");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mostarListado(deComboBox);

			}
		});

		desplegar2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				desplegar2.repaint();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				desplegar2.paintPressed(getGraphics(), "mas3");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				desplegar2.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				desplegar2.paintEntered(getGraphics(), "mas2");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				mostarListado(paraComboBox);

			}
		});

		invertirBoton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				invertirBoton.repaint();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				invertirBoton.paintPressed(getGraphics(), "int3");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				invertirBoton.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				invertirBoton.paintEntered(getGraphics(), "int2");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				invertirItems(paraComboBox, deComboBox);

			}
		});

		convertirBoton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				convertirBoton.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				convertirBoton.paintPressed(getGraphics(), "conv3");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				convertirBoton.repaint();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				convertirBoton.paintEntered(getGraphics(), "conv2");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				convertir();

			}
		});

		add(refresh);
		add(cerrarBoton);
		add(minimizarBoton);
		add(cartel);
		add(montoTitulo);
		add(montoTextField);
		add(deTitulo);
		add(paraTitulo);
		add(deComboBox);
		add(paraComboBox);
		add(desplegar1);
		add(desplegar2);
		add(invertirBoton);
		add(convertirBoton);
		add(restuladoTitulo);
		add(resultadoTextField);
	}

	private void cargarListas() {

		for (String lista : Moneda.getTipoCambio()) {
			deComboBox.addItem(lista);
			paraComboBox.addItem(lista);
		}

	}

	private void mostarListado(JComboBox<String> box) {
		box.showPopup();
	}

	private void invertirItems(JComboBox<String> lista1, JComboBox<String> lista2) {
		// Seleccionar los items que están cargados
		String item1 = (String) lista1.getSelectedItem();
		String item2 = (String) lista2.getSelectedItem();

		// Colocar el item inversamente
		lista1.setSelectedItem(item2);
		lista2.setSelectedItem(item1);
	}

	private void convertir() {
		String from = (String) deComboBox.getSelectedItem();
		String to = (String) paraComboBox.getSelectedItem();
		double amount;
		try {
			amount = Double.parseDouble(montoTextField.getText());
			double conversion = ConversorApi.converor(from, to, amount);
			String resultado = Double.toString(Redondear.reducirDecimales(conversion));
			resultadoTextField.setText(resultado);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El valor del monto tiene que ser númerico");
		}
	}

	private void mostrarMonedas() {
		try {
			ListaMonedas.cargarMonedas();

		} catch (IOException e) {
			System.out.println("Error al cargar");
		}
	}

	Etiqueta refresh;
	Etiqueta cerrarBoton; // Boton rojo, para cerrar
	Etiqueta minimizarBoton;
	JPanel cartel;
	JPanel montoTitulo;
	JPanel deTitulo, paraTitulo;
	Etiqueta desplegar1, desplegar2;
	Etiqueta invertirBoton;
	Etiqueta convertirBoton;
	JPanel restuladoTitulo;
	JTextField montoTextField, resultadoTextField;
	JComboBox<String> deComboBox, paraComboBox;
}

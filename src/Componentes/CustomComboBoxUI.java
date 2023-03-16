package Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;


public class CustomComboBoxUI extends BasicComboBoxUI {

	@Override
	protected JButton createArrowButton() {
		// Override this method to return an empty button
		return null;
	}

	 public void paintCurrentValue(Graphics g,Rectangle bounds,boolean hasFocus) {
	        ListCellRenderer<Object> renderer = comboBox.getRenderer();
	        Component c;

	        if ( hasFocus && !isPopupVisible(comboBox) ) {
	            c = renderer.getListCellRendererComponent( listBox,
	                                                       comboBox.getSelectedItem(),
	                                                       -1,
	                                                       true,
	                                                       false );
	        }
	        else {
	            c = renderer.getListCellRendererComponent( listBox,
	                                                       comboBox.getSelectedItem(),
	                                                       -1,
	                                                       false,
	                                                       false );
	            c.setBackground(new Color(0, 0, 0, 0));
	        }
	        c.setFont(comboBox.getFont());
	        if ( hasFocus && !isPopupVisible(comboBox) ) {
	            c.setForeground(listBox.getSelectionForeground());
	            c.setBackground(new Color(0, 0, 0, 0));
	        }
	        else {
	            if ( comboBox.isEnabled() ) {
	                c.setForeground(comboBox.getForeground());
	                c.setBackground(new Color(0, 0, 0, 0));
	            }
	            else {
	                c.setForeground(new Color(0, 0, 0, 0));
	                c.setBackground(new Color(0, 0, 0, 0));
	            }
	        }

	        // Fix for 4238829: should lay out the JPanel.
	        boolean shouldValidate = false;
	        if (c instanceof JPanel)  {
	            shouldValidate = true;
	        }

	        int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
	        if (padding != null) {
	            x = bounds.x + padding.left;
	            y = bounds.y + padding.top;
	            w = bounds.width - (padding.left + padding.right);
	            h = bounds.height - (padding.top + padding.bottom);
	        }

	        currentValuePane.paintComponent(g,c,comboBox,15,0,w,h,shouldValidate);
	    }
	
	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		Color t = g.getColor();
		if (comboBox.isEnabled())
			g.setColor(new Color(0, 0, 0, 0));
		else
			g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		g.setColor(t);
	}

}

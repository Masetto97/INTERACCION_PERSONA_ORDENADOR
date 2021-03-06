package PresentacionV1;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class ListaTrabajdoresInvolucradosRender extends DefaultListCellRenderer {
	public ListaTrabajdoresInvolucradosRender() {
	}

	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean hasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected,
				hasFocus);
		renderer.setIcon(new ImageIcon(ListaTrabajadoresDisponiblesRender.class.getResource("/Galeria/people.png")));
		renderer.setBorder(new LineBorder(SystemColor.activeCaption));
		renderer.setHorizontalAlignment(JLabel.LEFT);
		renderer.setBackground(Color.WHITE);
		renderer.setForeground(Color.BLACK);
		if (isSelected)
			renderer.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		return renderer;
	}
}

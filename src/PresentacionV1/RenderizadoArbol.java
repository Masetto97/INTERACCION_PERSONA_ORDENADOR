package PresentacionV1;

import java.awt.Component;
import javax.swing.*;
import javax.swing.tree.*;


class RenderizadoArbol extends DefaultTreeCellRenderer {

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
		String c = (String) (nodo.getUserObject());
		switch (c) {
		case "Actividades":
			setIcon(new ImageIcon(RenderizadoArbol.class.getResource("/Galeria/list.png")));
			break;
		case "Activities":
			setIcon(new ImageIcon(RenderizadoArbol.class.getResource("/Galeria/list.png")));
			break;
		case "Trabajadores":
			setIcon(new ImageIcon(RenderizadoArbol.class.getResource("/Galeria/worker.png")));
			break;
		case "Workers":
			setIcon(new ImageIcon(RenderizadoArbol.class.getResource("/Galeria/worker.png")));
			break;
		default:
			setIcon(new ImageIcon(RenderizadoArbol.class.getResource("/Galeria/arrow.png")));
			break;
		}
		return this;
	}
}
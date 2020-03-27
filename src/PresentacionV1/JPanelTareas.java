package PresentacionV1;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import DominioV1.*;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class JPanelTareas extends JPanel {
	private JLabel lnlDefinicion;
	private JLabel lblPrioridad;
	private JLabel lblEstado;
	private JRadioButton rdbtnTerminado;
	private JRadioButton rdbtnEjecucin;
	private JRadioButton rdbtnSinTerminar;
	private JRadioButton rdbtnAlta;
	private JRadioButton rdbtnMedia;
	private JRadioButton rdbtnBaja;
	private JTextField txtDefinicion;
	private JButton btnAadirTrabajador;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private Tarea tarea;
	private JButton btnCrearNuevaTarea;
	private JButton btnEliminarTareaActual;
	private JButton btnActualizarTarea;
	private JPanel pnlDatosTarea;
	private JPanel pnlTrabajadoresDisponibles;
	private JPanel pnlTrabajadoresOcupados;
	private JList<String> lstTrabajadoresImplicados;
	private ArrayList<Tarea> tareas = new ArrayList<Tarea>();
	private ArrayList<String> trabajadoresDisponibles = new ArrayList<String>();
	private ArrayList<String> usuariosTarea = new ArrayList<String>();
	private DefaultListModel<String> modelUsuariosDisponibles = new DefaultListModel<String>();
	private DefaultListModel<String> modelUsuariosImplicados = new DefaultListModel<String>();
	private JFrameTareas frame;
	private int index = 0;
	private String nombreTrabajador;
	private JLabel lblDescripcion;
	private JTextField txtDescripcion;
	private LecturaEscritura lect = new LecturaEscritura();
	private JList<String> lstTrabajadoresDisponibles;
	private int IndiceTarea;
	private JButton btnEliminarTrabajdor;
	private JPanel pnlContenido;
	private JPanel pnlTodaTarea;
	private JPanel pnlRdbtn;
	private JPanel pnlWorkers;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public JPanelTareas() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new TitledBorder(null, JPanelTareasInt.getString("JPanelTareas.this.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 91, 370, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 60, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		pnlDatosTarea = new JPanel();
		pnlDatosTarea.setBackground(Color.WHITE);
		pnlDatosTarea
				.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), JPanelTareasInt.getString("JPanelTareas.pnlDatosTarea.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$
		pnlDatosTarea.setLayout(null);
		GridBagConstraints gbc_pnlDatosTarea = new GridBagConstraints();
		gbc_pnlDatosTarea.gridheight = 2;
		gbc_pnlDatosTarea.gridwidth = 2;
		gbc_pnlDatosTarea.fill = GridBagConstraints.BOTH;
		gbc_pnlDatosTarea.gridx = 0;
		gbc_pnlDatosTarea.gridy = 0;
		add(pnlDatosTarea, gbc_pnlDatosTarea);

		lblDescripcion = new JLabel(JPanelTareasInt.getString("JPanelTareas.lblDescripcion.text")); //$NON-NLS-1$
		lblDescripcion.setBounds(35, 49, 117, 14);
		pnlDatosTarea.add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(152, 46, 695, 20);
		txtDescripcion.addKeyListener(new TxtDescripcionKeyListener());
		pnlDatosTarea.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		txtDescripcion.addFocusListener(new MiFocusListener());

		lnlDefinicion = new JLabel(JPanelTareasInt.getString("JPanelTareas.lnlDefinicion.text")); //$NON-NLS-1$
		lnlDefinicion.setBounds(39, 104, 113, 14);
		pnlDatosTarea.add(lnlDefinicion);

		txtDefinicion = new JTextField();
		txtDefinicion.setBounds(152, 101, 695, 20);
		txtDefinicion.addKeyListener(new TxtDefinicionKeyListener());
		pnlDatosTarea.add(txtDefinicion);
		txtDefinicion.setColumns(10);
		txtDefinicion.addFocusListener(new MiFocusListener());

		pnlTrabajadoresDisponibles = new JPanel();
		pnlTrabajadoresDisponibles.setBounds(35, 272, 199, 169);
		pnlTrabajadoresDisponibles.setBackground(Color.WHITE);
		pnlTrabajadoresDisponibles.setBorder(
				new TitledBorder(null, JPanelTareasInt.getString("JPanelTareas.pnlTrabajadoresDisponibles.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		pnlDatosTarea.add(pnlTrabajadoresDisponibles);
		GridBagLayout gbl_pnlTrabajadoresDisponibles = new GridBagLayout();
		gbl_pnlTrabajadoresDisponibles.columnWidths = new int[] { 0, 0 };
		gbl_pnlTrabajadoresDisponibles.rowHeights = new int[] { 0, 0 };
		gbl_pnlTrabajadoresDisponibles.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTrabajadoresDisponibles.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlTrabajadoresDisponibles.setLayout(gbl_pnlTrabajadoresDisponibles);

		lstTrabajadoresDisponibles = new JList<String>();
		lstTrabajadoresDisponibles.setToolTipText(JPanelTareasInt.getString("JPanelTareas.lstTrabajadoresDisponibles.toolTipText")); //$NON-NLS-1$
		lstTrabajadoresDisponibles.addMouseListener(new LstTrabajadoresDisponiblesMouseListener());
		GridBagConstraints gbc_lstTrabajadoresDisponibles = new GridBagConstraints();
		gbc_lstTrabajadoresDisponibles.fill = GridBagConstraints.BOTH;
		gbc_lstTrabajadoresDisponibles.gridx = 0;
		gbc_lstTrabajadoresDisponibles.gridy = 0;
		pnlTrabajadoresDisponibles.add(lstTrabajadoresDisponibles, gbc_lstTrabajadoresDisponibles);

		btnAadirTrabajador = new JButton(JPanelTareasInt.getString("JPanelTareas.btnAadirTrabajador.text")); //$NON-NLS-1$
		btnAadirTrabajador.setToolTipText(JPanelTareasInt.getString("JPanelTareas.btnAadirTrabajador.toolTipText")); //$NON-NLS-1$
		btnAadirTrabajador.setBounds(236, 320, 199, 41);
		btnAadirTrabajador.setIcon(new ImageIcon(JPanelTareas.class.getResource("/Galeria/people2.png")));
		btnAadirTrabajador.addActionListener(new BtnAadirTrabajadorActionListener());
		pnlDatosTarea.add(btnAadirTrabajador);

		btnEliminarTareaActual = new JButton(JPanelTareasInt.getString("JPanelTareas.btnEliminarTareaActual.text")); //$NON-NLS-1$
		btnEliminarTareaActual.setToolTipText(JPanelTareasInt.getString("JPanelTareas.btnEliminarTareaActual.toolTipText")); //$NON-NLS-1$
		btnEliminarTareaActual.setBounds(298, 469, 221, 46);
		btnEliminarTareaActual.setIcon(new ImageIcon(JPanelTareas.class.getResource("/Galeria/002-notebook-2.png")));
		btnEliminarTareaActual.addActionListener(new BtnEliminarTareaActualActionListener());
		pnlDatosTarea.add(btnEliminarTareaActual);

		btnCrearNuevaTarea = new JButton(JPanelTareasInt.getString("JPanelTareas.btnCrearNuevaTarea.text")); //$NON-NLS-1$
		btnCrearNuevaTarea.setToolTipText(JPanelTareasInt.getString("JPanelTareas.btnCrearNuevaTarea.toolTipText")); //$NON-NLS-1$
		btnCrearNuevaTarea.setBounds(656, 469, 212, 46);
		btnCrearNuevaTarea.setIcon(new ImageIcon(JPanelTareas.class.getResource("/Galeria/003-notebook.png")));
		pnlDatosTarea.add(btnCrearNuevaTarea);
		btnCrearNuevaTarea.addActionListener(new BtnCrearNuevaTareaActionListener());
		btnAadirTrabajador.setEnabled(false);
		btnEliminarTareaActual.setEnabled(false);

		pnlTodaTarea = new JPanel();
		pnlTodaTarea.setBorder(null);
		pnlTodaTarea.setBackground(Color.WHITE);
		pnlTodaTarea.setBounds(10, 22, 871, 445);
		pnlDatosTarea.add(pnlTodaTarea);
		pnlTodaTarea.setLayout(null);

		pnlRdbtn = new JPanel();
		pnlRdbtn.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		pnlRdbtn.setBackground(Color.WHITE);
		pnlRdbtn.setBounds(10, 110, 849, 118);
		pnlTodaTarea.add(pnlRdbtn);
		GridBagLayout gbl_pnlRdbtn = new GridBagLayout();
		gbl_pnlRdbtn.columnWidths = new int[] { 109, 139, 140, 131, 0 };
		gbl_pnlRdbtn.rowHeights = new int[] { 62, 10, 65, 0 };
		gbl_pnlRdbtn.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_pnlRdbtn.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		pnlRdbtn.setLayout(gbl_pnlRdbtn);

		lblPrioridad = new JLabel(JPanelTareasInt.getString("JPanelTareas.lblPrioridad.text")); //$NON-NLS-1$
		lblPrioridad.setBorder(null);
		GridBagConstraints gbc_lblPrioridad = new GridBagConstraints();
		gbc_lblPrioridad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrioridad.gridx = 0;
		gbc_lblPrioridad.gridy = 0;
		pnlRdbtn.add(lblPrioridad, gbc_lblPrioridad);

		rdbtnAlta = new JRadioButton(JPanelTareasInt.getString("JPanelTareas.rdbtnAlta.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnAlta = new GridBagConstraints();
		gbc_rdbtnAlta.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAlta.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAlta.gridx = 1;
		gbc_rdbtnAlta.gridy = 0;
		pnlRdbtn.add(rdbtnAlta, gbc_rdbtnAlta);
		rdbtnAlta.setBackground(Color.WHITE);
		rdbtnAlta.addActionListener(new RdbtnAltaActionListener());

		rdbtnMedia = new JRadioButton(JPanelTareasInt.getString("JPanelTareas.rdbtnMedia.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnMedia = new GridBagConstraints();
		gbc_rdbtnMedia.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMedia.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMedia.gridx = 2;
		gbc_rdbtnMedia.gridy = 0;
		pnlRdbtn.add(rdbtnMedia, gbc_rdbtnMedia);
		rdbtnMedia.setBackground(Color.WHITE);
		rdbtnMedia.addActionListener(new RdbtnMediaActionListener());

		rdbtnBaja = new JRadioButton(JPanelTareasInt.getString("JPanelTareas.rdbtnBaja.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnBaja = new GridBagConstraints();
		gbc_rdbtnBaja.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBaja.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnBaja.gridx = 3;
		gbc_rdbtnBaja.gridy = 0;
		pnlRdbtn.add(rdbtnBaja, gbc_rdbtnBaja);
		rdbtnBaja.setBackground(Color.WHITE);
		rdbtnBaja.addActionListener(new RdbtnBajaActionListener());

		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(SystemColor.controlHighlight);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		pnlRdbtn.add(panel, gbc_panel);

		lblEstado = new JLabel(JPanelTareasInt.getString("JPanelTareas.lblEstado.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstado.gridx = 0;
		gbc_lblEstado.gridy = 2;
		pnlRdbtn.add(lblEstado, gbc_lblEstado);

		rdbtnTerminado = new JRadioButton(JPanelTareasInt.getString("JPanelTareas.rdbtnTerminado.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnTerminado = new GridBagConstraints();
		gbc_rdbtnTerminado.anchor = GridBagConstraints.WEST;
		gbc_rdbtnTerminado.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnTerminado.gridx = 1;
		gbc_rdbtnTerminado.gridy = 2;
		pnlRdbtn.add(rdbtnTerminado, gbc_rdbtnTerminado);
		rdbtnTerminado.setBackground(Color.WHITE);
		rdbtnTerminado.addActionListener(new RdbtnTerminadoActionListener());

		rdbtnEjecucin = new JRadioButton(JPanelTareasInt.getString("JPanelTareas.rdbtnEjecucin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnEjecucin = new GridBagConstraints();
		gbc_rdbtnEjecucin.anchor = GridBagConstraints.WEST;
		gbc_rdbtnEjecucin.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnEjecucin.gridx = 2;
		gbc_rdbtnEjecucin.gridy = 2;
		pnlRdbtn.add(rdbtnEjecucin, gbc_rdbtnEjecucin);
		rdbtnEjecucin.setBackground(Color.WHITE);
		rdbtnEjecucin.addActionListener(new RdbtnEjecucinActionListener());

		rdbtnSinTerminar = new JRadioButton(JPanelTareasInt.getString("JPanelTareas.rdbtnSinTerminar.text")); //$NON-NLS-1$
		GridBagConstraints gbc_rdbtnSinTerminar = new GridBagConstraints();
		gbc_rdbtnSinTerminar.anchor = GridBagConstraints.WEST;
		gbc_rdbtnSinTerminar.gridx = 3;
		gbc_rdbtnSinTerminar.gridy = 2;
		pnlRdbtn.add(rdbtnSinTerminar, gbc_rdbtnSinTerminar);
		rdbtnSinTerminar.setBackground(Color.WHITE);
		rdbtnSinTerminar.addActionListener(new RdbtnSinTerminarActionListener());

		pnlContenido = new JPanel();
		pnlContenido.setBounds(10, 11, 849, 100);
		pnlTodaTarea.add(pnlContenido);
		pnlContenido.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-1$
		pnlContenido.setBackground(Color.WHITE);
		GridBagLayout gbl_pnlContenido = new GridBagLayout();
		gbl_pnlContenido.columnWidths = new int[] { 0 };
		gbl_pnlContenido.rowHeights = new int[] { 0 };
		gbl_pnlContenido.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_pnlContenido.rowWeights = new double[] { Double.MIN_VALUE };
		pnlContenido.setLayout(gbl_pnlContenido);

		pnlWorkers = new JPanel();
		pnlWorkers.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		pnlWorkers.setBackground(Color.WHITE);
		pnlWorkers.setBounds(10, 227, 849, 207);
		pnlTodaTarea.add(pnlWorkers);
		pnlWorkers.setLayout(null);

		btnActualizarTarea = new JButton(JPanelTareasInt.getString("JPanelTareas.btnActualizarTarea.text")); //$NON-NLS-1$
		btnActualizarTarea.setToolTipText(JPanelTareasInt.getString("JPanelTareas.btnActualizarTarea.toolTipText")); //$NON-NLS-1$
		btnActualizarTarea.setBounds(630, 127, 209, 41);
		pnlWorkers.add(btnActualizarTarea);
		btnActualizarTarea.setIcon(new ImageIcon(JPanelTareas.class.getResource("/Galeria/001-notebook-1.png")));
		btnActualizarTarea.addActionListener(new BtnActualizarTareaActionListener());
		btnActualizarTarea.setEnabled(false);

		btnEliminarTrabajdor = new JButton(JPanelTareasInt.getString("JPanelTareas.btnEliminarTrabajdor.text")); //$NON-NLS-1$
		btnEliminarTrabajdor.setToolTipText(JPanelTareasInt.getString("JPanelTareas.btnEliminarTrabajdor.toolTipText")); //$NON-NLS-1$
		btnEliminarTrabajdor.setBounds(630, 68, 209, 41);
		pnlWorkers.add(btnEliminarTrabajdor);
		btnEliminarTrabajdor.setIcon(new ImageIcon(JPanelTareas.class.getResource("/Galeria/remove-user.png")));
		btnEliminarTrabajdor.addActionListener(new BtnEliminarTrabajdorActionListener());
		btnEliminarTrabajdor.setEnabled(false);

		pnlTrabajadoresOcupados = new JPanel();
		pnlTrabajadoresOcupados.setBounds(425, 25, 203, 171);
		pnlWorkers.add(pnlTrabajadoresOcupados);
		pnlTrabajadoresOcupados.setBackground(Color.WHITE);
		pnlTrabajadoresOcupados.setBorder(
				new TitledBorder(null, JPanelTareasInt.getString("JPanelTareas.pnlTrabajadoresOcupados.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		GridBagLayout gbl_pnlTrabajadoresOcupados = new GridBagLayout();
		gbl_pnlTrabajadoresOcupados.columnWidths = new int[] { 0, 0 };
		gbl_pnlTrabajadoresOcupados.rowHeights = new int[] { 0, 0 };
		gbl_pnlTrabajadoresOcupados.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTrabajadoresOcupados.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		pnlTrabajadoresOcupados.setLayout(gbl_pnlTrabajadoresOcupados);

		lstTrabajadoresImplicados = new JList<String>();
		lstTrabajadoresImplicados.setToolTipText(JPanelTareasInt.getString("JPanelTareas.lstTrabajadoresImplicados.toolTipText")); //$NON-NLS-1$
		lstTrabajadoresImplicados.addMouseListener(new LstTrabajadoresImplicadosMouseListener());
		GridBagConstraints gbc_lstTrabajadoresImplicados = new GridBagConstraints();
		gbc_lstTrabajadoresImplicados.fill = GridBagConstraints.BOTH;
		gbc_lstTrabajadoresImplicados.gridx = 0;
		gbc_lstTrabajadoresImplicados.gridy = 0;
		pnlTrabajadoresOcupados.add(lstTrabajadoresImplicados, gbc_lstTrabajadoresImplicados);
		txtDefinicion.setEnabled(false);
		txtDescripcion.setEnabled(false);
		this.setFocusTraversalPolicy(new FocusTraversalPolicy() {
			@Override
			public Component getLastComponent(Container aContainer) {
				return null;
			}

			@Override
			public Component getFirstComponent(Container aContainer) {
				return null;
			}

			@Override
			public Component getComponentAfter(Container arg0, Component arg1) {
				return null;
			}

			@Override
			public Component getComponentBefore(Container arg0, Component arg1) {
				return null;
			}

			@Override
			public Component getDefaultComponent(Container arg0) {
				return null;
			}

		});
	}

	private class MiFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 250));
		}
	}

	public void trabajadoresDisponibles() {
		for (int j = 0; j < usuarios.size(); j++) {
			if (j != 0) {
				if (!usuariosTarea.contains(usuarios.get(j).getNombre())) {
					trabajadoresDisponibles.add(usuarios.get(j).getNombre());

				}
			}
		}
	}

	public void rellenarListaTrabajadoresDisponibles() {
		modelUsuariosDisponibles.clear();
		trabajadoresDisponibles.clear();
		trabajadoresDisponibles();
		for (int i = 0; i < trabajadoresDisponibles.size(); i++) {
			if (!trabajadoresDisponibles.get(i).equals("NuNuNu")) {
				modelUsuariosDisponibles.addElement(trabajadoresDisponibles.get(i));
			}
		}
		lstTrabajadoresDisponibles.setModel(modelUsuariosDisponibles);
		lstTrabajadoresDisponibles.setCellRenderer(new ListaTrabajadoresDisponiblesRender());
	}

	public void rellenarListaTrabajadoresTarea() {
		modelUsuariosImplicados.clear();
		for (int i = 0; i < usuariosTarea.size(); i++) {
			modelUsuariosImplicados.addElement(usuariosTarea.get(i));
		}
		lstTrabajadoresImplicados.setModel(modelUsuariosImplicados);
		lstTrabajadoresImplicados.setCellRenderer(new ListaTrabajdoresInvolucradosRender());
	}

	private class BtnCrearNuevaTareaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			usuariosTarea.clear();
			usuariosTarea.add(usuario.getNombre());
			tarea = new Tarea("des", "1", "2", usuariosTarea, "def");
			txtDescripcion.setEnabled(true);
			rellenarListaTrabajadoresDisponibles();
			rellenarListaTrabajadoresTarea();
			tareas.add(tarea);
			btnActualizarTarea.setEnabled(false);
			txtDescripcion.setText("");
			txtDefinicion.setText("");
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(false);
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(false);
			btnCrearNuevaTarea.setEnabled(false);
			btnEliminarTareaActual.setEnabled(false);
			if(lblDescripcion.getText().equals("Description*:")) {
				btnActualizarTarea.setText("Save Task");
			}else {
				btnActualizarTarea.setText("Guardar Tarea");
			}
			
			txtDefinicion.setEnabled(false);
			txtDescripcion.requestFocus();
			rdbtnAlta.setEnabled(false);
			rdbtnBaja.setEnabled(false);
			rdbtnMedia.setEnabled(false);
			rdbtnEjecucin.setEnabled(false);
			rdbtnTerminado.setEnabled(false);
			rdbtnSinTerminar.setEnabled(false);
			lstTrabajadoresDisponibles.setEnabled(false);
			lstTrabajadoresImplicados.setEnabled(false);
			rellenarListaTrabajadoresDisponibles();
			rellenarListaTrabajadoresTarea();
		}
	}

	private class BtnEliminarTareaActualActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			tareas.remove(IndiceTarea);
			lect.EscrituraTarea(tareas);
			tareas = lect.lecturaTareas();
			frame.Datos(frame.getUltimaConex(), numeroTareasPrioridad(), frame.getNumeroMensajes());
			frame.RellenarArbol(tareas);
			txtDefinicion.setText("");
			txtDescripcion.setText("");
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(false);
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(false);
			btnEliminarTareaActual.setEnabled(false);
		}
	}

	private class BtnActualizarTareaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lstTrabajadoresDisponibles.setEnabled(true);
			lstTrabajadoresImplicados.setEnabled(true);
			tarea.setDescripion(txtDescripcion.getText());
			tarea.setDefinicion(txtDefinicion.getText());
			if (rdbtnAlta.isSelected()) {
				tarea.setPrioridad("1");
			} else if (rdbtnMedia.isSelected()) {
				tarea.setPrioridad("2");
			} else if (rdbtnBaja.isSelected()) {
				tarea.setPrioridad("3");
			}
			if (rdbtnTerminado.isSelected()) {
				tarea.setEstado("1");
			} else if (rdbtnEjecucin.isSelected()) {
				tarea.setEstado("2");
			} else if (rdbtnSinTerminar.isSelected()) {
				tarea.setEstado("3");
			}
			lect.EscrituraTarea(tareas);
			tareas = lect.lecturaTareas();
			frame.Datos(frame.getUltimaConex(), numeroTareasPrioridad(), frame.getNumeroMensajes());
			frame.RellenarArbol(tareas);
			btnCrearNuevaTarea.setEnabled(true);
		}
	}

	public int numeroTareasPrioridad() {
		int numt = 0;
		for (int i = 0; i < tareas.size(); i++) {
			if (tareas.get(i).getPrioridad().equals("1") || (tareas.get(i).getEstado().equals("2"))) {
				numt++;
			}
		}
		return numt;
	}

	private class BtnAadirTrabajadorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnAadirTrabajador.setEnabled(false);
			usuariosTarea.add(nombreTrabajador);
			lect.BorrarContenidoFicheroTareaUsuario();
			lect.EscrituraTareaUsuario(usuariosTarea);
			tareas = lect.lecturaTareas();
			usuariosTarea = tareas.get(IndiceTarea).getParticipantes();
			rellenarListaTrabajadoresTarea();
			rellenarListaTrabajadoresDisponibles();
		}
	}

	private class RdbtnAltaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnAlta.setSelected(true);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(false);
			rdbtnSinTerminar.setEnabled(true);
			rdbtnEjecucin.setEnabled(true);
			rdbtnTerminado.setEnabled(true);
			rdbtnTerminado.requestFocus();
		}
	}

	private class RdbtnMediaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(true);
			rdbtnBaja.setSelected(false);
			rdbtnSinTerminar.setEnabled(true);
			rdbtnEjecucin.setEnabled(true);
			rdbtnTerminado.setEnabled(true);
			rdbtnTerminado.requestFocus();
		}
	}

	private class RdbtnBajaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(true);
			rdbtnSinTerminar.setEnabled(true);
			rdbtnEjecucin.setEnabled(true);
			rdbtnTerminado.setEnabled(true);
			rdbtnTerminado.requestFocus();
		}
	}

	private class RdbtnTerminadoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnTerminado.setSelected(true);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(false);
			btnActualizarTarea.setEnabled(true);
			lstTrabajadoresDisponibles.setEnabled(true);
		}
	}

	private class RdbtnEjecucinActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(true);
			rdbtnSinTerminar.setSelected(false);
			btnActualizarTarea.setEnabled(true);
			lstTrabajadoresDisponibles.setEnabled(true);
		}
	}

	private class RdbtnSinTerminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(true);
			btnActualizarTarea.setEnabled(true);
			lstTrabajadoresDisponibles.setEnabled(true);
		}
	}

	private class TxtDescripcionKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER && txtDescripcion.getText().length() != 0) {
				txtDefinicion.setEnabled(true);
				txtDefinicion.requestFocus();
			}
		}
	}

	private class TxtDefinicionKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER && txtDefinicion.getText().length() != 0) {
				rdbtnAlta.setEnabled(true);
				rdbtnBaja.setEnabled(true);
				rdbtnMedia.setEnabled(true);
				rdbtnAlta.requestFocus();
			}
		}
	}

	private class LstTrabajadoresDisponiblesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				btnAadirTrabajador.setEnabled(true);
				btnEliminarTrabajdor.setEnabled(false);
				index = lstTrabajadoresDisponibles.getSelectedIndex();
				nombreTrabajador = trabajadoresDisponibles.get(index);
			} catch (Exception e) {
				btnAadirTrabajador.setEnabled(false);
			}
		}
	}

	private class LstTrabajadoresImplicadosMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				btnAadirTrabajador.setEnabled(false);
				btnEliminarTrabajdor.setEnabled(true);
				index = lstTrabajadoresImplicados.getSelectedIndex();
				nombreTrabajador = usuariosTarea.get(index);
			} catch (Exception ex) {
				btnEliminarTrabajdor.setEnabled(false);
			}
		}
	}

	private class BtnEliminarTrabajdorActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnEliminarTrabajdor.setEnabled(false);
			usuariosTarea.remove(nombreTrabajador);
			lect.BorrarContenidoFicheroTareaUsuario();
			lect.EscrituraTareaUsuario(usuariosTarea);
			tareas = lect.lecturaTareas();
			usuariosTarea = tareas.get(IndiceTarea).getParticipantes();
			rellenarListaTrabajadoresTarea();
			rellenarListaTrabajadoresDisponibles();
		}
	}

	public void rellenar() {
		btnEliminarTareaActual.setEnabled(true);
		btnActualizarTarea.setEnabled(true);
		txtDefinicion.setText(tarea.getDefinicion());
		txtDescripcion.setText(tarea.getDescripion());
		btnEliminarTareaActual.setEnabled(true);
		btnCrearNuevaTarea.setEnabled(true);
		switch (tarea.getPrioridad()) {
		case "1":
			rdbtnAlta.setSelected(true);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(false);
			break;
		case "2":
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(true);
			rdbtnBaja.setSelected(false);
			break;
		case "3":
			rdbtnAlta.setSelected(false);
			rdbtnMedia.setSelected(false);
			rdbtnBaja.setSelected(true);
			break;
		}
		switch (tarea.getEstado()) {
		case "1":
			rdbtnTerminado.setSelected(true);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(false);
			break;
		case "2":
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(true);
			rdbtnSinTerminar.setSelected(false);
			break;
		case "3":
			rdbtnTerminado.setSelected(false);
			rdbtnEjecucin.setSelected(false);
			rdbtnSinTerminar.setSelected(true);
			break;

		}
	}

	public void setArrayListUsuarios(ArrayList<Usuario> users, JFrameTareas tareas) {
		usuarios = users;
		frame = tareas;
	}

	public void setUsuario(Usuario u) {
		usuario = u;
		tareas = u.getTareas();
	}
	public void setIdioma() {
		JPanelTareasInt.setIdioma("inglés");
	}

	public void setTarea(Tarea t, int indice) {
		IndiceTarea = indice;
		tarea = t;
		usuariosTarea = tarea.getParticipantes();
		txtDefinicion.setEnabled(true);
		txtDescripcion.setEnabled(true);
		rellenar();
		rellenarListaTrabajadoresDisponibles();
		rellenarListaTrabajadoresTarea();

	}

	public void setIdiomaEspanol() {
		JPanelTareasInt.setIdioma("es");
		
	}
}

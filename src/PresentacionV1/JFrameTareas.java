package PresentacionV1;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import DominioV1.LecturaEscritura;
import DominioV1.Mensaje;
import DominioV1.Tarea;
import DominioV1.Usuario;
import java.awt.Rectangle;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.awt.Component;
import java.awt.Container;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;

import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class JFrameTareas extends JFrame {

	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTree tree;
	private JPanel pnlTabbedInformacion;
	private JLabel lblInformacionInicio;
	private JTabbedPane tabbedPane;
	private JPanelTareas pnlGestorTareas;
	private JPanelDatosUsuario pnlGestorUsuario;
	private JPanelMensaje pnlGestorMensajes;
	private JPanelEnvioMensaje pnlEnvioMensajes;
	private int indiceTarea;
	private ArrayList<Usuario> users;
	private Usuario u;
	private int NumeroTareas;
	private int NumeroMensajes;
	private ArrayList<Tarea> tareasU = new ArrayList<Tarea>();
	private JLabel lblFondo;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntnCerrarSesion;
	private JMenuItem mntmSalir;
	private JMenu mnVer;
	private JMenu mnTamaoLetra;
	private JRadioButtonMenuItem rdbtnmntmLetraGrande;
	private JRadioButtonMenuItem rdbtnmntmLetraMediana;
	private JRadioButtonMenuItem rdbtnmntmLetraPequea;
	private JMenu mnAyuda;
	private JMenuItem mntmManulaDeUsuario;
	private String usuario = null;

	public JFrameTareas(Usuario user, String ust) {
		usuario = ust;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameTareas.class.getResource("/Galeria/logoEmpresa.png")));
		if (usuario.equals("User")) {
			setTitle("Task");
		} else {
			setTitle("Gestor Tareas");
		}
		setResizable(false);
		LecturaEscritura e = new LecturaEscritura();
		users = e.lecturaUsuario();
		for (int i = 0; i < users.size(); i++) {
			if (user.getNombre().equals(users.get(i).getNombre())) {
				u = users.get(i);
			}
		}
		getContentPane().setBounds(new Rectangle(0, 0, 850, 850));
		setBounds(new Rectangle(0, 0, 900, 900));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1153, 713);
		getContentPane().setLayout(null);

		JPanel panelCard = new JPanel();
		panelCard.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelCard.setBounds(new Rectangle(34, 29, 1101, 610));
		getContentPane().add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));

		splitPane = new JSplitPane();
		panelCard.add(splitPane, "name_163211111952370");

		scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(150, 150));
		scrollPane.setMinimumSize(new Dimension(150, 150));
		scrollPane.setBounds(new Rectangle(50, 50, 0, 0));
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		splitPane.setLeftComponent(scrollPane);

		tree = new JTree();
		tree.addTreeSelectionListener(new TreeTreeSelectionListener());
		scrollPane.setViewportView(tree);

		pnlTabbedInformacion = new JPanel();
		pnlTabbedInformacion.setBackground(Color.WHITE);
		splitPane.setRightComponent(pnlTabbedInformacion);
		GridBagLayout gbl_pnlTabbedInformacion = new GridBagLayout();
		gbl_pnlTabbedInformacion.columnWidths = new int[] { 888, 0 };
		gbl_pnlTabbedInformacion.rowHeights = new int[] { 535, 16, 0 };
		gbl_pnlTabbedInformacion.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnlTabbedInformacion.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		pnlTabbedInformacion.setLayout(gbl_pnlTabbedInformacion);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		pnlTabbedInformacion.add(tabbedPane, gbc_tabbedPane);

		pnlGestorTareas = new JPanelTareas();
		pnlGestorTareas.setArrayListUsuarios(users, this);
		pnlGestorTareas.setUsuario(u);
		if (usuario.equals("User")) {
			tabbedPane.addTab("Tasks", null, pnlGestorTareas, null);
		} else {
			tabbedPane.addTab("Gestor Tareas", null, pnlGestorTareas, null);
		}
		pnlGestorTareas.setLayout(new CardLayout(0, 0));

		pnlGestorUsuario = new JPanelDatosUsuario();
		pnlGestorUsuario.setUsuario(u);
		pnlGestorUsuario.setArrayListUsuario(users);
		pnlGestorUsuario.comprobar();
		if (usuario.equals("User")) {
			tabbedPane.addTab("User", null, pnlGestorUsuario, null);
		} else {
			tabbedPane.addTab("Gestor Usuario", null, pnlGestorUsuario, null);
		}
		pnlGestorUsuario.setLayout(new CardLayout(0, 0));

		pnlGestorMensajes = new JPanelMensaje();
		pnlGestorMensajes.setUsuario(u, users, this);
		if (usuario.equals("User")) {
			tabbedPane.addTab("Message", null, pnlGestorMensajes, null);
		} else {
			tabbedPane.addTab("Mensajes", null, pnlGestorMensajes, null);
		}
		pnlEnvioMensajes = new JPanelEnvioMensaje();
		pnlEnvioMensajes.setArrayUsuario(users);
		pnlEnvioMensajes.setUsuario(u);
		pnlEnvioMensajes.setJFrame(this, pnlGestorMensajes);
		pnlEnvioMensajes.rellenarLista();
		if (usuario.equals("User")) {
			tabbedPane.addTab("New Message", null, pnlEnvioMensajes, null);
		} else {
			tabbedPane.addTab("Nuevo Mensaje", null, pnlEnvioMensajes, null);
		}
		pnlEnvioMensajes.setLayout(new CardLayout(0, 0));

		lblInformacionInicio = new JLabel("");
		GridBagConstraints gbc_lblInformacionInicio = new GridBagConstraints();
		gbc_lblInformacionInicio.anchor = GridBagConstraints.NORTH;
		gbc_lblInformacionInicio.gridx = 0;
		gbc_lblInformacionInicio.gridy = 1;
		pnlTabbedInformacion.add(lblInformacionInicio, gbc_lblInformacionInicio);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(JFrameTareas.class.getResource("/Galeria/fondoAplicacion.png")));
		lblFondo.setBounds(0, 0, 1222, 658);
		getContentPane().add(lblFondo);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		if (usuario.equals("User")) {
			mnArchivo = new JMenu("Archive");
		}else {
			mnArchivo = new JMenu("Archivo");
		}
		
		menuBar.add(mnArchivo);
		if (usuario.equals("User")) {
			mntnCerrarSesion = new JMenuItem("Log Out");
		}else {
			mntnCerrarSesion = new JMenuItem("Cerrar Sesión");
		}
		
		mntnCerrarSesion.addActionListener(new MntnCerrarSesionActionListener());
		mnArchivo.add(mntnCerrarSesion);
		if (usuario.equals("User")) {
			mntmSalir = new JMenuItem("Exit");
		}else {
		mntmSalir = new JMenuItem("Salir");
		}
		mntmSalir.addActionListener(new MntmSalirActionListener());
		mnArchivo.add(mntmSalir);
		if (usuario.equals("User")) {
			mnVer = new JMenu("View");
		}else {
		mnVer = new JMenu("Ver");
		}
		menuBar.add(mnVer);
		if (usuario.equals("User")) {
			mnTamaoLetra = new JMenu("Letter Size");
		} else {
			mnTamaoLetra = new JMenu("Tamaño Letra");
		}
		mnVer.add(mnTamaoLetra);
		if (usuario.equals("User")) {
			rdbtnmntmLetraGrande = new JRadioButtonMenuItem("Large Letter");
		}else {
		rdbtnmntmLetraGrande = new JRadioButtonMenuItem("Letra Grande");
		}
		rdbtnmntmLetraGrande.addActionListener(new RdbtnmntmLetraGrandeActionListener());
		mnTamaoLetra.add(rdbtnmntmLetraGrande);
		if (usuario.equals("User")) {
			rdbtnmntmLetraMediana = new JRadioButtonMenuItem("Medium Letter");
		}else {
		rdbtnmntmLetraMediana = new JRadioButtonMenuItem("Letra Mediana");
		}
		rdbtnmntmLetraMediana.addActionListener(new RdbtnmntmLetraMedianaActionListener());
		mnTamaoLetra.add(rdbtnmntmLetraMediana);
		if (usuario.equals("User")) {
			rdbtnmntmLetraPequea = new JRadioButtonMenuItem("Small Letter");
		}else {
		rdbtnmntmLetraPequea = new JRadioButtonMenuItem("Letra Pequeña");
		}
		rdbtnmntmLetraPequea.addActionListener(new RdbtnmntmLetraPequeaActionListener());
		mnTamaoLetra.add(rdbtnmntmLetraPequea);
		if (usuario.equals("User")) {
			mnAyuda = new JMenu("Help");
		} else {
			mnAyuda = new JMenu("Ayuda");
		}
		menuBar.add(mnAyuda);

		mntmManulaDeUsuario = new JMenuItem("Manual ");
		mntmManulaDeUsuario.addActionListener(new MntmManulaDeUsuarioActionListener());
		mnAyuda.add(mntmManulaDeUsuario);
		Datos(u.getUltimaConexion(), tareasPrioridad(u), mensajesLeidos(u));
		tareasU = u.getTareas();
		RellenarArbol(tareasU);
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

	public int mensajesLeidos(Usuario user) {
		int mensajes = 0;
		if (user.getMensajes() != null) {
			ArrayList<Mensaje> m = user.getMensajes();
			for (int i = 0; i < m.size(); i++) {
				if (m.get(i).isLeido() == false) {
					mensajes++;
				}
			}
		}
		return mensajes;
	}

	public int tareasPrioridad(Usuario user) {
		int tareas = 0;
		if (user.getTareas() != null) {
			ArrayList<Tarea> t = user.getTareas();
			for (int i = 0; i < t.size(); i++) {
				if (t.get(i).getPrioridad().equals("2") || (!t.get(i).getEstado().equals("1"))) {
					tareas++;
				}
			}
		}

		return tareas;
	}

	public void EliminarTarea() {
		tareasU.remove(indiceTarea);
	}

	public void RellenarArbol(ArrayList<Tarea> tareas) {
		if (usuario.equals("User")) {
			tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Activities") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					for (int i = 0; i < tareas.size(); i++) {
						node_1 = new DefaultMutableTreeNode("Task " + (i + 1));
						node_1.add(new DefaultMutableTreeNode(tareas.get(i).getDescripion()));
						node_2 = new DefaultMutableTreeNode("Workers");
						ArrayList<String> p = tareas.get(i).getParticipantes();
						for (int j = 0; j < p.size(); j++) {
							node_3 = new DefaultMutableTreeNode(p.get(j));
							node_2.add(node_3);
						}
						node_1.add(node_2);
						// getContentPane().add(node_1);
						add(node_1);
					}
				}
			}));
			tree.setCellRenderer(new RenderizadoArbol());
		} else {
			tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Actividades") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					for (int i = 0; i < tareas.size(); i++) {
						node_1 = new DefaultMutableTreeNode("Tarea " + (i + 1));
						node_1.add(new DefaultMutableTreeNode(tareas.get(i).getDescripion()));
						node_2 = new DefaultMutableTreeNode("Trabajadores");
						ArrayList<String> p = tareas.get(i).getParticipantes();
						for (int j = 0; j < p.size(); j++) {
							node_3 = new DefaultMutableTreeNode(p.get(j));
							node_2.add(node_3);
						}
						node_1.add(node_2);
						// getContentPane().add(node_1);
						add(node_1);
					}
				}
			}));
			tree.setCellRenderer(new RenderizadoArbol());
		}
	}

	public void Datos(String u, int tareas, int mensajes) {
		NumeroTareas = tareas;
		NumeroMensajes = mensajes;
		if (usuario.equals("User")) {
			String text = "Last Connection: " + u + " Max priority task:" + tareas + " You have " + mensajes
					+ " unread messages";
			lblInformacionInicio.setText(text);
		} else {
			String text = "Ultima conexión: " + u + " Tareas en prioridad maxima:" + tareas + " Tiene " + mensajes
					+ " mensajes si leer";
			lblInformacionInicio.setText(text);
		}
	}

	public int getNumeroTareas() {
		return NumeroTareas;
	}

	public int getNumeroMensajes() {
		return NumeroMensajes;
	}

	public String getUltimaConex() {
		return u.getUltimaConexion();
	}

	private class TreeTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent arg0) {
			try {
				char letra = 0;
				String nodo = (arg0.getPath().getLastPathComponent()).toString();
				for (int i = 0; i < nodo.length(); i++) {
					letra = nodo.charAt(i);
				}
				tabbedPane.setSelectedIndex(0);
				indiceTarea = Character.getNumericValue(letra);
				pnlGestorTareas.setTarea(tareasU.get(indiceTarea - 1), (indiceTarea - 1));
			} catch (Exception e) {

			}
		}
	}

	private class MntnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			dispose();
			VentanaLogIn window = new VentanaLogIn();
			window.frmVentanaLogIn.setVisible(true);
			
		}
	}

	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

	private class RdbtnmntmLetraGrandeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setUIFont(new javax.swing.plaf.FontUIResource(new Font("Tahoma", Font.PLAIN, 16)));
			SwingUtilities.updateComponentTreeUI(splitPane);
			rdbtnmntmLetraMediana.setSelected(false);
			rdbtnmntmLetraPequea.setSelected(false);
		}
	}

	private class RdbtnmntmLetraMedianaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setUIFont(new javax.swing.plaf.FontUIResource(new Font("Tahoma", Font.PLAIN, 14)));
			SwingUtilities.updateComponentTreeUI(splitPane);
			rdbtnmntmLetraGrande.setSelected(false);
			rdbtnmntmLetraPequea.setSelected(false);
		}
	}

	private class RdbtnmntmLetraPequeaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setUIFont(new javax.swing.plaf.FontUIResource(new Font("Tahoma", Font.PLAIN, 12)));
			SwingUtilities.updateComponentTreeUI(splitPane);
			rdbtnmntmLetraGrande.setSelected(false);
			rdbtnmntmLetraMediana.setSelected(false);
		}
	}

	private class MntmManulaDeUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				File f = new File("Video.pdf");
				Runtime.getRuntime().exec("cmd /c start " + f.getAbsolutePath());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void setIdioma() {
		pnlEnvioMensajes.setIdioma();
		pnlGestorMensajes.setIdioma();
		pnlGestorTareas.setIdioma();
		pnlGestorUsuario.setIdioma();
		JFrameTareas t = new JFrameTareas(u, usuario);
		t.setVisible(true);
		dispose();
	}

	public void setIdiomaEspanol() {
		pnlEnvioMensajes.setIdiomaEspanol();
		pnlGestorMensajes.setIdiomaEspanol();
		pnlGestorTareas.setIdiomaEspanol();
		pnlGestorUsuario.setIdiomaEspanol(); //
		JFrameTareas t = new JFrameTareas(u, usuario);
		t.setVisible(true);
		dispose();
	}
	
	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value != null && value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

}
package PresentacionV1;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import DominioV1.LecturaEscritura;
import DominioV1.ListaMensajesRender;
import DominioV1.Mensaje;
import DominioV1.Usuario;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPanelMensaje extends JPanel {
	private JPanel pnlMensaje;
	private JPanel pnlDatos;
	private JList<String> lstMensajes;
	private ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	private JLabel lblMensaje;
	private JLabel lblEnviadoPor;
	private JLabel lblMarcarMensajeComo;
	private JRadioButton rdbtnLeido;
	private JRadioButton rdbtnNoLeido;
	private JButton btnAceptar;
	private JTextField txtMensaje;
	private JTextField txtEnviado;
	private LecturaEscritura m = new LecturaEscritura();
	private JLabel lblAsunto;
	private JTextField txtAsunto;
	private JButton btnBorrar;
	private Mensaje mensajeMod;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JFrameTareas tareas;
	private JPanel panel;
	private JLabel lblMensajeNumero;
	private Usuario user;

	/**
	 * Create the panel.
	 */
	public JPanelMensaje() {
		setBackground(Color.WHITE);

		setBorder(new TitledBorder(null, JPanelMensajeInt.getString("JPanelMensaje.this.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 299, 265, 0 };
		gridBagLayout.rowHeights = new int[] { 389, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		pnlMensaje = new JPanel();
		pnlMensaje.setBackground(Color.WHITE);
		pnlMensaje.setBorder(new TitledBorder(null, JPanelMensajeInt.getString("JPanelMensaje.pnlMensaje.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pnlMensaje = new GridBagConstraints();
		gbc_pnlMensaje.insets = new Insets(0, 0, 0, 5);
		gbc_pnlMensaje.fill = GridBagConstraints.BOTH;
		gbc_pnlMensaje.gridx = 0;
		gbc_pnlMensaje.gridy = 0;
		add(pnlMensaje, gbc_pnlMensaje);
		GridBagLayout gbl_pnlMensaje = new GridBagLayout();
		gbl_pnlMensaje.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlMensaje.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlMensaje.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlMensaje.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		pnlMensaje.setLayout(gbl_pnlMensaje);

		lstMensajes = new JList<String>();
		lstMensajes.setToolTipText(JPanelMensajeInt.getString("JPanelMensaje.lstMensajes.toolTipText")); //$NON-NLS-1$
		lstMensajes.addMouseListener(new LstMensajesMouseListener());
		GridBagConstraints gbc_lstMensajes = new GridBagConstraints();
		gbc_lstMensajes.gridwidth = 3;
		gbc_lstMensajes.gridheight = 2;
		gbc_lstMensajes.fill = GridBagConstraints.BOTH;
		gbc_lstMensajes.gridx = 0;
		gbc_lstMensajes.gridy = 0;
		pnlMensaje.add(lstMensajes, gbc_lstMensajes);

		pnlDatos = new JPanel();
		pnlDatos.setBackground(Color.WHITE);
		pnlDatos.setBorder(new TitledBorder(null, JPanelMensajeInt.getString("JPanelMensaje.pnlDatos.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDatos.setLayout(null);
		GridBagConstraints gbc_pnlDatos = new GridBagConstraints();
		gbc_pnlDatos.fill = GridBagConstraints.BOTH;
		gbc_pnlDatos.gridx = 1;
		gbc_pnlDatos.gridy = 0;
		add(pnlDatos, gbc_pnlDatos);

		lblMensaje = new JLabel(JPanelMensajeInt.getString("JPanelMensaje.lblMensaje.text")); //$NON-NLS-1$
		lblMensaje.setBounds(30, 187, 97, 16);
		pnlDatos.add(lblMensaje);

		txtMensaje = new JTextField();
		txtMensaje.setEnabled(false);
		txtMensaje.setBounds(139, 180, 451, 120);
		pnlDatos.add(txtMensaje);
		txtMensaje.setColumns(10);
		txtMensaje.addFocusListener(new MiFocusListener());

		lblEnviadoPor = new JLabel(JPanelMensajeInt.getString("JPanelMensaje.lblEnviadoPor.text")); //$NON-NLS-1$
		lblEnviadoPor.setBounds(30, 48, 97, 16);
		pnlDatos.add(lblEnviadoPor);

		txtEnviado = new JTextField();
		txtEnviado.setBounds(139, 45, 451, 22);
		pnlDatos.add(txtEnviado);
		txtEnviado.setColumns(10);
		txtEnviado.addFocusListener(new MiFocusListener());

		lblAsunto = new JLabel(JPanelMensajeInt.getString("JPanelMensaje.lblAsunto.text")); //$NON-NLS-1$
		lblAsunto.setBounds(30, 107, 97, 16);
		pnlDatos.add(lblAsunto);

		txtAsunto = new JTextField();
		txtAsunto.setBounds(139, 104, 451, 22);
		pnlDatos.add(txtAsunto);
		txtAsunto.setColumns(10);
		txtAsunto.addFocusListener(new MiFocusListener());

		panel = new JPanel();
		panel.setBounds(12, 323, 587, 45);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, //$NON-NLS-2$
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDatos.add(panel);
		panel.setLayout(null);

		lblMarcarMensajeComo = new JLabel(JPanelMensajeInt.getString("JPanelMensaje.lblMarcarMensajeComo.text")); //$NON-NLS-1$
		lblMarcarMensajeComo.setBounds(12, 13, 196, 16);
		panel.add(lblMarcarMensajeComo);

		rdbtnLeido = new JRadioButton(JPanelMensajeInt.getString("JPanelMensaje.rdbtnLeido.text")); //$NON-NLS-1$
		rdbtnLeido.setBounds(280, 9, 120, 25);
		panel.add(rdbtnLeido);
		rdbtnLeido.setBackground(Color.WHITE);

		rdbtnNoLeido = new JRadioButton(JPanelMensajeInt.getString("JPanelMensaje.rdbtnNoLeido.text")); //$NON-NLS-1$
		rdbtnNoLeido.setBounds(451, 9, 120, 25);
		panel.add(rdbtnNoLeido);
		rdbtnNoLeido.setBackground(Color.WHITE);
		rdbtnNoLeido.addActionListener(new RdbtnNoLeidoActionListener());
		rdbtnLeido.addActionListener(new RdbtnLeidoActionListener());

		btnAceptar = new JButton(JPanelMensajeInt.getString("JPanelMensaje.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.setBounds(395, 399, 195, 53);
		btnAceptar.setToolTipText(JPanelMensajeInt.getString("JPanelMensaje.btnAceptar.toolTipText")); //$NON-NLS-1$
		btnAceptar.setIcon(new ImageIcon(JPanelMensaje.class.getResource("/Galeria/refresh-button.png")));
		btnAceptar.addActionListener(new BtnAceptarActionListener());

		btnBorrar = new JButton(JPanelMensajeInt.getString("JPanelMensaje.btnBorrar.text")); //$NON-NLS-1$
		btnBorrar.setBounds(30, 398, 195, 54);
		btnBorrar.setToolTipText(JPanelMensajeInt.getString("JPanelMensaje.btnBorrar.toolTipText")); //$NON-NLS-1$
		btnBorrar.setIcon(new ImageIcon(JPanelMensaje.class.getResource("/Galeria/delete.png")));
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		pnlDatos.add(btnBorrar);
		pnlDatos.add(btnAceptar);
		btnBorrar.setEnabled(false);
		btnBorrar.setEnabled(false);
		btnAceptar.setEnabled(false);

		lblMensajeNumero = new JLabel(); // $NON-NLS-1$
		lblMensajeNumero.setBounds(259, 451, 332, 38);
		pnlDatos.add(lblMensajeNumero);
		txtAsunto.setEnabled(false);
		txtEnviado.setEnabled(false);
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

	public void rellenarLista() {
		model.removeAllElements();
		mensajes = m.lecturaMensajes();
		for (int i = 0; i < mensajes.size(); i++) {
			if (mensajes.get(i).isLeido() == false) {
				if (lblAsunto.getText().equals("Subject:")) {
					model.addElement("'Message Unread'  " + mensajes.get(i).getAsunto());
				} else {
					model.addElement("'Mensaje No Leido'  " + mensajes.get(i).getAsunto());
				}
			} else {
				model.addElement(mensajes.get(i).getAsunto());
			}
		}
		lstMensajes.setModel(model);
		lstMensajes.setSelectedIndex(0);
		lstMensajes.setCellRenderer(new ListaMensajesRender());
	}

	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			mensajeMod.setAsunto(txtAsunto.getText());
			mensajeMod.setTexto(txtMensaje.getText());
			mensajeMod.setEnviado(txtEnviado.getText());
			mensajeMod.setLeido(rdbtnLeido.isSelected());
			if (lblAsunto.getText().equals("Subject:")) {
				lblMensajeNumero.setText("Message number: " + (mensajes.indexOf(mensajeMod) + 1) + " modified ");
			} else {
				lblMensajeNumero
						.setText("Mensaje número: " + (mensajes.indexOf(mensajeMod) + 1) + " modificado correctamente");
			}
			lblMensajeNumero.setForeground(Color.GRAY);
			lecturaEscritura();
			tareas.Datos(tareas.getUltimaConex(), tareas.getNumeroTareas(), getNumeroMensajes());
			btnBorrar.setEnabled(false);
			btnAceptar.setEnabled(false);
			txtAsunto.setText("");
			txtMensaje.setText("");
			txtEnviado.setText("");
			rdbtnLeido.setSelected(false);
			rdbtnNoLeido.setSelected(false);
			lstMensajes.setSelectedIndex(0);
		}
	}

	public int getNumeroMensajes() {
		int cont = 0;
		for (int i = 0; i < mensajes.size(); i++) {
			if (!mensajes.get(i).isLeido()) {
				cont++;
			}
		}
		return cont;
	}

	private class RdbtnLeidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnLeido.setSelected(true);
			rdbtnNoLeido.setSelected(false);
		}
	}

	private class RdbtnNoLeidoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rdbtnLeido.setSelected(false);
			rdbtnNoLeido.setSelected(true);
		}
	}

	private class LstMensajesMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			try {
				btnBorrar.setEnabled(true);
				btnAceptar.setEnabled(true);
				int index = lstMensajes.getSelectedIndex();
				if (lblAsunto.getText().equals("Subject:")) {
					lblMensajeNumero.setText("Message number: " + (index + 1));
				} else {
					lblMensajeNumero.setText("Mensaje numero: " + (index + 1));
				}
				lblMensajeNumero.setForeground(Color.GRAY);
				mensajeMod = mensajes.get(index);
				mensajeMod = mensajes.get(index);
				txtAsunto.setText(mensajeMod.getAsunto());
				txtMensaje.setText(mensajeMod.getTexto());
				txtEnviado.setText(mensajeMod.getEnviado());
				if (mensajeMod.isLeido() == true) {
					rdbtnLeido.setSelected(true);
					rdbtnNoLeido.setSelected(false);
				} else {
					rdbtnNoLeido.setSelected(true);
					rdbtnLeido.setSelected(false);
				}

			} catch (Exception e) {
				btnAceptar.setEnabled(false);
				btnBorrar.setEnabled(false);
			}
		}
	}

	public void lecturaEscritura() {
		m.BorrarContenidoFicheroMensaje();
		m.EscrituraMensajes(mensajes);
		rellenarLista();
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			txtAsunto.setText("");
			txtEnviado.setText("");
			txtMensaje.setText("");
			rdbtnLeido.setSelected(false);
			rdbtnNoLeido.setSelected(false);
			mensajes.remove(mensajeMod);
			lecturaEscritura();
			tareas.Datos(tareas.getUltimaConex(), tareas.getNumeroTareas(), getNumeroMensajes());
			btnBorrar.setEnabled(false);
			btnAceptar.setEnabled(false);
		}
	}

	public int mensajesSinLeer() {
		int msg = 0;
		for (int i = 0; i < mensajes.size(); i++) {
			if (mensajes.get(i).isLeido() == true) {
				msg++;
			}
		}
		return msg;
	}

	public void setUsuario(Usuario u, ArrayList<Usuario> us, JFrameTareas jFrameTareas) {
		mensajes = m.lecturaMensajes();
		tareas = jFrameTareas;
		user = u;
		rellenarLista();
	}

	public void setIdioma() {
		JPanelMensajeInt.setIdioma("inglés");
	}

	public void setIdiomaEspanol() {
		JPanelMensajeInt.setIdioma("es");
		
	}

}

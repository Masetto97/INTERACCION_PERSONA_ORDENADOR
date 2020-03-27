package PresentacionV1;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;

import DominioV1.LecturaEscritura;
import DominioV1.Mensaje;
import DominioV1.Usuario;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class JPanelEnvioMensaje extends JPanel {
	private JLabel lblAsunto;
	private JLabel lblDestinatario;
	private JLabel lblContendo;
	private JTextField txtDestinatario;
	private JTextField txtMensaje;
	private JPanel lblUsuarios;
	private JPanel panel;
	private JList<String> lstUsuarios;
	private JButton btnEnviarMensaje;
	private JButton btnCancelar;
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JFrameTareas tarea;
	private ArrayList<Mensaje> mensajes;
	private JPanelMensaje men;
	private JLabel lblText;
	private JTextField txtAsunto;

	/**
	 * Create the panel.
	 */
	public JPanelEnvioMensaje() {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.this.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		lblUsuarios = new JPanel();
		lblUsuarios.setBounds(22, 19, 885, 547);
		lblUsuarios.setBackground(Color.WHITE);
		lblUsuarios.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.lblUsuarios.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblUsuarios.setLayout(null);
		add(lblUsuarios);

		panel = new JPanel();
		panel.setBounds(6, 18, 182, 503);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.panel.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblUsuarios.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lstUsuarios = new JList<String>();
		lstUsuarios.setToolTipText(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.lstUsuarios.toolTipText")); //$NON-NLS-1$
		lstUsuarios.addMouseListener(new LstUsuariosMouseListener());
		GridBagConstraints gbc_lstUsuarios = new GridBagConstraints();
		gbc_lstUsuarios.gridwidth = 4;
		gbc_lstUsuarios.gridheight = 6;
		gbc_lstUsuarios.fill = GridBagConstraints.BOTH;
		gbc_lstUsuarios.gridx = 0;
		gbc_lstUsuarios.gridy = 0;
		panel.add(lstUsuarios, gbc_lstUsuarios);

		lblDestinatario = new JLabel(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.lblDestinatario.text")); //$NON-NLS-1$
		lblDestinatario.setBounds(200, 51, 111, 16);
		lblUsuarios.add(lblDestinatario);

		txtDestinatario = new JTextField();
		txtDestinatario.setBounds(308, 48, 565, 22);
		lblUsuarios.add(txtDestinatario);
		txtDestinatario.setColumns(10);
		txtDestinatario.addFocusListener(new MiFocusListener());

		txtMensaje = new JTextField();
		txtMensaje.setBounds(308, 131, 565, 22);
		txtMensaje.addKeyListener(new TxtMensajeKeyListener());

		lblContendo = new JLabel(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.lblContendo.text")); //$NON-NLS-1$
		lblContendo.setBounds(230, 134, 81, 16);
		lblUsuarios.add(lblContendo);
		lblUsuarios.add(txtMensaje);
		txtMensaje.setColumns(10);
		txtMensaje.addFocusListener(new MiFocusListener());
		txtMensaje.setEnabled(false);

		lblAsunto = new JLabel(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.lblAsunto.text")); //$NON-NLS-1$
		lblAsunto.setBounds(220, 213, 91, 16);
		lblUsuarios.add(lblAsunto);

		btnEnviarMensaje = new JButton(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.btnEnviarMensaje.text")); //$NON-NLS-1$
		btnEnviarMensaje.setBounds(649, 400, 224, 44);
		btnEnviarMensaje
				.setToolTipText(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.btnEnviarMensaje.toolTipText")); //$NON-NLS-1$
		btnEnviarMensaje.setIcon(new ImageIcon(JPanelEnvioMensaje.class.getResource("/Galeria/note.png")));
		btnEnviarMensaje.addActionListener(new BtnEnviarMensajeActionListener());

		btnCancelar = new JButton(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.btnCancelar.text")); //$NON-NLS-1$
		btnCancelar.setBounds(308, 400, 224, 44);
		btnCancelar.setToolTipText(JPanelEnvioMensajeInt.getString("JPanelEnvioMensaje.btnCancelar.toolTipText")); //$NON-NLS-1$
		btnCancelar.setIcon(new ImageIcon(JPanelEnvioMensaje.class.getResource("/Galeria/eraser.png")));
		btnCancelar.addActionListener(new BtnCancelarActionListener());

		txtAsunto = new JTextField();
		txtAsunto.setBounds(308, 213, 565, 145);
		txtAsunto.addKeyListener(new TxtAsuntoKeyListener());
		lblUsuarios.add(txtAsunto);
		txtAsunto.setColumns(10);
		lblUsuarios.add(btnCancelar);
		lblUsuarios.add(btnEnviarMensaje);
		txtDestinatario.setEnabled(false);
		btnEnviarMensaje.setEnabled(false);
		txtAsunto.addFocusListener(new MiFocusListener());

		lblText = new JLabel(); // $NON-NLS-1$
		lblText.setBounds(537, 472, 188, 49);
		lblUsuarios.add(lblText);
		txtAsunto.setEnabled(false);
		txtMensaje.setEnabled(false);
		btnCancelar.setEnabled(false);
		lblUsuarios.setFocusTraversalPolicy(new FocusTraversalPolicy() {
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

	public void rellenarLista() {
		model.removeAllElements();
		for (int i = 0; i < usuarios.size(); i++) {
			if (i != 0) {
				model.addElement(usuarios.get(i).getNombre());
			}
		}
		lstUsuarios.setModel(model);
		lstUsuarios.setSelectedIndex(0);
		lstUsuarios.setCellRenderer(new ListaTrabajdoresInvolucradosRender());
	}

	public void setArrayUsuario(ArrayList<Usuario> users) {
		usuarios = users;
		rellenarLista();

	}

	public void setUsuario(Usuario u) {
		usuario = u;
	}

	private class LstUsuariosMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			int index = lstUsuarios.getSelectedIndex();
			txtDestinatario.setText(usuarios.get(index + 1).getNombre());
			txtMensaje.setEnabled(true);
			txtMensaje.requestFocus();
			lblText.setText("");
			btnCancelar.setEnabled(true);
		}
	}

	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			txtAsunto.setText("");
			txtDestinatario.setText("");
			txtMensaje.setText("");
			lblText.setText("");
			btnEnviarMensaje.setEnabled(false);
			btnCancelar.setEnabled(false);
		}
	}

	private class TxtMensajeKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER && txtMensaje.getText().length() != 0) {
				txtAsunto.setEnabled(true);
				txtAsunto.requestFocus();

			}
		}
	}

	private class BtnEnviarMensajeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LecturaEscritura es = new LecturaEscritura();
			btnEnviarMensaje.setEnabled(false);
			Mensaje m = new Mensaje(txtAsunto.getText(), usuario.getNombre(), false, txtMensaje.getText());
			mensajes = es.lecturaMensajes();
			mensajes.add(m);
			es.EscrituraMensajes(mensajes);
			mensajes = es.lecturaMensajes();
			tarea.Datos(tarea.getUltimaConex(), tarea.getNumeroTareas(), getNumeroMensajes());
			men.rellenarLista();
			txtAsunto.setText("");
			txtDestinatario.setText("");
			txtMensaje.setText("");
			if(lblDestinatario.getText().equals("Address:")) {
				lblText.setText("Message send correctly");
			}else {
				lblText.setText("Mensaje enviado correctamente");	
			}
			btnCancelar.setEnabled(false);
		}
	}

	private class TxtAsuntoKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER && txtAsunto.getText().length() != 0) {
				btnEnviarMensaje.setEnabled(true);
				btnEnviarMensaje.requestFocus();
			}
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

	public void setJFrame(JFrameTareas tare, JPanelMensaje m) {
		tarea = tare;
		men = m;
	}

	public void setIdioma() {
		JPanelEnvioMensajeInt.setIdioma("inglés");
	}

	public void setIdiomaEspanol() {
		JPanelEnvioMensajeInt.setIdioma("es");
		
	}
}

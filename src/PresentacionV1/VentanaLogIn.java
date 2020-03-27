package PresentacionV1;

import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import DominioV1.LecturaEscritura;
import DominioV1.Usuario;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentanaLogIn {

	JFrame frmVentanaLogIn;
	private JPanel pnlLogIn;
	private JLabel lblIdioma;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtUsuario;
	private JPasswordField pswContraseña;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnNuevoUsuario;
	private JLabel lblCheckUsuario;
	private JLabel lblCheckContraseña;
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);
	private Border bordeNegro = BorderFactory.createLineBorder(Color.BLACK);
	public ArrayList<Usuario> listUsuarios = new ArrayList<Usuario>();
	private int id = 0;
	private JLabel label;
	private JButton btnAyuda;
	private JButton btnEspanol;
	private JButton btnIngles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogIn window = new VentanaLogIn();
					window.frmVentanaLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JFrame getfrmVentanaLogIn() {
		return frmVentanaLogIn;
	}

	private void initialize() {

		LecturaEscritura e = new LecturaEscritura();
		listUsuarios = e.lecturaUsuario();
		frmVentanaLogIn = new JFrame();
		frmVentanaLogIn.setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaLogIn.class.getResource("/Galeria/logoEmpresa.png")));
		frmVentanaLogIn.setResizable(false);
		frmVentanaLogIn.setTitle(VentanaLogInII.getString("VentanaLogIn.frmVentanaLogIn.title")); //$NON-NLS-1$
		frmVentanaLogIn.setBounds(100, 100, 667, 381);
		frmVentanaLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVentanaLogIn.getContentPane().setLayout(null);
		pnlLogIn = new JPanel();
		pnlLogIn.setBackground(Color.WHITE);
		pnlLogIn.setBounds(95, 25, 514, 274);
		pnlLogIn.setBorder(new TitledBorder(null, VentanaLogInII.getString("VentanaLogIn.pnlLogIn.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmVentanaLogIn.getContentPane().add(pnlLogIn);
		pnlLogIn.setLayout(null);

		lblUsuario = new JLabel(VentanaLogInII.getString("VentanaLogIn.lblUsuario.text")); //$NON-NLS-1$
		lblUsuario.setBounds(43, 84, 65, 16);
		lblUsuario.setToolTipText(VentanaLogInII.getString("VentanaLogIn.lblUsuario.toolTipText")); //$NON-NLS-1$
		pnlLogIn.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new TxtUsuarioKeyListener());
		txtUsuario.setBounds(126, 81, 231, 22);
		txtUsuario.addFocusListener(new MiFocusListener());
		pnlLogIn.add(txtUsuario);
		txtUsuario.setColumns(10);

		lblCheckUsuario = new JLabel(); // $NON-NLS-1$
		lblCheckUsuario.setBounds(369, 78, 133, 22);
		pnlLogIn.add(lblCheckUsuario);

		lblContrasea = new JLabel(VentanaLogInII.getString("VentanaLogIn.lblContrasea.text")); //$NON-NLS-1$
		lblContrasea.setBounds(43, 119, 78, 16);
		lblContrasea.setToolTipText(VentanaLogInII.getString("VentanaLogIn.lblContrasea.toolTipText")); //$NON-NLS-1$
		lblContrasea.setEnabled(false);
		pnlLogIn.add(lblContrasea);

		btnNuevoUsuario = new JButton(VentanaLogInII.getString("VentanaLogIn.btnNuevoUsuario.text")); //$NON-NLS-1$
		btnNuevoUsuario.setBounds(126, 212, 231, 38);
		btnNuevoUsuario.addActionListener(new BtnNuevoUsuarioActionListener());

		btnCancelar = new JButton(VentanaLogInII.getString("VentanaLogIn.btnCancelar.text")); //$NON-NLS-1$
		btnCancelar.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/eraser.png")));
		btnCancelar.setBounds(126, 161, 102, 38);
		btnCancelar.addActionListener(new BtnCancelarActionListener());

		pswContraseña = new JPasswordField();
		pswContraseña.setBounds(126, 116, 231, 22);
		pswContraseña.addActionListener(new PswContraseñaActionListener());
		pswContraseña.setEnabled(false);
		pswContraseña.addFocusListener(new MiFocusListener());
		pnlLogIn.add(pswContraseña);

		lblCheckContraseña = new JLabel(); // $NON-NLS-1$
		lblCheckContraseña.setBounds(369, 116, 133, 22);
		pnlLogIn.add(lblCheckContraseña);
		btnCancelar.setToolTipText(VentanaLogInII.getString("VentanaLogIn.btnCancelar.toolTipText")); //$NON-NLS-1$
		pnlLogIn.add(btnCancelar);

		btnAceptar = new JButton(VentanaLogInII.getString("VentanaLogIn.btnAceptar.text")); //$NON-NLS-1$
		btnAceptar.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/002-open-exit-door.png")));
		btnAceptar.setBounds(258, 161, 102, 38);
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setEnabled(false);
		btnAceptar.setToolTipText(VentanaLogInII.getString("VentanaLogIn.btnAceptar.toolTipText")); //$NON-NLS-1$
		pnlLogIn.add(btnAceptar);
		btnNuevoUsuario.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/people2.png")));
		btnNuevoUsuario.setToolTipText(VentanaLogInII.getString("VentanaLogIn.btnNuevoUsuario.toolTipText")); //$NON-NLS-1$
		pnlLogIn.add(btnNuevoUsuario);

		btnAyuda = new JButton(); // $NON-NLS-1$
		btnAyuda.setToolTipText(VentanaLogInII.getString("VentanaLogIn.btnAyuda.toolTipText")); //$NON-NLS-1$
		btnAyuda.addActionListener(new BtnAyudaActionListener());
		btnAyuda.setForeground(Color.WHITE);
		btnAyuda.setBackground(Color.WHITE);
		btnAyuda.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/ayuda.png")));
		btnAyuda.setBounds(451, 13, 51, 38);
		pnlLogIn.add(btnAyuda);

		btnEspanol = new JButton();
		btnEspanol.setBounds(185, 26, 49, 29);
		pnlLogIn.add(btnEspanol);
		btnEspanol.setBackground(Color.WHITE);
		btnEspanol.addActionListener(new BtnEspanolActionListener());
		btnEspanol.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/banderaEsp.gif")));

		btnIngles = new JButton();
		btnIngles.addActionListener(new BtnInglesActionListener());
		btnIngles.setBounds(126, 26, 49, 29);
		pnlLogIn.add(btnIngles);
		btnIngles.setBackground(Color.WHITE);
		btnIngles.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/banderaIng.gif")));

		lblIdioma = new JLabel(VentanaLogInII.getString("VentanaLogIn.lblIdioma.text"));
		lblIdioma.setBounds(43, 36, 78, 16);
		pnlLogIn.add(lblIdioma);
		lblIdioma.setToolTipText(VentanaLogInII.getString("VentanaLogIn.lblIdioma.toolTipText"));

		label = new JLabel(VentanaLogInII.getString("VentanaLogIn.label.text")); //$NON-NLS-1$
		label.setIcon(new ImageIcon(VentanaLogIn.class.getResource("/Galeria/fondologin.png")));
		label.setBounds(0, 0, 665, 347);
		frmVentanaLogIn.getContentPane().add(label);
		frmVentanaLogIn.getContentPane().setFocusTraversalPolicyProvider(true);
		frmVentanaLogIn.getContentPane().setFocusTraversalPolicy(new FocusTraversalPolicy() {
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

	private class PswContraseñaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String contraseña = listUsuarios.get(id).getContraseña();
			if (String.valueOf(pswContraseña.getPassword()).equals(contraseña)) {
				pswContraseña.setBorder(bordeVerde);
				btnAceptar.requestFocus();
				btnAceptar.setEnabled(true);
				if (lblUsuario.getText().equals("User")) {
					lblCheckContraseña.setText("Correct Password");
				} else {
					lblCheckContraseña.setText("Contraseña Correcta");
				}
				pswContraseña.setEnabled(false);
				btnCancelar.setEnabled(false);
			} else {
				pswContraseña.setBorder(bordeRojo);
				pswContraseña.requestFocus();
				if (lblUsuario.getText().equals("User")) {
					lblCheckContraseña.setText("Incorrect Password");
				} else {
					lblCheckContraseña.setText("Contraseña Incorrrecta");
				}
			}
		}
	}

	private class BtnNuevoUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int size = 0;
				if (listUsuarios.size() != 0) {
					size = listUsuarios.size() + 1;
				}
				Usuario u = new Usuario(size, null, null, null, null, null, null, null, null, null);

				if (lblUsuario.getText().equals("User")) {
					JFrameNuevoUsario i = new JFrameNuevoUsario(u, listUsuarios);
					i.setVisible(true);
					i.setJFrame(frmVentanaLogIn);
					i.SetIdioma();
				} else {
					JFrameNuevoUsario i = new JFrameNuevoUsario(u, listUsuarios);
					i.setVisible(true);
					i.setJFrame(frmVentanaLogIn);
					i.SetIdiomaEspanol();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private class BtnCancelarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			pswContraseña.setText("");
			txtUsuario.setText("");
			pswContraseña.setBorder(bordeNegro);
			txtUsuario.setBorder(bordeNegro);
			pswContraseña.setEnabled(false);
			lblContrasea.setEnabled(false);
			btnAceptar.setEnabled(false);
			txtUsuario.setEnabled(true);
		}
	}

	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				JFrameTareas t = new JFrameTareas(listUsuarios.get(id),lblUsuario.getText());
				t.setVisible(true);
				frmVentanaLogIn.dispose();
				if (lblUsuario.getText().equals("User")) {
					t.setIdioma();
				}else {
					t.setIdiomaEspanol();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	private class BtnAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				File f = new File("Video.pdf");
				Runtime.getRuntime().exec("cmd /c start " + f.getAbsolutePath());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private class BtnEspanolActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaLogInII.setIdioma("es");
			VentanaLogIn ventana = new VentanaLogIn();
			ventana.frmVentanaLogIn.setVisible(true);
			frmVentanaLogIn.dispose();
		}
	}

	private class BtnInglesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaLogInII.setIdioma("inglés");
			VentanaLogIn ventana = new VentanaLogIn();
			ventana.frmVentanaLogIn.setVisible(true);
			frmVentanaLogIn.dispose();
		}
	}

	private class TxtUsuarioKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
				String nombre = txtUsuario.getText();
				boolean usuario = false;
				for (int i = 0; i < listUsuarios.size(); i++) {
					if (listUsuarios.get(i).getNombre().equals(nombre)) {
						usuario = true;
						id = listUsuarios.get(i).getID();
					}
				}
				if (usuario == true) {
					lblContrasea.setEnabled(true);
					pswContraseña.setEnabled(true);
					pswContraseña.requestFocus();
					txtUsuario.setBorder(bordeVerde);
					if (lblUsuario.getText().equals("User")) {
						lblCheckUsuario.setText("Correct User");
					} else {
						lblCheckUsuario.setText("Usuario Correcto");
					}
					txtUsuario.setEnabled(false);

				} else {
					txtUsuario.setBorder(bordeRojo);
					if (lblUsuario.getText().equals("User")) {
						lblCheckUsuario.setText("Incorrect User");
					} else {
						lblCheckUsuario.setText("Usuario Incorrecto");
					}
				}
			}
		}
	}

	public JFrame getFrame() {
		return frmVentanaLogIn;
	}
}

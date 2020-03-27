package PresentacionV1;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import DominioV1.ImageFilter;
import DominioV1.LecturaEscritura;
import DominioV1.Usuario;

import javax.swing.BorderFactory;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class JPanelDatosUsuario extends JPanel {
	private JLabel lblNombreUsuario;
	private JLabel lblNombreRealUsuario;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JLabel lblRepitaLaContrasea;
	private JTextField txtNombreUsuario;
	private JTextField txtNombreReal;
	private JTextField txtEmail;
	private JPasswordField pswContraseña;
	private JPasswordField pswRepetirContraseña;
	private JLabel lblNombreRepetido;
	private JLabel lblContraseñaTamaño;
	private JLabel lblContraseñasIguales;
	private String nombre;
	private String contraseña;
	private String contraseñaRep;
	private int numeroContraseña = 4;
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);
	private Border bordeNegro = BorderFactory.createLineBorder(Color.GRAY);
	private JPanel pnlFoto;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JButton btnCargarImagen;
	private JTextField txtApellidos;
	private JLabel lblReal;
	private Usuario usuario;
	private ArrayList<Usuario> users;
	private JLabel lblApell;
	private JLabel lblEma;
	private boolean existente = false;
	private JFrameNuevoUsario contentPane;
	private JButton btnVolverAlLogin;
	private JButton btnIniciarLaAplicaion;
	private JPanel pnlImg;
	private JLabel lblFoto;
	private JFrame frame;
	private boolean entrar = false;
	private JLabel lblNuevoUser;
	private JPanel pnlDatos;
	private JPanel pnlDatos2;
	private JPanel pnlBotones;
	private JPanel pnlImgen;
	private boolean salidaNombre = false;
	private boolean iguales = false;

	public JPanelDatosUsuario() {

		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 800, 800));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.this.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 934, 0 };
		gridBagLayout.rowHeights = new int[] { 476, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		pnlFoto = new JPanel();
		pnlFoto.setBackground(Color.WHITE);
		pnlFoto.setForeground(Color.LIGHT_GRAY);
		pnlFoto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.pnlFoto.borderTitle"), //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlFoto.setLayout(null);
		GridBagConstraints gbc_pnlFoto = new GridBagConstraints();
		gbc_pnlFoto.fill = GridBagConstraints.BOTH;
		gbc_pnlFoto.gridx = 0;
		gbc_pnlFoto.gridy = 0;
		add(pnlFoto, gbc_pnlFoto);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(436, 57, 234, 22);
		pnlFoto.add(txtNombreUsuario);
		txtNombreUsuario.addKeyListener(new TxtNombreUsuarioKeyListener());
		txtNombreUsuario.addActionListener(new TxtNombreUsuarioActionListener());
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.addFocusListener(new MiFocusListener());

		lblNombreRepetido = new JLabel(); // $NON-NLS-1$
		lblNombreRepetido.setBounds(682, 57, 210, 22);
		pnlFoto.add(lblNombreRepetido);

		lblContrasea = new JLabel(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblContrasea.text")); //$NON-NLS-1$
		lblContrasea.setBounds(314, 121, 118, 22);
		pnlFoto.add(lblContrasea);

		pswContraseña = new JPasswordField();
		pswContraseña.setBounds(436, 121, 234, 22);
		pnlFoto.add(pswContraseña);
		pswContraseña.addKeyListener(new PswContraseñaKeyListener());
		pswContraseña.addFocusListener(new MiFocusListener());
		pswContraseña.setEnabled(false);

		lblContraseñaTamaño = new JLabel(); // $NON-NLS-1$
		lblContraseñaTamaño.setBounds(682, 121, 222, 22);
		pnlFoto.add(lblContraseñaTamaño);

		pswRepetirContraseña = new JPasswordField();
		pswRepetirContraseña.setBounds(436, 185, 234, 22);
		pswRepetirContraseña.addKeyListener(new PswRepetirContraseñaKeyListener());

		lblRepitaLaContrasea = new JLabel(
				JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblRepitaLaContrasea.text")); //$NON-NLS-1$
		lblRepitaLaContrasea.setBounds(257, 191, 177, 16);
		pnlFoto.add(lblRepitaLaContrasea);
		pnlFoto.add(pswRepetirContraseña);
		pswRepetirContraseña.setEnabled(false);
		pswRepetirContraseña.addActionListener(new PswRepetirContraseñaActionListener());
		pswRepetirContraseña.addFocusListener(new MiFocusListener());

		lblContraseñasIguales = new JLabel(); // $NON-NLS-1$
		lblContraseñasIguales.setBounds(682, 191, 210, 16);
		pnlFoto.add(lblContraseñasIguales);

		lblNombreRealUsuario = new JLabel(
				JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblNombreRealUsuario.text")); //$NON-NLS-1$
		lblNombreRealUsuario.setBounds(257, 249, 177, 22);
		pnlFoto.add(lblNombreRealUsuario);

		lblReal = new JLabel(); // $NON-NLS-1$
		lblReal.setBounds(682, 249, 210, 22);
		pnlFoto.add(lblReal);

		pnlDatos = new JPanel();
		pnlDatos.setBackground(Color.WHITE);
		pnlDatos.setBorder(new TitledBorder(null, "", //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDatos.setForeground(Color.WHITE);
		pnlDatos.setBounds(246, 26, 658, 210);
		pnlFoto.add(pnlDatos);
		pnlDatos.setLayout(null);

		lblNombreUsuario = new JLabel(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblNombreUsuario.text")); //$NON-NLS-1$
		lblNombreUsuario.setBounds(42, 31, 142, 22);
		pnlDatos.add(lblNombreUsuario);

		pnlDatos2 = new JPanel();
		pnlDatos2.setBorder(new TitledBorder(null, "", //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDatos2.setBackground(Color.WHITE);
		pnlDatos2.setBounds(246, 232, 658, 193);
		pnlFoto.add(pnlDatos2);
		pnlDatos2.setLayout(null);

		lblEmail = new JLabel(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblEmail.text"));
		lblEmail.setBounds(90, 146, 87, 22);
		pnlDatos2.add(lblEmail);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(187, 79, 234, 22);
		pnlDatos2.add(txtApellidos);
		txtApellidos.addKeyListener(new TxtApellidosKeyListener());
		txtApellidos.setColumns(10);
		txtApellidos.addFocusListener(new MiFocusListener());
		txtApellidos.setEnabled(false);

		lblEma = new JLabel();
		lblEma.setBounds(431, 135, 205, 22);
		pnlDatos2.add(lblEma);
		lblEma.setToolTipText(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblEma.toolTipText"));

		txtEmail = new JTextField();
		txtEmail.setBounds(187, 135, 234, 22);
		pnlDatos2.add(txtEmail);
		txtEmail.addKeyListener(new TxtEmailKeyListener());
		txtEmail.setColumns(10);
		txtEmail.addFocusListener(new MiFocusListener());
		txtEmail.setEnabled(false);

		lblApellidos = new JLabel(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblApellidos.text"));
		lblApellidos.setBounds(68, 79, 109, 22);
		pnlDatos2.add(lblApellidos);

		txtNombreReal = new JTextField();
		txtNombreReal.setBounds(187, 21, 234, 22);
		pnlDatos2.add(txtNombreReal);
		txtNombreReal.addKeyListener(new TxtNombreRealKeyListener());
		txtNombreReal.setColumns(10);
		txtNombreReal.addFocusListener(new MiFocusListener());
		txtNombreReal.setEnabled(false);

		lblApell = new JLabel();
		lblApell.setBounds(437, 79, 194, 22);
		pnlDatos2.add(lblApell);
		lblApell.setToolTipText(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.lblApell.toolTipText"));

		pnlBotones = new JPanel();
		pnlBotones.setBorder(new TitledBorder(null, "", //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlBotones.setBackground(Color.WHITE);
		pnlBotones.setBounds(246, 438, 658, 74);
		pnlFoto.add(pnlBotones);
		pnlBotones.setLayout(null);

		btnGuardar = new JButton(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.setIcon(new ImageIcon(JPanelDatosUsuario.class.getResource("/Galeria/people2.png")));
		btnGuardar.setBounds(450, 13, 196, 48);
		pnlBotones.add(btnGuardar);
		btnGuardar.setToolTipText(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnGuardar.toolTipText")); //$NON-NLS-1$
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		btnGuardar.setEnabled(false);

		btnIniciarLaAplicaion = new JButton(
				JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnIniciarLaAplicaion.text")); //$NON-NLS-1$
		btnIniciarLaAplicaion
				.setIcon(new ImageIcon(JPanelDatosUsuario.class.getResource("/Galeria/002-open-exit-door.png")));
		btnIniciarLaAplicaion.setBounds(450, 13, 196, 48);
		pnlBotones.add(btnIniciarLaAplicaion);
		btnIniciarLaAplicaion.setToolTipText(
				JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnIniciarLaAplicaion.toolTipText")); //$NON-NLS-1$

		btnVolverAlLogin = new JButton(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnVolverAlLogin.text")); //$NON-NLS-1$
		btnVolverAlLogin.setIcon(new ImageIcon(JPanelDatosUsuario.class.getResource("/Galeria/003-lock.png")));
		btnVolverAlLogin.setBounds(12, 13, 180, 48);
		pnlBotones.add(btnVolverAlLogin);
		btnVolverAlLogin
				.setToolTipText(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnVolverAlLogin.toolTipText")); //$NON-NLS-1$

		btnBorrar = new JButton(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnBorrar.text")); //$NON-NLS-1$
		btnBorrar.setBounds(12, 13, 180, 48);
		pnlBotones.add(btnBorrar);
		btnBorrar.setIcon(new ImageIcon(JPanelDatosUsuario.class.getResource("/Galeria/eraser.png")));
		btnBorrar.setToolTipText(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnBorrar.toolTipText")); //$NON-NLS-1$

		lblNuevoUser = new JLabel(); // $NON-NLS-1$
		lblNuevoUser.setBounds(204, 25, 234, 23);
		pnlBotones.add(lblNuevoUser);
		btnBorrar.addActionListener(new BtnBorrarActionListener());
		btnVolverAlLogin.addActionListener(new BtnVolverAlLoginActionListener());
		btnVolverAlLogin.setVisible(false);
		btnIniciarLaAplicaion.addActionListener(new BtnIniciarLaAplicaionActionListener());
		btnIniciarLaAplicaion.setVisible(false);

		pnlImgen = new JPanel();
		pnlImgen.setBorder(new TitledBorder(null, "", //$NON-NLS-1$
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlImgen.setBackground(Color.WHITE);
		pnlImgen.setBounds(12, 26, 222, 486);
		pnlFoto.add(pnlImgen);
		pnlImgen.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 50, 175, 300);
		pnlImgen.add(scrollPane);

		pnlImg = new JPanel();
		pnlImg.setBackground(Color.WHITE);
		scrollPane.setViewportView(pnlImg);
		GridBagLayout gbl_pnlImg = new GridBagLayout();
		gbl_pnlImg.columnWidths = new int[] { 86, 1, 0, 0 };
		gbl_pnlImg.rowHeights = new int[] { 1, 0, 0 };
		gbl_pnlImg.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlImg.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		pnlImg.setLayout(gbl_pnlImg);

		lblFoto = new JLabel(); // $NON-NLS-1$
		GridBagConstraints gbc_lblFoto = new GridBagConstraints();
		gbc_lblFoto.gridwidth = 3;
		gbc_lblFoto.gridheight = 2;
		gbc_lblFoto.insets = new Insets(0, 0, 5, 5);
		gbc_lblFoto.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFoto.gridx = 0;
		gbc_lblFoto.gridy = 0;
		pnlImg.add(lblFoto, gbc_lblFoto);

		btnCargarImagen = new JButton(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnCargarImagen.text")); //$NON-NLS-1$
		btnCargarImagen.setBounds(12, 379, 198, 45);
		pnlImgen.add(btnCargarImagen);
		btnCargarImagen
				.setToolTipText(JPanelDatosUsuarioInter.getString("JPanelDatosUsuario.btnCargarImagen.toolTipText")); //$NON-NLS-1$
		btnCargarImagen.addActionListener(new BtnCargarImagenActionListener());
		btnCargarImagen.setIcon(new ImageIcon(JPanelDatosUsuario.class.getResource("/Galeria/cargarFoto.png")));
		pnlFoto.setFocusTraversalPolicyProvider(true);
		pnlFoto.setFocusTraversalPolicy(new FocusTraversalPolicy() {
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

	public void comprobar() {
		if (usuario.getNombre() != null) {
			txtNombreUsuario.setEnabled(false);
			if (lblNombreUsuario.getText().equals("User Name*:")) {
				btnGuardar.setText("Save");
			} else {
				btnGuardar.setText("Guardar Datos");
			}

			btnGuardar.setVisible(true);
			existente = true;
			txtNombreUsuario.setText(usuario.getNombre());
			txtNombreReal.setText(usuario.getNombreReal());
			txtApellidos.setText(usuario.getApellidos());
			txtEmail.setText(usuario.getEmail());
			pswContraseña.setText(usuario.getContraseña());
			lblFoto.setIcon(new ImageIcon(usuario.getImagen()));
			txtApellidos.setEnabled(true);
			txtEmail.setEnabled(true);
			txtNombreReal.setEnabled(true);
			pswContraseña.setEnabled(true);
			pswRepetirContraseña.setEnabled(true);
		}
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

	private class TxtNombreUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean salida = true;
			if (existente == false) {
				nombre = txtNombreUsuario.getText();
				for (int i = 0; i < users.size(); i++) {
					if (users.get(i).getNombre().equals(nombre)) {
						if (lblNombreUsuario.getText().equals("User Name*:")) {
							lblNombreRepetido.setText("Repeat User Name");
						} else {
							lblNombreRepetido.setText("Nombre de usuario repetido");
						}
						txtNombreUsuario.setBorder(bordeRojo);
						nombre = null;
						salida = false;
					}
				}
				if (salida == true) {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblNombreRealUsuario.setText("Correct user name");
					} else {
						lblNombreRepetido.setText("Nombre de usuario correcto");
					}
					txtNombreUsuario.setBorder(bordeVerde);
					salidaNombre = true;
				}
			} else {
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblNombreRealUsuario.setText("Correct user name");
				} else {
					lblNombreRepetido.setText("Nombre de usuario correcto");
				}
				txtNombreUsuario.setBorder(bordeVerde);
			}
		}
	}

	private class TxtNombreUsuarioKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (existente == false) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && salidaNombre == true) {
					pswContraseña.setEnabled(true);
					pswContraseña.requestFocus();
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblNombreRealUsuario.setText("Correct user name");
					} else {
						lblNombreRepetido.setText("Nombre de usuario correcto");
					}
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblNombreRepetido.setText("Press enter to confirm your name");
					} else {
						lblNombreRepetido.setText("Pulse enter para confirmar nombre");
					}
				}
			}
		}
	}

	private class PswContraseñaKeyListener extends KeyAdapter {
		public void keyTyped(KeyEvent arg0) {
			contraseña = String.valueOf(pswContraseña.getPassword());
			int size = contraseña.length();
			if ((size) >= numeroContraseña) {
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblContraseñaTamaño.setText("Password long enough");
				} else {
					lblContraseñaTamaño.setText("Contraseña suficiente larga");
				}
				pswContraseña.setBorder(bordeVerde);
				entrar = true;
			} else {
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblContraseñaTamaño.setText("You need :" + ((size - 1) - numeroContraseña) + " letters");
				} else {
					lblContraseñaTamaño.setText("Faltan :" + ((size - 1) - numeroContraseña) + " carcateres");
				}
				pswContraseña.setBorder(bordeRojo);
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (existente == false) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && entrar == true) {
					pswRepetirContraseña.setEnabled(true);
					pswRepetirContraseña.requestFocus();
				}
			} else {
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblContraseñasIguales.setText("Write to confirm");
				} else {
					lblContraseñasIguales.setText("Escriba para confirmar");
				}
			}
		}
	}

	private class PswRepetirContraseñaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			contraseñaRep = String.valueOf(pswRepetirContraseña.getPassword());
			contraseña = String.valueOf(pswContraseña.getPassword());
			if (contraseñaRep.equals(contraseña)) {
				pswRepetirContraseña.setBorder(bordeVerde);
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblContraseñasIguales.setText("Equal passwords");
				} else {
					lblContraseñasIguales.setText("Contraseñas iguales");
				}
				iguales = true;
			} else {
				pswRepetirContraseña.setBorder(bordeRojo);
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblContraseñasIguales.setText("different passwords");
				} else {
					lblContraseñasIguales.setText("Contraseñas distintas");
				}
			}
		}
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			usuario.setNombre(txtNombreUsuario.getText());
			usuario.setApellidos(txtApellidos.getText());
			usuario.setContraseña(String.valueOf(pswRepetirContraseña.getPassword()));
			usuario.setEmail(txtEmail.getText());
			usuario.setNombreReal(txtNombreReal.getText());
			if (usuario.getImagen() == null) {
				usuario.setImagen("nada");
			}
			if (existente == false) {
				users.add(usuario);
				btnIniciarLaAplicaion.setVisible(true);
				btnVolverAlLogin.setVisible(true);
				btnBorrar.setVisible(false);
				btnGuardar.setVisible(false);
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblNuevoUser.setText("User correctly created");
				} else {
					lblNuevoUser.setText("Usuario creado correctamente");
				}
			} else {
				if (lblNombreUsuario.getText().equals("User Name*:")) {
					lblNuevoUser.setText("User correctly modified");
				} else {
					lblNuevoUser.setText("Usuario modificado correctamente");
				}
				btnBorrar.setEnabled(true);
				lblApell.setText("");
				lblEma.setText("");
				lblContraseñasIguales.setText("");
				lblContraseñaTamaño.setText("");
				lblReal.setText("");
				pswRepetirContraseña.setBorder(bordeNegro);
				pswRepetirContraseña.setText("");
			}

			LecturaEscritura es = new LecturaEscritura();
			es.BorrarContenidoFicheroUsuario();
			es.EscrituraFicheroUsuario(users);
		}
	}

	private class TxtNombreRealKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (existente == false) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (txtNombreReal.getText().length() != 0)) {
					lblReal.setText(txtNombreReal.getText());
					txtApellidos.setEnabled(true);
					txtApellidos.requestFocus();
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblReal.setText("Press enter to confirm");
					} else {
						lblReal.setText("Pulse enter para confirmar");
					}
				}
			} else {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (txtNombreReal.getText().length() != 0)) {
					lblReal.setText(txtNombreReal.getText());
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblReal.setText("Press enter to confirm");
						lblContraseñasIguales.setText("Write to confirm");
					} else {
						lblReal.setText("Pulse enter para confirmar nombre");
						lblContraseñasIguales.setText("Escriba para confirmar");
					}
				}
			}
		}

	}

	private class TxtApellidosKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (existente == false) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (txtApellidos.getText().length() != 0)) {
					lblApell.setText(txtApellidos.getText());
					txtEmail.setEnabled(true);
					txtEmail.requestFocus();
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblApell.setText("Press enter to confirm");
					} else {
						lblApell.setText("Pulse enter para confirmar ");
					}
				}
			} else {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (txtApellidos.getText().length() != 0)) {
					lblApell.setText(txtApellidos.getText());
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblApell.setText("Press enter to confirm");
						lblContraseñasIguales.setText("Write to confirm");
					} else {
						lblApell.setText("Pulse enter para confirmar");
						lblContraseñasIguales.setText("Escriba para confirmar");
					}
				}
			}
		}
	}

	private class TxtEmailKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (existente == false) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (txtEmail.getText().length() != 0)) {
					lblEma.setText(txtEmail.getText());
					btnGuardar.setEnabled(true);
					btnGuardar.requestFocus();
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblEma.setText("Press enter to confirm");
					} else {
						lblEma.setText("Pulse enter para confirmar email");
					}
				}
			} else {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && (txtEmail.getText().length() != 0)) {
					lblEma.setText(txtEmail.getText());
				} else {
					if (lblNombreUsuario.getText().equals("User Name*:")) {
						lblEma.setText("Press enter to confirm");
						lblContraseñasIguales.setText("Write to confirm");
					} else {
						lblEma.setText("Pulse enter para confirmar email");
						lblContraseñasIguales.setText("Escriba para confirmar");
					}
				}
			}
		}
	}

	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (existente == false) {
				txtNombreUsuario.setText("");
				txtNombreUsuario.setEnabled(true);
			}

			txtNombreReal.setText("");
			txtApellidos.setText("");
			txtEmail.setText("");
			pswContraseña.setText("");
			pswRepetirContraseña.setText("");
			pswRepetirContraseña.setEnabled(false);
			pswContraseña.setBorder(bordeNegro);
			txtNombreUsuario.setBorder(bordeNegro);
			lblApell.setText("");
			lblContraseñasIguales.setText("");
			lblNombreRepetido.setText("");
			lblContraseñaTamaño.setText("");
			lblReal.setText("");
			lblEma.setText("");
			pswRepetirContraseña.setBorder(bordeNegro);
		}
	}

	private class BtnIniciarLaAplicaionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (lblNombreUsuario.getText().equals("User Name*:")) {
				JFrameTareas t = new JFrameTareas(usuario, "User");
				t.setVisible(true);
				if (lblContrasea.getText().equals("Password*:")) {
					t.setIdioma();
				}
				contentPane.cerrar();
			} else {
				JFrameTareas t = new JFrameTareas(usuario, "usuario");
				t.setVisible(true);
				if (lblContrasea.getText().equals("Password*:")) {
					t.setIdioma();
				}
				contentPane.cerrar();
			}

		}
	}

	private class BtnVolverAlLoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaLogIn n = new VentanaLogIn();
			n.getfrmVentanaLogIn().setVisible(true);
			contentPane.cerrar();
		}
	}

	private class BtnCargarImagenActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = null;
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(frame);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				file = fcAbrir.getSelectedFile();
				JOptionPane.showMessageDialog(frame, "Fichero seleccionado: " + file.getName());
				lblFoto.setIcon(new ImageIcon(file.getAbsolutePath()));
				usuario.setImagen(file.getAbsolutePath());
			}

		}
	}

	private class PswRepetirContraseñaKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (existente == false) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && iguales == true) {
					txtNombreReal.setEnabled(true);
					txtNombreReal.requestFocus();
				}
			} else {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnGuardar.setEnabled(true);
				}
			}
		}
	}

	public void setJFrame(JFrameNuevoUsario jFrameNuevoUsario) {
		contentPane = jFrameNuevoUsario;
		if (lblNombreUsuario.getText().equals("User Name*:")) {
			contentPane.setTitle("New User");
		}
	}

	public void setUsuario(Usuario user) {
		usuario = user;
	}

	public void setArrayListUsuario(ArrayList<Usuario> us) {
		users = us;
	}

	public void setIdioma() {
		JPanelDatosUsuarioInter.setIdioma("inglés");
		if (existente == false) {
			contentPane.dispose();
			JFrameNuevoUsario ventana = new JFrameNuevoUsario(usuario, users);
			ventana.setVisible(true);
		}
	}
	
	public void setIdiomaEspanol() {
		JPanelDatosUsuarioInter.setIdioma("es");
		if (existente == false) {
			contentPane.dispose();
			JFrameNuevoUsario ventana = new JFrameNuevoUsario(usuario, users);
			ventana.setVisible(true);
		}
		
	}

	public void setJFrame(JFrame f) {
		frame = f;
	}
}

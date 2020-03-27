package PresentacionV1;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import DominioV1.Usuario;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class JFrameNuevoUsario extends JFrame {

	private JPanelDatosUsuario contentPane;
	private Usuario u;
	private ArrayList<Usuario> users;
	private JFrame frame;

	public JFrameNuevoUsario(Usuario user, ArrayList<Usuario> us) {
		setResizable(false);
		setTitle("Nuevo Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameNuevoUsario.class.getResource("/Galeria/people.png")));
		u = user;
		users = us;
		setBounds(new Rectangle(500, 500, 0, 0));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 933, 571);
		contentPane = new JPanelDatosUsuario();
		contentPane.setUsuario(u);
		contentPane.setArrayListUsuario(users);
		contentPane.setJFrame(this);
		contentPane.setBounds(new Rectangle(500, 500, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}

	public void cerrar() {
		dispose();
		try {
		frame.dispose();
		}catch (Exception e) {
			VentanaLogIn n = new VentanaLogIn();
			frame=n.getFrame();
			frame.dispose();
		}
	}
	public void SetIdioma() {
		contentPane.setIdioma();
	}
	
	public void SetIdiomaEspanol() {
		contentPane.setIdiomaEspanol();
	}
	
	
	public void setJFrame(JFrame f) {
		frame=f;
	}
}

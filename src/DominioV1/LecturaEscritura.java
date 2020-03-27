package DominioV1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LecturaEscritura {

	public void EscrituraTarea(ArrayList<Tarea> t) {
		try {
			BorrarContenidoFicheroTarea();
			File f = new File("Tarea.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fos);
			for (int i = 0; i < t.size(); i++) {
				bw.write(t.get(i).getDescripion());
				bw.newLine();
				bw.write(t.get(i).getDefinicion());
				bw.newLine();
				bw.write(t.get(i).getPrioridad());
				bw.newLine();
				bw.write(t.get(i).getEstado());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("Escritura tarea" + e.getMessage());
		}
	}

	public void BorrarContenidoFicheroTarea() {
		try {
			File f = new File("Tarea.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write("");
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Tarea> lecturaTareas() {
		Scanner datos;
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		ArrayList<String> usuarios = lecturaTareaUsuario();
		try {
			File f = new File("Tarea.txt");
			datos = new Scanner(new FileReader(f.getAbsolutePath()));
			Tarea t = null;
			while (datos.hasNext()) {
				String txt = datos.nextLine();
				String definicion = datos.nextLine();
				String prioridad = datos.nextLine();
				String estado = datos.nextLine();
				t = new Tarea(txt, prioridad, estado, usuarios, definicion);
				tareas.add(t);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tareas;

	}

	public ArrayList<String> lecturaTareaUsuario() {
		Scanner datos;
		ArrayList<String> usuariosTarea = new ArrayList<String>();
		try {
			File f = new File("UsuarioTarea.txt");
			datos = new Scanner(new FileReader(f.getAbsolutePath()));
			while (datos.hasNext()) {
				String txt = datos.nextLine();
				usuariosTarea.add(txt);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuariosTarea;
	}

	public void BorrarContenidoFicheroTareaUsuario() {
		try {
			File f = new File("UsuarioTarea.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write("");
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void EscrituraTareaUsuario(ArrayList<String> u) {
		try {
			BorrarContenidoFicheroMensaje();
			File f = new File("UsuarioTarea.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fos);
			for (int i = 0; i < u.size(); i++) {
				bw.write(u.get(i));
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// mensajes
	public ArrayList<Mensaje> lecturaMensajes() {
		Scanner datos;
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		try {
			File f = new File("Mensaje.txt");
			datos = new Scanner(new FileReader(f.getAbsolutePath()));
			Mensaje m = null;
			while (datos.hasNext()) {
				String txt = datos.nextLine();
				String asn = datos.nextLine();
				String env = datos.nextLine();
				String le = datos.nextLine();
				if (le.equals("1")) {
					m = new Mensaje(txt, env, false, asn);
				} else {
					m = new Mensaje(txt, env, true, asn);
				}
				mensajes.add(m);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Escritura tarea" + e.getMessage());
		}

		return mensajes;

	}

	public void BorrarContenidoFicheroMensaje() {
		try {
			File f = new File("Mensaje.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write("");
			bw.close();
		} catch (Exception e) {
			System.out.println("Ficher mensaje borrar" + e.getMessage());
		}
	}

	public void EscrituraMensajes(ArrayList<Mensaje> m) {

		try {
			BorrarContenidoFicheroMensaje();
			File f = new File("Mensaje.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fos);
			for (int i = 0; i < m.size(); i++) {
				bw.write(m.get(i).getTexto());
				bw.newLine();
				bw.write(m.get(i).getAsunto());
				bw.newLine();
				bw.write(m.get(i).getEnviado());
				bw.newLine();
				if (m.get(i).isLeido() == true) {
					bw.write("2");
				} else {
					bw.write("1");
				}
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Usuario> lecturaUsuario() {
		Scanner datos;
		ArrayList<Usuario> listUsuarios = new ArrayList<Usuario>();
		int size = listUsuarios.size();
		ArrayList<Mensaje> m = lecturaMensajes();
		ArrayList<Tarea> t = lecturaTareas();
		Usuario u = null;
		try {
			File f = new File("Usuario.txt");
			datos = new Scanner(new FileReader(f.getAbsolutePath()));
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			while (datos.hasNext()) {
				String nombreUs = datos.nextLine();
				String nombreRe = datos.nextLine();
				String apellidos = datos.nextLine();
				String password = datos.nextLine();
				String em = datos.nextLine();
				String rutaImagen = datos.nextLine();
				u = new Usuario(size, nombreUs, nombreRe, apellidos, em, password, t, dateFormat.format(date), m,
						rutaImagen);
				size++;
				listUsuarios.add(u);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Usuario lectura" + e.getMessage());
		}
		return listUsuarios;
	}

	public void BorrarContenidoFicheroUsuario() {
		try {
			File f = new File("Usuario.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write("");
			bw.close();
		} catch (Exception e) {
			System.out.println("Usuario borrar" + e.getMessage());
		}
	}

	public void EscrituraFicheroUsuario(ArrayList<Usuario> u) {
		try {
			File f = new File("Usuario.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath(), true);
			BufferedWriter bw = new BufferedWriter(fos);
			for (int i = 0; i < u.size(); i++) {
				bw.write(u.get(i).getNombre());
				bw.newLine();
				bw.write(u.get(i).getNombreReal());
				bw.newLine();
				bw.write(u.get(i).getApellidos());
				bw.newLine();
				bw.write(u.get(i).getContraseña());
				bw.newLine();
				bw.write(u.get(i).getEmail());
				bw.newLine();
				bw.write(u.get(i).getImagen());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println("Usuario escribir" + e.getMessage());
		}
	}

}

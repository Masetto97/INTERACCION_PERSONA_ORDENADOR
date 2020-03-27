package DominioV1;

import java.io.File;
import java.util.ArrayList;


public class Usuario {

	private int ID;
	private String Nombre;
	private String NombreReal;
	private String Apellidos;
	private String Email;
	private String Contraseña;
	private ArrayList<Tarea> Tareas;
	private String UltimaConexion;
	private ArrayList<Mensaje> Mensajes;
	private String Imagen;

	public Usuario(int iD, String nombre, String nombreReal, String apellidos, String email, String contraseña,
			ArrayList<Tarea> tareas, String ultimaConexion, ArrayList<Mensaje> mensajes, String imagen) {
		ID = iD;
		Nombre = nombre;
		NombreReal = nombreReal;
		Apellidos = apellidos;
		Email = email;
		Contraseña = contraseña;
		Tareas = tareas;
		UltimaConexion = ultimaConexion;
		Mensajes = mensajes;
		Imagen = imagen;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public ArrayList<Mensaje> getMensajes() {
		return Mensajes;
	}

	public void setMensajes(ArrayList<Mensaje> mensajes) {
		Mensajes = mensajes;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNombreReal() {
		return NombreReal;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public void setNombreReal(String nombreReal) {
		NombreReal = nombreReal;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public ArrayList<Tarea> getTareas() {
		return Tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		Tareas = tareas;
	}

	public void añadirTarea(Tarea t) {
		Tareas.add(t);
	}

	public void eliminarTarea(int i) {
		Tareas.remove(i);
	}

	public Tarea terminarTarea(int i) {
		return Tareas.get(i);
	}

	public String getUltimaConexion() {
		return UltimaConexion;
	}

	public void setUltimaConexion(String ultimaConexion) {
		UltimaConexion = ultimaConexion;
	}

	public int getNumeroTareas() {
		return Tareas.size();
	}

	public int getNuemeroMensajes() {
		return Mensajes.size();
	}

	@Override
	public String toString() {
		return "Usuario [ID=" + ID + ", Nombre=" + Nombre + ", NombreReal=" + NombreReal + ", Apellidos=" + Apellidos
				+ ", Email=" + Email + ", Contraseña=" + Contraseña + ", Tareas=" + Tareas + ", UltimaConexion="
				+ UltimaConexion + "]";
	}

}

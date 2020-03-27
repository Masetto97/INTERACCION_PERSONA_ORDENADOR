package DominioV1;

import java.util.ArrayList;

public class Tarea {

	private String Descripion;
	private String Definicion;
	private String Prioridad;
	private String Estado;
	private ArrayList<String> Participantes;

	public Tarea(String descripion, String prioridad, String estado, ArrayList<String> participantes, String definicion) {
		Descripion = descripion;
		Prioridad = prioridad;
		Estado = estado;
		Definicion = definicion;
		Participantes = participantes;
	}

	public String getDefinicion() {
		return Definicion;
	}

	public void setDefinicion(String definicion) {
		Definicion = definicion;
	}

	public String getDescripion() {
		return Descripion;
	}

	public void setDescripion(String descripion) {
		Descripion = descripion;
	}

	public String getPrioridad() {
		return Prioridad;
	}

	public void setPrioridad(String prioridad) {
		Prioridad = prioridad;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public ArrayList<String> getParticipantes() {
		return Participantes;
	}

	public void setParticipantes(ArrayList<String> participantes) {
		Participantes = participantes;
	}

	public int getNumeroParticipantes() {
		return Participantes.size();
	}

	@Override
	public String toString() {
		return "Tarea [Descripion=" + Descripion + ", Definicion=" + Definicion + ", Prioridad=" + Prioridad
				+ ", Estado=" + Estado + ", Participantes=" + Participantes + "]";
	}

}

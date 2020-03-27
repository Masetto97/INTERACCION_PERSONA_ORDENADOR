package DominioV1;

import java.util.Date;;

public class DatosLogIn {
	private String Nombre;
	private Date fecha;
	
	public DatosLogIn(String nombre, Date fecha) {
		Nombre = nombre;
		this.fecha = fecha;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}

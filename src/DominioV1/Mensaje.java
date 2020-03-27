package DominioV1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Mensaje {

	private String Asunto;
	private String Texto;
	private String Enviado;
	private boolean Leido;

	public Mensaje(String texto, String enviado, boolean leido, String asunto) {
		Texto = texto;
		Enviado = enviado;
		Leido = leido;
		Asunto = asunto;
	}

	public String getAsunto() {
		return Asunto;
	}

	public void setAsunto(String asunto) {
		Asunto = asunto;
	}

	public String getTexto() {
		return Texto;
	}

	public void setTexto(String texto) {
		Texto = texto;
	}

	public String getEnviado() {
		return Enviado;
	}

	public void setEnviado(String enviado) {
		Enviado = enviado;
	}

	public boolean isLeido() {
		return Leido;
	}

	public void setLeido(boolean leido) {
		Leido = leido;
	}

	@Override
	public String toString() {
		return "Mensaje [Asunto=" + Asunto + ", Texto=" + Texto + ", Enviado=" + Enviado + ", Leido=" + Leido + "]";
	}
	
}

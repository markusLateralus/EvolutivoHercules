package modelo;

import java.util.ArrayList;
import java.util.List;

public enum Rol {

	 TECNICO_DE_CENTRAL ("Tecnico de cental"),
	 TECNICO_DE_ZONA ("Tecnico de zona"),
	 RESPONSABLE ("Responsable"),
	 RESPONSABLE_DE_IMPRESION ("Responsable de Impresion");
	 
	 public static List <String> LISTA=new ArrayList<String>();
	 private String rol;
	Rol(String string) {
		// TODO Auto-generated constructor stub
		this.rol=string;
	}
	
	public String getTexto() {
		return rol;
	}
	
	public static void agregarRol(String rol) {
		LISTA.add(rol);
	}
}

package modelo;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {

	public String nombre;
	public String dni;
	public String rol;
	
	public Trabajador(String nombre, String dni, String rol) {
	this.nombre=nombre;
	this.dni=dni;
	this.rol=rol;
	}
	public Trabajador(String nombre, String dni) {
		this.nombre=nombre;
		this.dni=dni;
		
		}

	
	
	
	public static List<Trabajador>trabajadores=new ArrayList<Trabajador>();

	
	public static void agregar(Trabajador trabajador) {
		trabajadores.add(trabajador);
	}
}

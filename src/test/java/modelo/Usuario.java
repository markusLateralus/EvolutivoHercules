package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	public String nombre;
	public String dni;
	public String rol;
	
	public Usuario(String nombre, String dni, String rol) {
	this.nombre=nombre;
	this.dni=dni;
	this.rol=rol;
	}
	public Usuario(String nombre, String dni) {
		this.nombre=nombre;
		this.dni=dni;
		
		}
	
	public static List<Usuario>usuarios=new ArrayList<Usuario>();

	
	public static void agregar(Usuario usuario) {
		usuarios.add(usuario);
	}
}

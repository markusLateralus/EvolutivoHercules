package modelo;

import java.util.ArrayList;
import java.util.List;

import net.thucydides.core.annotations.Feature;

@Feature
public class Usuario {

	public String nombre;
	public String password;
	public String rol;
	
	public Usuario(String nombre, String password, String rol) {
	this.nombre=nombre;
	this.password=password;
	this.rol=rol;
	}
	public Usuario(String nombre, String password) {
		this.nombre=nombre;
		this.password=password;
		
		}

	
	
	
	public static List<Usuario>usuarios=new ArrayList<Usuario>();

	
	public static void agregar(Usuario usuario) {
		usuarios.add(usuario);
	}
}

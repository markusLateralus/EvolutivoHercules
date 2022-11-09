package modelo;

import java.util.ArrayList;
import java.util.List;

public class ConsultaEmpleadoPuesto {

	public static  String evaluacion;
	public String dni;
	public String puesto;
	public String lote;
	public static List<ConsultaEmpleadoPuesto>lista=new ArrayList<ConsultaEmpleadoPuesto>();
	//public static List <String>lotes=new ArrayList<String>();
	
	public ConsultaEmpleadoPuesto(String dni, String puesto, String lote) {
		this.dni=dni;
		this.puesto=puesto;
		this.lote=lote;

	}
	
	
	public static void agregar(ConsultaEmpleadoPuesto consulta) {
		lista.add(consulta);
	}
	
}

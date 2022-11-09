package modelo;

import java.util.ArrayList;
import java.util.List;

public class ConsultaDeEvaluacion {

	public String provincia;
	public String empresa;
	public String modeloNegocio;
	
	public ConsultaDeEvaluacion(String provincia, String empresa, String modeloNegocio) {
		this.provincia=provincia;
		this.empresa=empresa;
		this.modeloNegocio=modeloNegocio;
	}
	
	public static List <ConsultaDeEvaluacion> datos=new ArrayList<ConsultaDeEvaluacion>();
	public static void agregar(ConsultaDeEvaluacion consulta) {
		datos.add(consulta);
	}
}

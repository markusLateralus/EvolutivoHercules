package steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import escritorio.NavegaA;
import escritorio.NavegaAconsultaRiesgos;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import menu.Riesgos.EdicionRiesgos.EditorMedidas;
import menu.Riesgos.EdicionRiesgos.EditorMedidasAterceros;
import modelo.Trabajador;
import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;

public class CambioDeEditorTextoStep {

	
	private static int CONTADOR=1;
	private String rutaEscenario="";
	NavegaA navegaA;
	@Steps
	login.Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	NavegaAconsultaRiesgos navegaAconsultaRiesgos;
	
	@Steps
	menu.Riesgos.ConsultaRiesgos.RealizaBusqueda realizaBusqueda;
	@Steps
	EditorMedidasAterceros editorMedidasAterceros;
	@Steps
	EditorMedidas editorMedidas;
	
	@Before("@medidas or @medidasAterceros")
	public void antes(Scenario escenario) {
		//reiniciamos los contadores
		if(CONTADOR==2)CONTADOR=1;
		if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==2)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1; //solo es un usuario
		
		Collection<String> etiquetas=escenario.getSourceTagNames();
		for(String esc: etiquetas) {
			rutaEscenario=esc;	
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		AlmacenRutasDeCapturaPantalla.setValorRuta(8);
	}
	@Given("el usuario se loga en la aplicacion Hercules")
	public void el_usuario_se_loga_en_la_aplicacion_hercules(DataTable table) {
		navega.aLogin();
		List<List<String>> rows = table.asLists(String.class);
		for (List<String> row : rows) {
			Trabajador.agregar(new Trabajador(row.get(0), row.get(1), row.get(2)));
		}
		logarse.conUsuarioYpassword(Trabajador.trabajadores.get(CONTADOR).nombre,
				Trabajador.trabajadores.get(CONTADOR).dni);
		
	}
	
	@Given("el usuario realiza una busqueda de riesgo por id")
	public void el_usuario_realiza_una_busqueda_de_riesgo_por_id(io.cucumber.datatable.DataTable table) {
	//	navegaAconsultaRiesgos.accede();
		navegaA.consultaRiesgo();
		
		List<List<String>> rows = table.asLists(String.class);
		List <String> valor=new ArrayList <String>();
		for (List<String> row : rows) {
			//Trabajador.agregar(new Trabajador(row.get(0), row.get(1), row.get(2)));
			valor.add(row.get(0));
		}
		realizaBusqueda.porID(valor.get(CONTADOR));
		realizaBusqueda.seleccionaResultadoBusqueda();
	}

	//@medidas 
	@When("el usuario abre el editor de texto con el boton Medidas")
	public void el_usuario_abre_el_editor_de_texto_con_el_boton_medidas() {
		  editorMedidasAterceros.abrir();
		  editorMedidas.abrir();
	}
	//@medidas y @medidasAterceros
	@Then("el usuario puede agregar imagen")
	public void el_usuario_puede_agregar_imagen() {
	    editorMedidasAterceros.agregarImagen();
	    editorMedidas.agregarImagen();
	}
	@Then("el usuario puede agregar texto al lado de la imagen")
	public void el_usuario_puede_agregar_texto_al_lado_de_la_imagen() {
	    editorMedidasAterceros.agregarTexto("hola");
	    editorMedidas.agregarTexto("paramedidas");
	}
	@Then("el usuario guarda los cambios correctamente")
	public void el_usuario_guarda_los_cambios_correctamente() {
		editorMedidasAterceros.aceptarCambios();
		editorMedidasAterceros.guardarCambios();
		editorMedidas.aceptarCambios();
		editorMedidas.guardarCambios();
	}
	
	//@medidasAterceros
	@When("el usuario abre el editor de texto con el boton Medidas a Terceros")
	public void el_usuario_abre_el_editor_de_texto_con_el_boton_medidas_a_terceros() {
		 editorMedidasAterceros.abrir();
	}

	@After("@medidas or @medidasAterceros")
	public void guardar(Scenario escenario) {
		Collection<String> etiquetas = escenario.getSourceTagNames();
		for (String etiqueta : etiquetas) {
			if (etiqueta.equalsIgnoreCase("@medidas")) {
				FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
						CONTADOR, rutaEscenario, TituloPortada.EDITOR_MEDIDAS,
						Descripcion.MEDIAS, Sprint.Sprint4);
		    }else if (etiqueta.equalsIgnoreCase("@mediasAterceros")) {
			     FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
					CONTADOR, rutaEscenario,TituloPortada.EDITOR_MEDIDAS_A_TERCERCEROS,
					Descripcion.MEDIAS_A_TERCEROS, Sprint.Sprint4);
	        
		    }
		}

		CONTADOR++;
		//reseteamos las rutas
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
		rutaEscenario="";

	      
	       }
}

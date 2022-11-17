package steps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import escritorio.RutaParaIrConsultaEvaluacion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import login.Navega;
import menu.Evaluaciones.ConsultaEvaluacion.RealizaBusqueda;
import menu.Evaluaciones.ConsultaEvaluacion.ResultadoDeLaBusqueda;
import menu.Evaluaciones.EdicionEvaluacion.SeleccionarPuestos;
import menu.Puestos.EdicionPuesto.DescargaIGCT;
import menu.Puestos.EdicionPuesto.DescargaIGN;
import modelo.ConsultaDeEvaluacion;
import modelo.Trabajador;
import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;

public class DescargaDocumentosAsociadosIGNeIGCTStep {

	private static int CONTADOR = 1;
	private String rutaEscenario = "";
	@Steps
	Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	RutaParaIrConsultaEvaluacion rutaParaIrConsultaEvaluacion;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	ResultadoDeLaBusqueda resultadoDeLaBusqueda;
	@Steps
	SeleccionarPuestos seleccionarPuestos;
	@Steps
	DescargaIGCT descargaIGCT;
	@Steps
	DescargaIGN descargaIGN;

	List<TituloPortada> titulosPortada = new ArrayList<TituloPortada>();
	List<Descripcion> descripciones = new ArrayList<Descripcion>();
	List<Sprint> sprints = new ArrayList<Sprint>();

	private void llenarEnumerados() {
		titulosPortada.add(TituloPortada.TITULO_DESCARGAR_IGCT);
		titulosPortada.add(TituloPortada.TITULO_DESCARGAR_IGN);
		descripciones.add(Descripcion.DESCRIPCION_DESCARGAR_IGCT);
		descripciones.add(Descripcion.DESCRIPCION_DESCARGAR_IGN_Boton1);
		descripciones.add(Descripcion.DESCRIPCION_DESCARGAR_IGN_Boton2);
		sprints.add(Sprint.Sprint1);

	}

	@Before("@ignBoton1 or @ignBoton2 or @igct")
	public void antes(Scenario scenario) {
		this.llenarEnumerados();
		// reiniciamos los contadores
		if (CONTADOR == 5)
			CONTADOR = 1;
		//if (CapturaPantalla.CONTADOR_VUELTAS_APLICACION >= 5)CapturaPantalla.CONTADOR_VUELTAS_APLICACION = 1;

		Collection<String> etiquetas = scenario.getSourceTagNames();
		for (String etiqueta : etiquetas) {
			rutaEscenario = etiqueta;
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario = rutaEscenario;
		//AlmacenRutasDeCapturaPantalla.setValorRuta(3);
		
	}

	@Given("^el usuario entra en Hercules$")
	public void el_usuario_entra_en_hercules() {
		navega.aLogin();
	}

	@Given("el usuario se logea correctamente")
	public void el_usuario_se_logea_correctamente(DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
		for (List<String> row : rows) {
			Trabajador.agregar(new Trabajador(row.get(0), row.get(1), row.get(2)));
		}

		logarse.conUsuarioYpassword(Trabajador.trabajadores.get(CONTADOR).nombre,
				Trabajador.trabajadores.get(CONTADOR).dni);

	}

	@Given("el usuario se dirige a la pantalla Consulta Evaluacion")
	public void el_usuario_se_dirige_a_la_pantalla_consulta_evaluacion() {
		 rutaParaIrConsultaEvaluacion.accede();
	}

	@Given("el usuario realiza la busqueda correctamente con la provincia, empresa y modelo de negocio")
	public void el_usuario_realiza_la_busqueda_correctamente_con_la_provincia_empresa_y_modelo_de_negocio(DataTable table) {
		  List<List<String>> rows = table.asLists(String.class);
		  for (List<String> row: rows) { 
			  ConsultaDeEvaluacion.agregar(new ConsultaDeEvaluacion(row.get(0),row.get(1), row.get(2)));
		 } 
		  realizaBusqueda.rellenaFormulario(ConsultaDeEvaluacion.datos.get(CONTADOR).
		  provincia, ConsultaDeEvaluacion.datos.get(CONTADOR).empresa,
		 ConsultaDeEvaluacion.datos.get(CONTADOR).modeloNegocio);
		 
	}

	@Given("el usuario accede a la pantalla Edicion Evalucion")
	public void el_usuario_accede_a_la_pantalla_edicion_evalucion() {
		 resultadoDeLaBusqueda.accedePantallaEdicionEvaluacion();
	}

	@Given("el usuario accede a la la pantalla Edicion Puesto")
	public void el_usuario_accede_a_la_la_pantalla_edicion_puesto() {
		 seleccionarPuestos.accedeAlaPantallaEdicionPuesto();
	}

	@When("el usuario selecciona la pestania Ins Guias Nacionales")
	public void el_usuario_selecciona_la_pestania_ins_guias_nacionales() {
		 descargaIGN.seleccionarPestaniaGuiaNacionales(rutaEscenario);
	}

	@Then("el usuario pulsa el boton {string} y se descarga la documentacion Ins Guias Nacionales correctamente")
	public void el_usuario_pulsa_el_boton_y_se_descarga_la_documentacion_ins_guias_nacionales_correctamente(String boton) {	
			boton="";
			  descargaIGN.descargar(rutaEscenario);	
	
	 
	}
/////////////////	

	@When("el usuario selecciona la pestania Ins Guias Cliente Proyecto")
	public void el_usuario_selecciona_la_pestania_ins_guias_cliente_proyecto() {
		 descargaIGCT.seleccionarPestaniaGuiaClienteProyecto(rutaEscenario);
	}

	@Then("el usuario se descarga la documentacion Ins.Guias Cliente Proyecto correctamente")
	public void el_usuario_se_descarga_la_documentacion_ins_guias_cliente_proyecto_correctamente() {
		 descargaIGCT.descargarGuiaClienteProyecto(rutaEscenario);
	}

	@After("@ignBoton1 or @ignBoton2 or @igct")
	public void despues(Scenario escenario) {
		Collection<String> etiquetas = escenario.getSourceTagNames();
		for (String etiqueta : etiquetas) {
			if (etiqueta.equalsIgnoreCase("@igct")) {
				FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
						CapturaPantalla.CONTADOR_VUELTAS_APLICACION, rutaEscenario, titulosPortada.get(0),
						descripciones.get(0), sprints.get(0));

			} else if (etiqueta.equalsIgnoreCase("@ignBoton1")) {
				FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
						CapturaPantalla.CONTADOR_VUELTAS_APLICACION, rutaEscenario, titulosPortada.get(1),
						descripciones.get(1), sprints.get(0));

			} else if (etiqueta.equalsIgnoreCase("@ignBoton2")) {
				FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
						CapturaPantalla.CONTADOR_VUELTAS_APLICACION, rutaEscenario, titulosPortada.get(1),
						descripciones.get(2), sprints.get(0));

			}
		}
		//CapturaPantalla.CONTADOR_VUELTAS_APLICACION++; NO SE SI HE HECHO BIEN EN COMENTAR
		CONTADOR++;
		// reseteamos las rutas
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario = "";
		rutaEscenario = "";
		

	}

}

package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import login.Navega;
import menu.Documentacion.AsociacionEmpleadoPuesto.GeneraDocumentacion;
import menu.Documentacion.AsociacionEmpleadoPuesto.RealizaBusqueda;
import menu.Documentacion.AsociacionEmpleadoPuesto.RutaParaIrBandejaDeSalida;
import menu.Documentacion.BandejaDeSalida.RealizaDescarga;
import modelo.ConsultaEmpleadoPuesto;
import modelo.Trabajador;
import escritorio.RutaParaIrAsociacionEmpleadoPuesto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;
import utiles.lecturaPdf.LecturaPdf;

public class DescargarFormularioAdiestramientoParametrizadoStep {

	private static int CONTADOR = 1;
	private String rutaEscenario="";
	
	@Steps
	Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	RutaParaIrAsociacionEmpleadoPuesto rutaParaIrAsociacionEmpleadoPuesto;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	GeneraDocumentacion generaDocumentacion;
	@Steps
	RutaParaIrBandejaDeSalida rutaParaIrBandejaDeSalida;
	@Steps
	RealizaDescarga realizaDescarga;

	LecturaPdf lecturaPdf;
	List<TituloPortada> titulosPortada = new ArrayList<TituloPortada>();
	List<Descripcion> descripciones = new ArrayList<Descripcion>();
	List<Sprint> sprints = new ArrayList<Sprint>();
	private void llenarEnumerados() {
		titulosPortada.add(TituloPortada.TITULO_DESCARGAR_FORMULARIOADIESTRAMIENTO);
		titulosPortada.add(TituloPortada.TITULO_DESCARGAR_FORMULARIOADIESTRAMIENTO_SIN_RESPUESTA);
		descripciones.add(Descripcion.DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO);
		descripciones.add(Descripcion.DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO_SIN_RESPUESTAS);
		sprints.add(Sprint.Sprint3);

	}
	String fichero="F-820-080-70 Certificacion de adiestramiento tutelado. Actividades de Auxiliares de Servicio.pdf";
	String ficheroRespuesta="CUR_4096_v0_6364_35579678N.pdf";
	@Before()
	public void antes(Scenario escanario) {
		this.llenarEnumerados();
		if(CONTADOR==5)CONTADOR=1;
		if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==5)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1;
		Collection<String> etiquetas=escanario.getSourceTagNames();
		for(String esc: etiquetas) {
			rutaEscenario=esc;	
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		AlmacenRutasDeCapturaPantalla.setValorRuta(5);
	}
	
	@Given("el usuario logado correctamente en Hercules")
	public void el_usuario_logado_correctamente_en_hercules(DataTable table) {
		navega.aLogin();
		List<List<String>> rows = table.asLists(String.class);
			for (List<String> row : rows) {
				Trabajador.agregar(new Trabajador(row.get(0), row.get(1)));
			}
			logarse.conUsuarioYpassword(Trabajador.trabajadores.get(CONTADOR).nombre,
					Trabajador.trabajadores.get(CONTADOR).dni);
	}
	@Given("el usuario se dirige a la pantalla Documentacion-Empleado puesto")
	public void el_usuario_se_dirige_a_la_pantalla_documentacion_empleado_puesto() {
		 rutaParaIrAsociacionEmpleadoPuesto.accede();
	}
	@Given("el usuario realiza una busqueda por evaluacion")
	public void el_usuario_realiza_una_busqueda_por_evaluacion(DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
			for (List<String> row : rows) {
				ConsultaEmpleadoPuesto.evaluacion=row.get(0);
			}	
		 realizaBusqueda.porEvaluacion(ConsultaEmpleadoPuesto.evaluacion);	
	}
	@Given("el usuario selecciona un dni, un puesto y genera un lote nuevo")
	public void el_usuario_selecciona_un_dni_un_puesto_y_genera_un_lote_nuevo(DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
		for (List<String> row : rows) {
			ConsultaEmpleadoPuesto.agregar(new ConsultaEmpleadoPuesto(row.get(0), row.get(1), row.get(2)));
		}
		 generaDocumentacion.conLote(ConsultaEmpleadoPuesto.lista.get(CONTADOR).lote);
	}
	@Given("el usuario se dirige a la pantalla Bandeja de Salida y se encuentra la documentacion generada")
	public void el_usuario_se_dirige_a_la_pantalla_bandeja_de_salida_y_se_encuentra_la_documentacion_generada() {
		rutaParaIrBandejaDeSalida.accede();
	}
	@When("el usuario se descarga el formulario de adiestramiento con lote {string} , dni {string} y puesto {string}")
	public void el_usuario_se_descarga_el_formulario_de_adiestramiento_con_lote_dni_y_puesto(String lote, String dni,String puesto) {
		 realizaDescarga.actualizarPagina();
			realizaDescarga.delFormularioDeAdiestramiento(lote, dni, puesto);
	}
	@Then("el usuario verifica que esta incluido el nombre del trabajador {string}")
	public void el_usuario_verifica_que_esta_incluido_el_nombre_del_trabajador(String nombreTrabajador) {
		String texto = LecturaPdf.leer(this.fichero);
		System.out.println("TEXTO: " +texto);
		boolean encontrado = LecturaPdf.contieneNombreTrabajador(texto, nombreTrabajador);
		assertTrue("debe coincidir el nombre del trabajador", encontrado);
		
	}
	@Then("el usuario verifica que esta incluido  el dni {string}")
	public void el_usuario_verifica_que_esta_incluido_el_dni(String dni) {
		String texto = LecturaPdf.leer(this.fichero);
		boolean encontrado = LecturaPdf.contieneDNI(texto, dni);
		assertTrue("debe coincidir el dni del trabajador", encontrado);
		
	}
///////////////////////////	
	@When("el usuario se descarga el formulario de adiestramiento con lote {string}, dni {string} y puesto {string} y el CUR")
	public void el_usuario_se_descarga_el_formulario_de_adiestramiento_con_lote_dni_y_puesto_y_el_CUR(String lote, String dni, String puesto) {
		 realizaDescarga.actualizarPagina();
		realizaDescarga.deLosFormulariosAdiestramientoYCUR(lote, dni,puesto);
	}
	@Then("el usuario no encuentra el archivo con las respuestas.")
	public void el_usuario_no_encuentra_el_archivo_con_las_respuestas() {
		String textoRespueta = LecturaPdf.leer(this.ficheroRespuesta);
		String textoOriginal = LecturaPdf.leer(this.fichero);
		boolean encontrado=LecturaPdf.buscarOtroArchivo(textoOriginal, textoRespueta);
		assertFalse("No debe existir conincidencia", encontrado);
		//String texto = LecturaPdf.leer();
		
	}

	@After()
	public void despues(Scenario escenario) {
		Collection<String> etiquetas = escenario.getSourceTagNames();
		for (String etiqueta : etiquetas) {
			if (etiqueta.equalsIgnoreCase("@descargaFormulario")) {
		FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,	CapturaPantalla.CONTADOR_VUELTAS_APLICACION, rutaEscenario, titulosPortada.get(0),descripciones.get(0),sprints.get(0));
			}else if(etiqueta.equalsIgnoreCase("@VerficaFormularioSinRespuesta")) {
				FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,	CapturaPantalla.CONTADOR_VUELTAS_APLICACION, rutaEscenario,titulosPortada.get(1),descripciones.get(1),sprints.get(0));
			}
		}
		//CapturaPantalla.CONTADOR_VUELTAS_APLICACION++;
		CONTADOR++;
		//reseteamos las rutas
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
		rutaEscenario="";

	}

}

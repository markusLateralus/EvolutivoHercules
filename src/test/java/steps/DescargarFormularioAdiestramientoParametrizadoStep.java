package steps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import login.Navega;
import menu.Documentacion.AsociacionEmpleadoPuesto.GeneraDocumentacion;
import menu.Documentacion.AsociacionEmpleadoPuesto.RealizaBusqueda;
import menu.Documentacion.AsociacionEmpleadoPuesto.RutaParaIrBandejaDeSalida;
import menu.Documentacion.BandejaDeSalida.RealizaDescarga;
import modelo.ConsultaEmpleadoPuesto;
import modelo.Usuario;
import escritorio.RutaParaIrAsociacionEmpleadoPuesto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import net.thucydides.core.annotations.Steps;
import utiles.pdf.LecturaPdf;

public class DescargarFormularioAdiestramientoParametrizadoStep {

	private static int CONTADOR = 1;
	
	
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
	
	@Before()
	public void antes() {
		if (CONTADOR == 5) {
			CONTADOR = 1;
		}
	}
	
	@Given("el usuario logado correctamente en Hercules")
	public void el_usuario_logado_correctamente_en_hercules(DataTable table) {
		navega.aLogin();
		List<List<String>> rows = table.asLists(String.class);
			for (List<String> row : rows) {
				Usuario.agregar(new Usuario(row.get(0), row.get(1)));
			}

			logarse.conUsuarioYpassword(Usuario.usuarios.get(CONTADOR).nombre,
					Usuario.usuarios.get(CONTADOR).dni);
			System.out.println("CONTADOR " + CONTADOR);
	}
	@Given("el usuario se dirige a la pantalla Documentacion-Empleado puesto")
	public void el_usuario_se_dirige_a_la_pantalla_documentacion_empleado_puesto() {
		 rutaParaIrAsociacionEmpleadoPuesto.accede();
	}
	@Given("el usuario realiza una busqueda por evaluacion")
	public void el_usuario_realiza_una_busqueda_por_evaluacion(DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
		//	int totalColumnas = table.width();// 3
			// System.out.println("total columnas " + totalColumnas);
			// System.out.println("total filas " + rows.size());
	
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
			//ConsultaEmpleadoPuesto.agregerLote(row.get(2));
		
		}
		 generaDocumentacion.conLote(ConsultaEmpleadoPuesto.lista.get(CONTADOR).lote);
	}
	@Given("el usuario se dirige a la pantalla Bandeja de Salida y se encuentra la documentacion generada")
	public void el_usuario_se_dirige_a_la_pantalla_bandeja_de_salida_y_se_encuentra_la_documentacion_generada() {
		rutaParaIrBandejaDeSalida.accede();
	}
	@When("el usuario se descarga el formulario de adiestramiento con lote {string}, dni {string} y puesto {string}")
	public void el_usuario_se_descarga_el_formulario_de_adiestramiento_con_lote_dni_y_puesto(String lote, String dni, String puesto) {
		 realizaDescarga.actualizarPagina();
			realizaDescarga.delFormularioDeAdiestramiento(lote, dni, puesto);
	}
	@Then("el usuario verifica que esta incluido el nombre del trabajador {string}")
	public void el_usuario_verifica_que_esta_incluido_el_nombre_del_trabajador(String nombreTrabajador) {
		String fichero="F-820-080-70 Certificacion de adiestramiento tutelado. Actividades de Auxiliares de Servicio.pdf";
		String texto = LecturaPdf.leer(fichero);
		System.out.println("TEXTO: " +texto);
		boolean encontrado = LecturaPdf.contieneNombreTrabajador(texto, nombreTrabajador);
		assertTrue("debe coincidir el nombre del trabajador", encontrado);
	}
	@Then("el usuario verifica que esta incluido  el dni {string}")
	public void el_usuario_verifica_que_esta_incluido_el_dni(String dni) {
		String fichero="F-820-080-70 Certificacion de adiestramiento tutelado. Actividades de Auxiliares de Servicio.pdf";
		String texto = LecturaPdf.leer(fichero);
		boolean encontrado = LecturaPdf.contieneDNI(texto, dni);
		assertTrue("debe coincidir el dni del trabajador", encontrado);
	}
///////////////////////////	
	
	@Then("el usuario no encuentra el archivo con las respuestas.")
	public void el_usuario_no_encuentra_el_archivo_con_las_respuestas() {
		String ficheroRespuesta="CUR_4096_v0_6364_35579678N.pdf";
		String textoRespueta = LecturaPdf.leer(ficheroRespuesta);
		String fichero="F-820-080-70 Certificacion de adiestramiento tutelado. Actividades de Auxiliares de Servicio.pdf";
		String textoOriginal = LecturaPdf.leer(fichero);
		boolean encontrado=LecturaPdf.buscarOtroArchivo(textoOriginal, textoRespueta);
		assertFalse("No debe existir conincidencia", encontrado);
		//String texto = LecturaPdf.leer();
	}

	@After()
	public void despues() {
		CONTADOR++;

	}
/*
	@Given("el usuario logado correctamente en Hercules con usuario {string} y contrasenia {string}")
	public void el_usuario_logado_correctamente_en_hercules_con_usuario_y_contrasenia(String usuario, String password) {
		navega.aLogin();
		 logarse.conUsuarioYpassword(usuario, password);

	}

	@When("el usuario se dirige a la pantalla Documentacion-Empleado puesto")
	public void el_usuario_se_dirige_a_la_pantalla_documentacion_empleado_puesto() {
		 rutaParaIrAsociacionEmpleadoPuesto.accede();
	}

	@When("el usuario realiza una busqueda por evaluacion {string}")
	public void el_usuario_realiza_una_busqueda_por_evaluacion(String evaluacion) {
		 realizaBusqueda.porEvaluacion(evaluacion);
	}

	@When("el usuario genera la documentacion con al menos un trabajador seleccionado  {string}")
	public void el_usuario_genera_la_documentacion_con_al_menos_un_trabajador_seleccionado(String lote) {
		 generaDocumentacion.conLote(lote);

	}

	@When("el usuario se dirige a bandeja de salida se encuentra la documentacion generada")
	public void el_usuario_se_dirige_a_bandeja_de_salida_se_encuentra_la_documentacion_generada() {
		 rutaParaIrBandejaDeSalida.accede();
	}

	@Then("el usuario se descarga el formulario de adiestramiento {string} {string} {string}")
	public void el_usuario_se_descarga_el_formulario_de_adiestramiento(String lote, String dni, String puesto) {
		 realizaDescarga.actualizarPagina();
		realizaDescarga.delFormularioDeAdiestramiento(lote, dni, puesto);
	}

	@Then("el usuario verifica que esta incluido el nombre del trabajador {string}")
	public void el_usuario_verifica_que_esta_incluido_el_nombre_del_trabajador(String nombreTrabajador) {
		String texto = LecturaPdf.leer();
		System.out.println("TEXTO: " +texto);
		boolean encontrado = LecturaPdf.contieneNombreTrabajador(texto, nombreTrabajador);
		assertTrue("debe coincidir el nombre del trabajador", encontrado);
	}

	@Then("el usuario verifica que esta incluido  el dni {string}")
	public void el_usuario_verifica_que_esta_incluido_el_dni(String dni) {
		String texto = LecturaPdf.leer();
		boolean encontrado = LecturaPdf.contieneDNI(texto, dni);
		assertTrue("debe coincidir el dni del trabajador", encontrado);
	}
*/
}

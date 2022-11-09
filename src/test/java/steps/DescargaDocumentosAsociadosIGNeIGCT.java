package steps;

import java.util.List;

import escritorio.RutaParaIrConsultaEvaluacion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
import modelo.Usuario;
import net.thucydides.core.annotations.Steps;


public class DescargaDocumentosAsociadosIGNeIGCT {

	private static int CONTADOR = 1;

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

	@Before("@boton1 or @boton2 or @igct")
	public void antes() {
		if (CONTADOR == 5) {
			CONTADOR = 1;
		}
	}

	@Given("^el usuario entra en Hercules$")
	public void el_usuario_entra_en_hercules() {
		navega.aLogin();
	}

	@Given("el usuario se logea correctamente")
	public void el_usuario_se_logea_correctamente(DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
	//	int totalColumnas = table.width();// 3
		// System.out.println("total columnas " + totalColumnas);
		// System.out.println("total filas " + rows.size());
		for (List<String> row : rows) {
			Usuario.agregar(new Usuario(row.get(0), row.get(1), row.get(2)));
		}

		logarse.conUsuarioYpassword(Usuario.usuarios.get(CONTADOR).nombre,
				Usuario.usuarios.get(CONTADOR).dni);
		System.out.println("CONTADOR " + CONTADOR);
	}

	@Given("el usuario se dirige a la pantalla Consulta Evaluacion")
	public void el_usuario_se_dirige_a_la_pantalla_consulta_evaluacion() {
		rutaParaIrConsultaEvaluacion.accede();
	}

	@Given("el usuario realiza la busqueda correctamente con la provincia, empresa y modelo de negocio")
	public void el_usuario_realiza_la_busqueda_correctamente_con_la_provincia_empresa_y_modelo_de_negocio(
			DataTable table) {
		List<List<String>> rows = table.asLists(String.class);
		for (List<String> row : rows) {
			ConsultaDeEvaluacion.agregar(new ConsultaDeEvaluacion(row.get(0), row.get(1), row.get(2)));
		
		}
		realizaBusqueda.rellenaFormulario(ConsultaDeEvaluacion.datos.get(CONTADOR).provincia,
				ConsultaDeEvaluacion.datos.get(CONTADOR).empresa,
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
		descargaIGN.seleccionarPestaniaGuiaNacionales();
	}

	@Then("el usuario pulsa el boton {string} y se descarga la documentacion Ins Guias Nacionales correctamente")
	public void el_usuario_pulsa_el_boton_y_se_descarga_la_documentacion_ins_guias_nacionales_correctamente(String boton) {
		if (boton.equalsIgnoreCase("boton1")) {
			descargaIGN.descargarConBoton1();
		} else if (boton.equalsIgnoreCase("boton2")) {
			descargaIGN.descargarConBoton2();
		}

	}
/////////////////	

	@When("el usuario selecciona la pestania Ins Guias Cliente Proyecto")
	public void el_usuario_selecciona_la_pestania_ins_guias_cliente_proyecto() {
		descargaIGCT.seleccionarPestaniaGuiaClienteProyecto();
	}

	@Then("el usuario se descarga la documentacion Ins.Guias Cliente Proyecto correctamente")
	public void el_usuario_se_descarga_la_documentacion_ins_guias_cliente_proyecto_correctamente() {
		descargaIGCT.descargarGuiaClienteProyecto();
	}

	@After("@boton1 or @boton2 or @igct")
	public void despues() {
		CONTADOR++;

	}

}

package steps;

import login.Navega;
import menu.Evaluaciones.ConsultaEvaluacion.RealizaBusqueda;
import menu.Evaluaciones.ConsultaEvaluacion.ResultadoDeLaBusqueda;
import menu.Evaluaciones.EdicionEvaluacion.SeleccionarPuestos;
import menu.Puestos.EdicionPuesto.DescargaIGN;
import escritorio.RutaParaIrConsultaEvaluacion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import login.Logarse;

import net.thucydides.core.annotations.Steps;

public class DescargarIGN_boton2Step {

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
	DescargaIGN descargaIGN;

	/*
	@Given("el usuario2 entra en Hercules")
	public void el_usuario2_entra_en_Hercules() {
		navega.aLogin();
	}

	@Given("el usuario2 se logea correctamente {string} {string}")
	public void el_usuario2_se_logea_correctamente(String usuario, String password) {

		logarse.conUsuarioYpassword(usuario, password);
	}

	@Given("el usuario2 se dirige a la pantalla Evaluaciones-Consulta")
	public void el_usuario2_se_dirige_a_la_pantalla_evaluaciones_consulta() {
		rutaParaIrConsultaEvaluacion.accede();
	}

	@When("el usuario2 se dirige a la pantalla Consulta Evaluacion")
	public void el_usuario2_se_dirige_a_la_pantalla_consulta_evaluacion() {
		rutaParaIrConsultaEvaluacion.accede();
	}

	@When("el usuario2 realiza la busqueda correctamente con la provincia {string}, empresa {string}  y modelo de negocio {string}")
	public void el_usuario2_realiza_la_busqueda_correctamente_con_la_provincia_empresa_y_modelo_de_negocio(
			String provincia, String empresa, String modeloNegocio) {
		realizaBusqueda.rellenaFormulario(provincia, empresa, modeloNegocio);
	}

	@When("el usuario2 accede a la pantalla Edicion Evalucion")
	public void el_usuario2_accede_a_la_pantalla_edicion_evalucion() {
		// mostrarResultadoBusqueda.hacerDobleClick();
		resultadoDeLaBusqueda.accedePantallaEdicionEvaluacion();
	}

	@When("el usuario2 accede a la la pantalla Edicion Puesto")
	public void el_usuario2_accede_a_la_la_pantalla_edicion_puesto() {
		// seleccionarPuestos.seleccionarPestania();
		// seleccionarPuestos.hacerDobleClick();
		seleccionarPuestos.accedeAlaPantallaEdicionPuesto();
	}

	@Then("el usuario2 se descarga la documentacion Ins Guias Nacionales correctamente")
	public void el_usuario2_se_descarga_la_documentacion_ins_guias_nacionales_correctamente() {
		// descargarIGN.seleccionarPestaniaGuiaNacionales();
		descargaIGN.descargarConBoton2();
	}
*/
}

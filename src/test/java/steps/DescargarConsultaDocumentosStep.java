package steps;

import login.Navega;
import menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.RealizaBusqueda;
import menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.ResultadosDeLaBusqueda;
import escritorio.RutaParaIrConsultaDeDocumentos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import login.Logarse;

import net.thucydides.core.annotations.Steps;

public class DescargarConsultaDocumentosStep {

    @Steps
    Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	RutaParaIrConsultaDeDocumentos rutaParaIrConsultaDeDocumentos;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	ResultadosDeLaBusqueda resultadosDeLaBusqueda;

	
	@Given("el usuario se logea de forma correcta con usuario: {string}, password: {string} y con el rol: {string}")
	public void el_usuario_se_logea_de_forma_correcta_con_usuario_password_y_con_el_rol(String usuario, String password, String string3) {
		navega.aLogin();
		logarse.conUsuarioYpassword(usuario, password);
	}
	@When("el usuario se dirige a la pantalla Documentacion->Coordiancion cliente->Consulta de Documentos")
	public void el_usuario_se_dirige_a_la_pantalla_documentacion_coordiancion_cliente_consulta_de_documentos() {
		 rutaParaIrConsultaDeDocumentos.accede();
	}
	@When("el usuario realiza una busqueda con el cliente: {string}")
	public void el_usuario_realiza_una_busqueda_con_el_cliente(String cliente) {
		realizaBusqueda.buscar(cliente);
	}
	@Then("se descarga la documentacion de consultas")
	public void se_descarga_la_documentacion_de_consultas() {
		resultadosDeLaBusqueda.descargar();
	}



}

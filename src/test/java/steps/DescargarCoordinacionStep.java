package steps;

import login.Navega;
import menu.Documentacion.CoordinacionCliente.Coordinacion.RealizaBusqueda;
import menu.Documentacion.CoordinacionCliente.Coordinacion.ResultadoDeLaBusqueda;
import menu.Documentacion.CoordinacionCliente.CoordinacionAcciones.RealizaLaDescarga;
import escritorio.RutaParaIrAcoordinacion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import login.Logarse;

import net.thucydides.core.annotations.Steps;

public class DescargarCoordinacionStep {

	@Steps 
	Navega navega;
	@Steps
     Logarse logarse;
	@Steps
	RutaParaIrAcoordinacion rutaParaIrAcoordinacion;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	ResultadoDeLaBusqueda resuladoDeLaBusqueda;
	@Steps
	RealizaLaDescarga realizaLaDescarga;
	
	
	@Given("el usuario entra en Hercules y se logea correctamente con usuario: {string}, password: {string} y con el rol: {string}")
	public void el_usuario_entra_en_hercules_y_se_logea_correctamente_con_usuario_password_y_con_el_rol(String usuario, String password, String string3) {
		navega.aLogin();
		logarse.conUsuarioYpassword(usuario, password);
	}
	@When("el usuario se dirige a la pantalla Coordinacion")
	public void el_usuario_se_dirige_a_la_pantalla_coordinacion() {
		 rutaParaIrAcoordinacion.accede();
	}
	@When("el usuario realiza la busqueda con el cliente: {string}")
	public void el_usuario_realiza_la_busqueda_con_el_cliente(String cliente) {
		realizaBusqueda.porCliente(cliente);
	}
	@Then("el usuario accede a la pantalla Coordinacion Acciones")
	public void el_usuario_accede_a_la_pantalla_coordinacion_acciones() {
		resuladoDeLaBusqueda.accedePantallaCoordinacionAcciones();
		
	}
	@Then("el usuiario se descarga la documentacion de coordinacion")
	public void el_usuiario_se_descarga_la_documentacion_de_coordinacion() {
		realizaLaDescarga.alPulsarBotonDescargar();
	}
	
	
	


}

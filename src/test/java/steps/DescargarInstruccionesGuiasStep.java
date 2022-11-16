package steps;

import java.util.Collection;

import escritorio.RutaParaIrInstrccionesGuias;
import login.Navega;
import menu.Herramientas.Administracion.InstruccionesGuias.RealizaBusqueda;
import menu.Herramientas.Administracion.InstruccionesGuias.RealizaDescarga;
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
import utiles.crearPdf.FactoriaPDF;

public class DescargarInstruccionesGuiasStep {

	@Steps 
	Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	RutaParaIrInstrccionesGuias rutaParaIrInstruccionesGuias;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	RealizaDescarga realizaDescarga;

	@Before()
	public void antes() {
		//reiniciamos los contadores
		AlmacenRutasDeCapturaPantalla.setValorRuta(4);
	}
		
	@Given("el usuario se logea en Hercules con usuario: {string}, password: {string} y con el rol: {string}")
	public void el_usuario_se_logea_en_hercules_con_usuario_password_y_con_el_rol(String usuario, String password, String string3) {
		navega.aLogin();
		logarse.conUsuarioYpassword(usuario, password);
	}
	@When("el usuario se dirige a la pantalla Instrucciones Guias")
	public void el_usuario_se_dirige_a_la_pantalla_instrucciones_guias() {
		 rutaParaIrInstruccionesGuias.accede();
	}
	@When("el usuario realiza una busqueda por {string}")
	public void el_usuario_realiza_una_busqueda_por(String buscar) {
		   realizaBusqueda.conElValor(buscar);
	}
	@Then("se descarga la documentacion Instrucciones Guias")
	public void se_descarga_la_documentacion_instrucciones_guias() {
		realizaDescarga.alPulsarIcono();
	}


@After()
public void guardar() {
	FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,	CapturaPantalla.CONTADOR_VUELTAS_APLICACION); 
       }
	



}

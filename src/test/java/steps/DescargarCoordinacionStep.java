package steps;

import login.Navega;
import menu.Documentacion.CoordinacionCliente.Coordinacion.RealizaBusqueda;
import menu.Documentacion.CoordinacionCliente.Coordinacion.ResultadoDeLaBusqueda;
import menu.Documentacion.CoordinacionCliente.CoordinacionAcciones.RealizaLaDescarga;

import java.util.Collection;

import escritorio.PageEscritorio;
import escritorio.NavegaAcoordinacion;
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
import utiles.esperas.Espera;

public class DescargarCoordinacionStep {

	
	private static int CONTADOR=1;
	private String rutaEscenario="";
	@Steps 
	Navega navega;
	@Steps
     Logarse logarse;
	@Steps
	NavegaAcoordinacion rutaParaIrAcoordinacion;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	ResultadoDeLaBusqueda resuladoDeLaBusqueda;
	@Steps
	RealizaLaDescarga realizaLaDescarga;
	

	@Before("@descargaDocumentacion")  //2 usuarios
	public void antes(Scenario scenario) {
		//reiniciamos los contadores NO ES NECESARIO USARLO, YA QUE SOLO HAY DOS USUARIOS QUE PROBAR
		//if(CONTADOR==3)CONTADOR=1;
		System.out.println("dentro before DescargarCoordinacionStep " + CapturaPantalla.CONTADOR_VUELTAS_APLICACION);
		Collection<String> etiquetas=scenario.getSourceTagNames();
		for(String esc: etiquetas) {
			rutaEscenario=esc;	
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		//AlmacenRutasDeCapturaPantalla.setValorRuta(2);
	}
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
	

@After("@descargaDocumentacion")
public void guardar() {
	FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,CONTADOR, this.rutaEscenario,TituloPortada.TITULO_DESCARGAR_COORDINACION,Descripcion.DESCRIPCION_DESCARGARCOORDINACION,Sprint.Sprint1);
	CONTADOR++;
	//reseteamos las rutas
	AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
	rutaEscenario="";

       }
	


}

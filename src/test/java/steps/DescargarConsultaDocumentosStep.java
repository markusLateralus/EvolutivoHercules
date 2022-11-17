package steps;

import login.Navega;
import menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.RealizaBusqueda;
import menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.ResultadosDeLaBusqueda;

import java.util.Collection;

import escritorio.NavegaAconsultaDeDocumentos;
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

public class DescargarConsultaDocumentosStep {
	private static int CONTADOR=1;
	private String rutaEscenario="";
    @Steps
    Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	NavegaAconsultaDeDocumentos rutaParaIrConsultaDeDocumentos;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	ResultadosDeLaBusqueda resultadosDeLaBusqueda;


	@Before("@descargaConsultaDocumentos")
	public void antes(Scenario escenario) {
		if(CONTADOR==5)CONTADOR=1;
		//if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==5)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1; //solo es un usuario
		
		Collection<String> etiquetas=escenario.getSourceTagNames();
		for(String esc: etiquetas) {
			rutaEscenario=esc;	
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		
		//AlmacenRutasDeCapturaPantalla.setValorRuta(1);
	}
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
		//realizaBusqueda.buscar(cliente);
	}
	@Then("se descarga la documentacion de consultas")
	public void se_descarga_la_documentacion_de_consultas() {
		//resultadosDeLaBusqueda.descargar();
	}

	@After("@descargaConsultaDocumentos")
	public void guardar() {
		FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,CONTADOR,rutaEscenario,TituloPortada.TITULO_DESCARGAR_CONSULTADOCUMENTOS,
				Descripcion.DESCRIPCION_DESCARGAR_CONSULTA_DOCUMENTACION,Sprint.Sprint1 );

		CONTADOR++;
		//reseteamos las rutas
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
		rutaEscenario="";
	      
	       }

}

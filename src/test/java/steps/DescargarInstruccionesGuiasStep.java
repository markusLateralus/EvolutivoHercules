package steps;

import java.util.Collection;
import java.util.List;

import escritorio.NavegaAinstrccionesGuias;
import login.Navega;
import menu.Herramientas.Administracion.InstruccionesGuias.RealizaBusqueda;
import menu.Herramientas.Administracion.InstruccionesGuias.RealizaDescarga;
import modelo.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import login.Logarse;

import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;

public class DescargarInstruccionesGuiasStep {
	
	private static int CONTADOR=1;
	private String rutaEscenario="";
	@Steps 
	Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	NavegaAinstrccionesGuias navegaAinstruccionesGuias;
	@Steps
	RealizaBusqueda realizaBusqueda;
	@Steps
	RealizaDescarga realizaDescarga;

	@Before("@descargaInstruccionesGuias")  //1 usuario
	public void antes(Scenario escenario) {
		//reiniciamos los contadores
				Collection<String> etiquetas=escenario.getSourceTagNames();
				for(String esc: etiquetas) {
					rutaEscenario=esc;	
				}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
	//	AlmacenRutasDeCapturaPantalla.setValorRuta(4);
	}
	@Given("el usuairo entra en Hercules estando logado")
	public void el_usuairo_entra_en_hercules_estando_logado(io.cucumber.datatable.DataTable dataTable) {
		navega.aLogin();
			List<List<String>> rows = dataTable.asLists(String.class);
		for (List<String> row : rows) {
			Usuario.agregar(new Usuario(row.get(0), row.get(1), row.get(2)));
		}
		
	logarse.rellenarUsuario(Usuario.usuarios.get(CONTADOR).nombre);
	logarse.rellenarPassword(Usuario.usuarios.get(CONTADOR).password);
	logarse.pulsarBotonLogin();

	}
	@Given("se dirige a la pantlla Instrucciones Guias")
	public void se_dirige_a_la_pantlla_instrucciones_guias() {
		navegaAinstruccionesGuias.accede();
	}
	@When("el usuario realiza una busqueda por {int}")
	public void el_usuario_realiza_una_busqueda_por(int busqueda) {
		  realizaBusqueda.conElValor(busqueda);
	}
	@Then("se descarga la documentacion Instrucciones Guias")
	public void se_descarga_la_documentacion_instrucciones_guias() {
		realizaDescarga.alPulsarIcono();
	}


@After("@descargaInstruccionesGuias")
public void guardar() {
	FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,CONTADOR,rutaEscenario,TituloPortada.TITULO_DESCARGAR_INSTRUCCIONESGUIAS,
	Descripcion.DESCRIPCION_INSTRUCCIONESGUIAS,Sprint.Sprint1 );

	rutaEscenario="";
       }
	



}

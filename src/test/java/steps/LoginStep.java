package steps;

import utiles.capturasPantallas.*;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.*;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import modelo.Usuario;
import org.junit.runners.ParentRunner;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import escritorio.VerificarNombreUsuario;
import escritorio.VerificarRol;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import login.Logarse;
import login.Navega;
import net.thucydides.core.annotations.Steps;


public class LoginStep {
	
	private static int CONTADOR=1;
	private String rutaEscenario="";
	
	
	@Steps 
	Navega navega;
	
	@Steps
	Logarse logarse;
	
	
	
	
	
	
	
	
	@Steps
	VerificarNombreUsuario verificarNombreUsuario;
	
	@Steps
	VerificarRol verificarRol;

	
	

	@Before()//"@loginCorrecto or @loginIncorrecto"
	public void antes(Scenario scenario) {
		AlmacenRutasDeCapturaPantalla.setValorRuta(7);
		
		//reiniciamos los contadores
		if(CONTADOR==5)CONTADOR=1;
		if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==5)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1;
		Collection<String> etiquetas=scenario.getSourceTagNames();
		for(String etiqueta: etiquetas) {
			rutaEscenario=etiqueta;	 //@loginIncorrecto
		}
		//AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		System.out.println("dentro before loginStep " + CapturaPantalla.CONTADOR_VUELTAS_APLICACION);
	}


	@Given("el usuario ingresa en la aplicacion Hercules")
	public void el_usuario_ingresa_en_la_aplicacion_hercules() {
		navega.aLogin();
	}
	@Given("escribe el nombre y escribe el password")
	public void escribe_el_nombre_y_escribe_el_password(DataTable dataTable) {
		/*List<List<String>> rows = dataTable.asLists(String.class);
			for (List<String> row : rows) {
				Usuario.agregar(new Usuario(row.get(0), row.get(1), row.get(2)));
			}
		
			
		logarse.rellenarUsuario(Usuario.usuarios.get(CONTADOR).nombre);
		logarse.rellenarPassword(Usuario.usuarios.get(CONTADOR).password);
*/
	}

	@Given("hace click en el boton Login")
	public void hace_click_en_el_boton_login() {
	//	logarse.pulsarBotonLogin();
	}
	@When("el usuario verifica su nombre")
	public void el_usuario_verifica_su_nombre() {
//		verificarNombreUsuario.verificarUsuario(string);	
			//assertEquals(string, pageLogin.getNombre(), "debe coincidir el nombre de usuario");
	}
	@Then("el usuario verifica su rol")
	public void el_usuario_verifica_su_rol() {
	    
	}
	/////////////////////////////////login incorrecto
	
	@When("el usuario introduce mal los datos")
	public void el_usuario_introduce_mal_los_datos() {
	    System.out.println("estamos con el escnario login incorrecto");
	}
	@Then("el usuario no accede a Hercules")
	public void el_usuario_no_accede_a_hercules() {
	    
	}
	

@After()//"@loginCorrecto or @loginIncorrecto"
public void guardar(Scenario escenario) {
	//FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,	CapturaPantalla.CONTADOR_VUELTAS_APLICACION,rutaEscenario,TituloPortada.TITULO_LOGIN,
		//	Descripcion.DESCRIPCION_LOGIN,Sprint.Sprint1 );
	CapturaPantalla.CONTADOR_VUELTAS_APLICACION++;
	CONTADOR++;
	//reseteamos las rutas
	//AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
	rutaEscenario="";
	
      
       }
	


}


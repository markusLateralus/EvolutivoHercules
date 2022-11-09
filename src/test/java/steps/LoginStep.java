package steps;

import utiles.capturasPantallas.*;
import utiles.pdf.*;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import escritorio.VerificarNombreUsuario;
import escritorio.VerificarRol;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import login.Navega;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.FailureRerunner;
import net.thucydides.core.annotations.Steps;

public class LoginStep {
	

	
	@Steps 
	Navega navega;
	
	@Steps
	Logarse logarse;
	
	@Steps
	VerificarNombreUsuario verificarNombreUsuario;
	
	@Steps
	VerificarRol verificarRol;

	Scenario s;
	Collection<String>tags;
	
@Before()
public void antes(Scenario s) {
	AlmacenRutasDeCapturaPantalla.setValorRuta(3);
	s=s;
	System.out.println("ESCENARIO:" + s.getName()); //TITULO DEL ESCENARIO
	System.out.println("HA FALLADO" +s.isFailed());
	System.out.println("LINEA" +s.getLine()); //DEVUELVE LA LINEA DONDE SE DEFINEN LOS VALORES DE LA TABLA DE EXAMPLES
	tags=s.getSourceTagNames();
	System.out.println("tamanio"  + tags.size());
	for(String tag:tags) {
		System.out.println("tag" + tag);
	}
}

	@Given("yo como usuario quiero ingresar en la aplicacion Hercules")
	public void yo_como_usuario_quiero_ingresar_en_la_aplicacion_hercules() {
		navega.aLogin();
		 
		
	}
	@Given("con el usuario {string} en el campo usuario")
	public void con_el_usuario_en_el_campo_usuario(String string) {
	//	logarse.rellenarUsuario(string);
		assertEquals(string, "marco", "no coinciden");
	}
	@Given("con la contrasenia {string} en el campo password")
	public void con_la_contrasenia_en_el_campo_password(String string) {
		//logarse.rellenarPassword(string);
	}
	@When("se hace click en el boton {string}")
	public void se_hace_click_en_el_boton(String string) {
	//	logarse.pulsarBotonLogin();;
	}
	@Then("verifico  que aparece mi nombre completo: {string}")
	public void verifico_que_aparece_mi_nombre_completo(String string) {
	//	verificarNombreUsuario.verificarUsuario(string);	
		//assertEquals(string, pageLogin.getNombre(), "debe coincidir el nombre de usuario");
	}
	@Then("verifico que mi rol es {string}")
	public void verifico_que_mi_rol_es(String string) {
	//	 verificarRol.verificarRol(string);
	

	}

@After()
public void guardar(Scenario s) {
	FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,CapturaPantalla.CONTADOR_VUELTAS_APLICACION);
	CapturaPantalla.CONTADOR_VUELTAS_APLICACION++;
	
	s=s;

	System.out.println("HA FALLADO despues " +s.isFailed());


}

}


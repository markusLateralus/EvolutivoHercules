package login;

import java.time.Duration;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;


public class Logarse extends UIInteractionSteps {

//	private PageLogin pageLogin;
	Espera espera=new Espera();
	
	 @Step("el usuario escribe su usuario {usuario}, su password {password} y pulsa el boton Login")
	    public void conUsuarioYpassword(String usuario, String password) {
	    	this.rellenarUsuario(usuario);
	    	this.rellenarPassword(password);
		    this.pulsarBotonLogin();
			Espera.espera(2000);
	 }
	 
	    
		// @Step("escribo el nombre en el campo Usuario {usuario}")
	    public void rellenarUsuario(String usuario) {
	    
		    Espera.espera(1000);
	   // 	espera.queSeaSeleccionado(Duration.ofSeconds(15),  PageLogin.campoUsuario);
	        PageLogin.campoUsuario.sendKeys(usuario + Keys.ENTER);
	        AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario rellena el campo usuario" ,"EscribirUsuario");
	 }
	 
	// @Step("escribo la contrasenia en el campo password {pass}")
	    public void rellenarPassword(String pass) {
		 Espera.espera(1000);
	        PageLogin.campoPassword.sendKeys(pass + Keys.ENTER);
	        AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario rellena el campo password", "EscribirPassword");	        
	 }
	
		// @Step("escribo la contrasenia en el campo password {pass}")
	    public void pulsarBotonLogin() {
	    	//Espera.espera(1000);
	   	 espera.queSeaVisible(Duration.ofSeconds(15), PageLogin.botonLogin);
	        PageLogin.botonLogin.click();
	    }
}

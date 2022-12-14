package menu.Documentacion.CoordinacionCliente.Coordinacion;

import java.time.Duration;

import org.openqa.selenium.Keys;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

PageCoordinacion coordinacion;
	private Espera espera=new Espera();
	
    @Step("El usuario busca el cliente {0}")
    public void porCliente(String cliente) {
    	this.rellenarCampoCliente(cliente);
    	this.pulsarBotonBuscar();
    }
	

	
	 @Step("El usuario rellena el campo cliente con el nombre {0}")
	    private void rellenarCampoCliente(String cliente) {
		 espera.queSeaVisible(Duration.ofSeconds(15), PageCoordinacion.CAMPO_CLIENTE);
		 PageCoordinacion.CAMPO_CLIENTE.sendKeys(cliente);
		 Espera.obligatoriamente(1500);
		 PageCoordinacion.CAMPO_CLIENTE.sendKeys(Keys.ENTER);
	 }
	 
	 @Step("El usuario pulsa el boton buscar")
	 private void pulsarBotonBuscar() {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageCoordinacion.BOTON_BUSCAR);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==2) {
		      AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario realiza la búsqueda", "buscarCoordinacion");
		}
		 PageCoordinacion.BOTON_BUSCAR.click();
	 }
	
}

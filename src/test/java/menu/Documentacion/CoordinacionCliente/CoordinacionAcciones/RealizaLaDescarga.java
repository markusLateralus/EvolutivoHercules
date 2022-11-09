package menu.Documentacion.CoordinacionCliente.CoordinacionAcciones;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

import menu.Documentacion.CoordinacionCliente.Coordinacion.PageCoordinacion;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaLaDescarga extends UIInteractionSteps {

PageCoordinacionAcciones pageCoordinacionAcciones;
	private Espera espera=new Espera();
	
	 @Step("El usuario accede a la pantalla Coordinadición Acciones")
	    public void alPulsarBotonDescargar() {
		 this.descargar();
		 
	 }
	
	 @Step("El usuario se descarga la documentacion de coordinacion")
	    private void descargar() {
		 espera.queSeaclicable(Duration.ofSeconds(15), PageCoordinacionAcciones.BOTON_DESCARGAR);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==2) {
		      AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga la documentacion de coordinacion", "descargarDocumentacion");
		}
		 PageCoordinacionAcciones.BOTON_DESCARGAR.click();
		 Espera.espera(3000);
		 
	 }
	 

}

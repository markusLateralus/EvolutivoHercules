package menu.Documentacion.PublicacionesPendientes;

import java.time.Duration;
import org.openqa.selenium.Keys;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

PagePublicacionPendiente publicacionPendiente;
	private Espera espera=new Espera();
	 @Step("El usuario busca en el campo ID el valor {0}")
	    public void porID(String busqueda) {
		 espera.queSeaClicable(Duration.ofSeconds(15), PagePublicacionPendiente.CAMPO_ID);
		 PagePublicacionPendiente.CAMPO_ID.sendKeys(busqueda);
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario realiza la búsqueda en el buscador" ,"Escribir campo id");
			}
		 espera.queSeaClicable(Duration.ofSeconds(10), PagePublicacionPendiente.CHECKBOX);
		 PagePublicacionPendiente.CHECKBOX.click();
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario pincha en el checkbox del resultado de la busqueda" ,"pincharCheckbox");
			}
	
		 espera.queSeaClicable(Duration.ofSeconds(10), PagePublicacionPendiente.BOTON_PUBLICAR);
		 PagePublicacionPendiente.BOTON_PUBLICAR.click();
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario pulsa el botón PUBLICAR" ,"pulsarBotonPublicar");
			}
	
		
	 }
	 
	 @Step("El usuario guarda los cambios")
	 public void guardarCambios() {
		 espera.queSeaClicable(Duration.ofSeconds(10), PagePublicacionPendiente.BOTON_ACEPTAR);
		 PagePublicacionPendiente.BOTON_ACEPTAR.click();
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario pulsa el botón ACEPTAR" ,"pulsarBotonAceptar");
			}
		 
		 Espera.obligatoriamente(5000);
	 }
	
	
}

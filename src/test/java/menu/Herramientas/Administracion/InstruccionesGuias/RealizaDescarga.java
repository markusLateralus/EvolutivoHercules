package menu.Herramientas.Administracion.InstruccionesGuias;

import java.time.Duration;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaDescarga extends UIInteractionSteps {

PageInstrucionesGuia instruccionesGuia;
	private Espera espera=new Espera();
	

	 @Step("El usuario se descarga la documentacion de Instrucciones Guias")
	    public void alPulsarIcono() {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageInstrucionesGuia.BOTON_DESCARGAR);
		 PageInstrucionesGuia.BOTON_DESCARGAR.click();
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==4) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario se descarga la documentacion de Instrucciones guías" ,"DescargarDocumentacion");
			}
		 Espera.obligatoriamente(2000);

		 
	 }
	 

}

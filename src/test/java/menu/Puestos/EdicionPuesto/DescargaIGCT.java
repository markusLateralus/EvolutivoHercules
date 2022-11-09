package menu.Puestos.EdicionPuesto;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.functions.ExpectedCondition;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class DescargaIGCT extends UIInteractionSteps {

	private PageEdicionPuesto pageEdicionPuesto;
	private Espera espera=new Espera();
	
	@Step("El usuario se descarga la Ins Guias Cliente-Proyecto")
	public void descargarGuiaClienteProyecto() {
		//this.seleccionarPestaniaGuiaClienteProyecto();
		this.descargarDocumentacionIGCT();
	}
	
	 @Step("El usuario selecciona la pestaña Ins Guias Cliente Proyecto")
	    public void seleccionarPestaniaGuiaClienteProyecto() {
		 espera.queSeaVisible(Duration.ofSeconds(30), PageEdicionPuesto.pestaniaIGCT);
		// pageEdicionPuesto.waitFor(ExpectedConditions.elementToBeSelected(element));
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario selecciona la pestaña Ins Guias Cliente Proyecto", "seleccionarPestaniaGuiaClienteProyecto");
		}
		 PageEdicionPuesto.pestaniaIGCT.click();
	 }
	 
	 @Step("El usuario se descarga el documento de la tabla")
	 private void descargarDocumentacionIGCT() {
		 espera.queSeaVisible(Duration.ofSeconds(10), PageEdicionPuesto.botonDESCARGAR_IGCT);
		 PageEdicionPuesto.botonDESCARGAR_IGCT.click();
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga la Ins Guias Cliente Proyecto", "descargarIGCT");
		}
		 Espera.espera(1000);
	 }
	 
	
}

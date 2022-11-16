package menu.Documentacion.AsociacionEmpleadoPuesto;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class GeneraDocumentacion extends UIInteractionSteps {

	PageAsociacionEmpleadoPuesto asociacionEmpleadoPuesto;
	private Espera espera = new Espera();
	@Step("El usuario genera la documentacion con el lote {lote} ")
	public void conLote(String lote) {
	//	Espera.espera(2000);
		this.seleccionarTrabajador();
	//	Espera.espera(2000);
		this.escribirCampoLote(lote);
	//	Espera.espera(2000);
		this.pulsarGenear();
	//	Espera.espera(2000);
		this.pulsarAceptar();
	}
	
	@Step("El usuario selecciona un trabajador")
	private void seleccionarTrabajador() {
		espera.queSeaclicable(Duration.ofSeconds(10), PageAsociacionEmpleadoPuesto.checkBoxDNI);
		PageAsociacionEmpleadoPuesto.checkBoxDNI.click();
	}
	
	@Step("El usuario rellena el campo Lote con el valor {lote}")
	private void escribirCampoLote(String lote) {
		espera.queSeaVisible(Duration.ofSeconds(15),PageAsociacionEmpleadoPuesto.campoNombreLote);
		PageAsociacionEmpleadoPuesto.campoNombreLote.sendKeys(lote);
	}

	@Step("El usuario pulsa el boton Generar")
	private void pulsarGenear() {
		espera.queSeaVisible(Duration.ofSeconds(15), PageAsociacionEmpleadoPuesto.botonGenerar);
	
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario pulsa el botón Generar","pulsarBotonGenerar");
		}
		Actions action =new Actions(getDriver());
		action.moveToElement(PageAsociacionEmpleadoPuesto.botonGenerar).click().build().perform();
		//PageAsociacionEmpleadoPuesto.botonGenerar.click();
		// Espera.espera(1500);
	}

	// VENTANA EMERGENTE INFORMACIÓN
	@Step("El usuario pulsa el boton Aceptar")
	private void pulsarAceptar() {
		espera.queSeaVisible(Duration.ofSeconds(15), PageAsociacionEmpleadoPuesto.botonAceptar);
		if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario pulsa el botón Aceptar" ,"pulsarBotonAceptar");
			}
		PageAsociacionEmpleadoPuesto.botonAceptar.click();
		// Espera.espera(1500);
	}

}

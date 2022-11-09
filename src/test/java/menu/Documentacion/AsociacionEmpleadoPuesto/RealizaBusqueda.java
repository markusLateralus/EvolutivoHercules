package menu.Documentacion.AsociacionEmpleadoPuesto;

import java.time.Duration;

import org.openqa.selenium.Keys;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

PageAsociacionEmpleadoPuesto asociacionEmpleadoPuesto;
	private Espera espera=new Espera();
	
	@Step("El usuario realiza la busqueda por evaluacion {evaluacion}")
	public void porEvaluacion(String evaluacion) {
		this.rellenarCampoEvaluacion(evaluacion);
		this.buscar();
	}
	
	 @Step("El usuario rellena el campo evaluacion {evaluacion}")
	    private void rellenarCampoEvaluacion(String evaluacion) {
		 espera.queSeaVisible(Duration.ofSeconds(15), PageAsociacionEmpleadoPuesto.campoBuscador);
		 PageAsociacionEmpleadoPuesto.campoBuscador.sendKeys(evaluacion);
		 PageAsociacionEmpleadoPuesto.campoBuscador.sendKeys(Keys.ENTER);
		 espera.implicitamente(3);
	 }
	 
	 @Step("El usuario pulsa el boton buscar")
	 private void buscar() {
	
		 espera.queSeaclicable(Duration.ofSeconds(20), PageAsociacionEmpleadoPuesto.botonBUSCAR);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7 ) {
			  AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario realiza la búsqueda", "realizarBusqueda");
		}
		 
		 PageAsociacionEmpleadoPuesto.botonBUSCAR.click();
		 espera.implicitamente(10);
	 }
	
}

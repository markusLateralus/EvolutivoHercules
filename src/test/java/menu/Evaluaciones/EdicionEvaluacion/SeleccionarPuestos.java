package menu.Evaluaciones.EdicionEvaluacion;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class SeleccionarPuestos extends UIInteractionSteps {

//	private PageEdicionEvaluacion pageEdicionEvaluacion;
	private Espera espera=new Espera();
	@Step("El usuario selecciona un puesto y accede a la pantalla Edicion Puesto ")
	public void accedeAlaPantallaEdicionPuesto() {
		this.seleccionarPestania();
		this.hacerDobleClick();
	}
	
	 @Step("El usuario selecciona la pestaña puestos")
	    private void seleccionarPestania() {
	
		 espera.queSeaclicable(Duration.ofSeconds(20), PageEdicionEvaluacion.PESTANIA_PUESTOS);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario selecciona la pestaña puestos", "seleccionarPuestos");
		}
		
		 PageEdicionEvaluacion.PESTANIA_PUESTOS.click();
	 }
	 
	 @Step("El usuario selecciona el primer puesto para acceder a su edicion")
	    private void hacerDobleClick() {
		 espera.queSeaclicable(Duration.ofSeconds(15),PageEdicionEvaluacion.PRIMER_VALOR_TABLA_PESTANIA_PUESTOS);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario selecciona el valor de la tabla", "seleecionarValorTabla");
		}
		 Actions action=new Actions(this.getDriver());
		 action.doubleClick(PageEdicionEvaluacion.PRIMER_VALOR_TABLA_PESTANIA_PUESTOS).perform();
		 Espera.espera(4000);
	 }
	 
	
}

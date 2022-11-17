package menu.Documentacion.CoordinacionCliente.Coordinacion;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class ResultadoDeLaBusqueda extends UIInteractionSteps {

//PageCoordinacion coordinacion;
	private Espera espera=new Espera();
	@Step("El usuario seleeciona un resultado de la busqueda y accede a la pantalla Coordinacion Acciones")
	public void accedePantallaCoordinacionAcciones() {
		this.hacerDobleClick();
	}
	
	@Step("El usaruio realiza doble click sobre el resultado")
	private void hacerDobleClick() {
		Actions action=new Actions(this.getDriver());
		espera.queSeaclicable(Duration.ofSeconds(15), PageCoordinacion.RESULTADO_BUSQUEDA);
		if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==2) {
		      AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario seleccona un resultado de la busqueda y accede a la pantalla Coordinacion Acciones", "seleccionarResultado");
		}
		action.doubleClick(PageCoordinacion.RESULTADO_BUSQUEDA).perform();
		Espera.espera(5000);
	}

	 

}

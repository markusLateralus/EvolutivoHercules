package menu.Evaluaciones.ConsultaEvaluacion;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class ResultadoDeLaBusqueda extends UIInteractionSteps {

	//private ResultadoBusqueda resultado;
	private Espera espera=new Espera();
	@Step("El usuario obtiene un resultado de la busqueda y accede a la pantalla Edicion Evaluacion")
	public void accedePantallaEdicionEvaluacion() {
		this.hacerDobleClick();
		 Espera.espera(6000);
	}
	
	 @Step("hacemos doble click en el primer resultado de la busqueda")
	    public void hacerDobleClick() {
		 espera.queSeaVisible(Duration.ofSeconds(20), PageConsultaEvaluacion.RESULTADO_BUSQUEDA);;
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==4 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario obtiene un resultado de la busqueda y accede a la pantalla Edicion Evaluacion", "irPantallaEdicionEvaluacion");
		}
		 Actions action=new Actions(this.getDriver());
		 action.doubleClick(PageConsultaEvaluacion.RESULTADO_BUSQUEDA).perform();

		 
	 }
	 

}

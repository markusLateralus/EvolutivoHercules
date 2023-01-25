package menu.Riesgos.ConsultaRiesgos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

	private  PageConsultaRiesgo pageConsultaRiesgo;
	private Espera espera=new Espera();
	
	@Step("el usuario realiza la busqueda por id {0}")
	public void porID(String id) {
		espera.queSeaClicable(Duration.ofSeconds(5), PageConsultaRiesgo.CAMPO_ID);
		PageConsultaRiesgo.CAMPO_ID.sendKeys(id);
		Espera.obligatoriamente(2000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario realiza la busqueda por id","buscarPorId");
				   }
		espera.queSeaClicable(Duration.ofSeconds(5), PageConsultaRiesgo.BOTON_BUSCAR);
		PageConsultaRiesgo.BOTON_BUSCAR.click();
	}
	
	@Step("el usuario selecciona el primer resultado de la busqueda")
	public void seleccionaResultadoBusqueda() {
		Espera.obligatoriamente(2000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario accede a la pantalla Edicion Riesgo","irEdicionRiesgo");
				   }
		espera.queSeaClicable(Duration.ofSeconds(5), PageConsultaRiesgo.PRIMER_RESULTADO_BUSQUEDA);
		PageConsultaRiesgo.PRIMER_RESULTADO_BUSQUEDA.click();
	}
}

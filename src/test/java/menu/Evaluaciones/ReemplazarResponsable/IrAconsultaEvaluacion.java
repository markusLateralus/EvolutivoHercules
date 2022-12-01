package menu.Evaluaciones.ReemplazarResponsable;

import org.openqa.selenium.WebElement;

import escritorio.PageEscritorio;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class IrAconsultaEvaluacion extends UIInteractionSteps{
	Espera espera = new Espera();

	@Step("El usuario accede a la pantalla Consulta Evaluaciones")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();
		Espera.obligatoriamente(2500);
		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.obligatoriamente(2000);
				if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}	

			if (enlace == PageEscritorio.CONSULTA_EVALUACION) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Consulta Evaluacion","irConsultaEvaluacion");
				
				}
				enlace.click();
			}

		}
	}
}

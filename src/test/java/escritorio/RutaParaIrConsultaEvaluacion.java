package escritorio;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class RutaParaIrConsultaEvaluacion extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a la Pantalla Consulta Evaluacion")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();

		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 3
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.EVALUACIONES) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 3 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4 ||AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona evaluaciones", "irEvaluaciones");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.CONSULTA_EVALUACION) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 3 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4 ||AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Consulta Evaluación","irConsultaEvaluacion");
				}
				enlace.click();
			}

		}
	}
}

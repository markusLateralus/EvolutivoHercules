package escritorio;

import java.time.Duration;

import org.openqa.selenium.WebElement;


import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class RutaParaIrAcoordinacion extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a la Pantalla Coordinacion")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();

		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				espera.queSeaclicable(Duration.ofSeconds(10), enlace);
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

			if (enlace == PageEscritorio.DOCUMENTACION) {
				espera.queSeaclicable(Duration.ofSeconds(10), enlace);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona documentacion", "irDocumentacion");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.COORDINACION_CLIENTE) {
				espera.queSeaclicable(Duration.ofSeconds(10), enlace);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Coordinación Cliente",
							"irCoordinacionCliente");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.COORDINACION) {
				espera.queSeaclicable(Duration.ofSeconds(10), enlace);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Coordinacion",
							"irCoordinacion");
				}
				enlace.click();
			}
		}
	}
}

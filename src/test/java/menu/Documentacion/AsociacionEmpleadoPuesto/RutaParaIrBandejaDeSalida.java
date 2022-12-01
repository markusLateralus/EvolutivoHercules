package menu.Documentacion.AsociacionEmpleadoPuesto;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import escritorio.PageEscritorio;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class RutaParaIrBandejaDeSalida extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a Bandeja De Salida")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();

		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 3
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.BANDEJA_DE_SALIDA) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Bandeja De Salida",
							"irBandejaDeSalida");
				}
				enlace.click();
			}
		}
	}
}

package escritorio;



import org.openqa.selenium.WebElement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class RutaParaIrEditarFichas extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a la Pantalla Editar Fichas")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();

		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.FICHAS) {
				Espera.espera(2000);
				if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Fichas", "irFichas");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.EDITAR_FICHAS) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Editar Fichas",
							"irEditarFichas");
				}
				enlace.click();
			}

		
		}
	}
}

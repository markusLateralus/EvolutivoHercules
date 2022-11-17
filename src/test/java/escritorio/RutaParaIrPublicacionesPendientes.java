package escritorio;



import org.openqa.selenium.WebElement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class RutaParaIrPublicacionesPendientes extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a la Pantalla Publicaciones Pendientes")
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

			if (enlace == PageEscritorio.DOCUMENTACION) {
				Espera.espera(2000);
				if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Documentacion", "irDocumentacion");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.PUBLICACIONES_PENDIENTES) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Publicaciones Pendientes",
							"irConsultaRiesgos");
				}
				enlace.click();
			}

		
		}
	}
}

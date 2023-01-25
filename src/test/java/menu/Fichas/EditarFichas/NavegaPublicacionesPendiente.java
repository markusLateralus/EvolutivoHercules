package menu.Fichas.EditarFichas;

import org.openqa.selenium.WebElement;

import escritorio.PageEscritorio;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class NavegaPublicacionesPendiente extends UIInteractionSteps{

	Espera espera = new Espera();
	AlmacenRutasDeCapturaPantalla almacenRutasDeCapturaPantalla;
	@Step("El usuario accede a la pantalla Publicaciones Pendientes")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();
		Espera.obligatoriamente(2500);
		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU_PRINCIPAL) {
				Espera.obligatoriamente(2000);
				if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}	
			
			if (enlace == PageEscritorio.DOCUMENTACION) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Documentacion","irDocumentacion");
				
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.PUBLICACIONES_PENDIENTES) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Publicaciones Pendientes","irPublicacionesPendientes");
				
				}
				enlace.click();
			}

			
		}
	}
}

package escritorio;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class NavegaAinstrccionesGuias extends UIInteractionSteps{

	Espera espera = new Espera();

	@Step("El usuario accede a la pantalla Instruccciones Guias")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();
		Espera.espera(2500);
		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.HERRAMIENTAS) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Herramientas", "irHerramientas");
					
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.ADMINISTRACION) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Administracion","irAdministracion");
				
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.INSTRUCCIONES_GUIAS) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Instrucciones Guias",
							"irInstruccionesGuias");
				}
				enlace.click();
			}
		}
	}
	
}

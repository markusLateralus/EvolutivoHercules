package escritorio;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class NavegaAadministracionUsuarios extends UIInteractionSteps{

	Espera espera = new Espera();

	@Step("El usuario accede a la pantalla Instruccciones Guias")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();
		Espera.obligatoriamente(2500);
		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.obligatoriamente(2000);
				if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}	
			
			if (enlace == PageEscritorio.HERRAMIENTAS) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Herramientas","irHerramientas");
				
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.ADMINISTRACION) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Administracion","irAdministracion");
				
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.SEGURIDAD) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Seguridad",
							"irSeguridad");
				}
				enlace.click();
			}
			if (enlace == PageEscritorio.USUARIOS) {
			Espera.obligatoriamente(2000);
			if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Usuarios",
						"irUsuarios");
			}
			enlace.click();
			}
		}
	}
	
}

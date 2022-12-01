package escritorio;


import org.openqa.selenium.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class NavegaAasociacionEmpleadoPuesto extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a la pantalla Asociacion Empleado Puesto")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();

		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.DOCUMENTACION) {
				Espera.obligatoriamente(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona documentacion", "irDocumentacion");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.ASOCIACION_EMPLEADO_PUESTO) {
				Espera.obligatoriamente(2000);
				if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Asociacion Empleado Puesto",
							"irAsociacionEmpleadoPuesto");
				}
				enlace.click();
				Espera.obligatoriamente(6000);
			}

			
		}
	}
}

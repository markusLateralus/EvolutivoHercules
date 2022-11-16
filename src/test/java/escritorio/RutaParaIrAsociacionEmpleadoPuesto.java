package escritorio;


import org.openqa.selenium.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class RutaParaIrAsociacionEmpleadoPuesto extends UIInteractionSteps {

	Espera espera = new Espera();

	@Step("El usuario accede a la pantalla Asociacion Empleado Puesto")
	public void accede() {
		PageEscritorio.cargarLosEnlaces();

		for (WebElement enlace : PageEscritorio.ENLACES) {

			if (enlace == PageEscritorio.MENU) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 3
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4
						|| AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede al Menu", "accederMenu");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.DOCUMENTACION) {
				Espera.espera(2000);
				if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona documentacion", "irDocumentacion");
				}
				enlace.click();
			}

			if (enlace == PageEscritorio.ASOCIACION_EMPLEADO_PUESTO) {
				Espera.espera(2000);
				if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Asociacion Empleado Puesto",
							"irAsociacionEmpleadoPuesto");
				}
				enlace.click();
				Espera.espera(6000);
			}

			
		}
	}
}

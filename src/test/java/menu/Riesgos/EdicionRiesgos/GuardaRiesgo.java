package menu.Riesgos.EdicionRiesgos;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class GuardaRiesgo extends UIInteractionSteps{

	PageEdicionRiesgo pageEdicionRiesgo;
	Espera espera;
	
	@Step("el usuario comprueba el boton guardar esta habilitado")
	public boolean verificaElEstadoDelBotonGuardar() {
		Espera.obligatoriamente(6000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario comprueba que el boton Guardar esta habilitado","botonGuardar");
				   }
		return PageEdicionRiesgo.BOTON_GUARDAR.isEnabled();
	}
}

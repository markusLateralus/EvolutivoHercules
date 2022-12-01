package menu.Evaluaciones.EdicionEvaluacion;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class Verifica extends UIInteractionSteps{

	PageEdicionEvaluacion pageEdicionEvaluacion;
	
	@Step("El usuario verifica que el id {0} es un cliente suyo")
	public boolean queElClienteEsDelUsuario(String id) {
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			   AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario verifica que el id pertenece a un cliente suyo","verificaId");
		   }
		return id.contains(this.obtenerValorCampoId());
	}
	
	
	private String obtenerValorCampoId() {
		
		return PageEdicionEvaluacion.CAMPO_ID_CLIENTE.getText();
	}
}

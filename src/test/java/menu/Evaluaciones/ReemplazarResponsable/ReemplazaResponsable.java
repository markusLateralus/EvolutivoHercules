package menu.Evaluaciones.ReemplazarResponsable;

import java.time.Duration;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class ReemplazaResponsable extends UIInteractionSteps{

	PageReemplazarResponsable reemplazarResponsable;
	Espera espera;
	@Step("el usuario escribe el responsable a reemplazar: {0}")
	public void seleccionaResponsableAreemplazar(String responsableAntiguo) {
	
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.CAMPO_RESPONSABLE_A_REEMPLAZAR);
		PageReemplazarResponsable.CAMPO_RESPONSABLE_A_REEMPLAZAR.sendKeys(responsableAntiguo);
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.DESPLEGABLE_CAMPO_RESPONSABLE_A_REEMPLAZAR);
		PageReemplazarResponsable.DESPLEGABLE_CAMPO_RESPONSABLE_A_REEMPLAZAR.click();
		Espera.obligatoriamente(2000);
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario escribe el responsable a reemplazar", "responsableAntiguo");
		}
		Espera.obligatoriamente(4000);
	}
	
	@Step("el usuario selecciona el id: {0}")
	public void seleccionaID(String string) {
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.CASILLA_VERIFICACION_ID);
		PageReemplazarResponsable.CASILLA_VERIFICACION_ID.click();
		Espera.obligatoriamente(2000);
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona el id ", "seleccionaID");
		}
		
	}

	@Step("el usuario selecciona el nuevo responsable: {0}")
	public void seleccionaResponsableNuevo(String string) {
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.CAMPO_RESPONSABLE_NUEVO);
		PageReemplazarResponsable.CAMPO_RESPONSABLE_NUEVO.sendKeys(string);
		Espera.obligatoriamente(2000);
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.DESPLEGABLE_CAMPO_RESPONSABLE_NUEVO);
		PageReemplazarResponsable.DESPLEGABLE_CAMPO_RESPONSABLE_NUEVO.click();;
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona el nuevo responsable ", "nuevoResponsable");
		}
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.ICONO_CON_DOS_PERSONAS);
		PageReemplazarResponsable.ICONO_CON_DOS_PERSONAS.click();
		Espera.obligatoriamente(2000);
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario guarda los cambios ", "guardarCambios");
		}
		
		
	}

	@Step("el usuario guarda los cambios")
	public void guardarCambios() {
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario pulsa el boton aceptar ", "pulsarBotonAceptar");
		}
		espera.queSeaClicable(Duration.ofSeconds(5), PageReemplazarResponsable.BOTON_ACEPTAR);
		PageReemplazarResponsable.BOTON_ACEPTAR.click();
		Espera.obligatoriamente(12000);
		
	}
}

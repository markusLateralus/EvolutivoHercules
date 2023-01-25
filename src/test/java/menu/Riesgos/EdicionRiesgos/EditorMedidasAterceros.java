package menu.Riesgos.EdicionRiesgos;

import java.time.Duration;

import org.openqa.selenium.Keys;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class EditorMedidasAterceros extends UIInteractionSteps{

	
	PageEdicionRiesgo pageEdicionRiesgo;
	Espera espera;
	
	@Step("el usuario abre el nuevo editor de texto")
	public void abrir() {
		espera.queSeaClicable(Duration.ofSeconds(10), PageEdicionRiesgo.BOTON_MEDIDAS_TERCEROS);
		PageEdicionRiesgo.BOTON_MEDIDAS_TERCEROS.click();
		Espera.obligatoriamente(2000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario abre el editor de texto MEDIDAS A TERCEROS","abrirEditorTexto");
				   }
	}
	
	@Step("el usuario agrega una imagen")
	public void agregarImagen() {
		
	}
	
	@Step("el usuario agrega texto")
	public void agregarTexto(String texto) {
		espera.queSeaClicable(Duration.ofSeconds(10), PageEdicionRiesgo.HOJA);
		PageEdicionRiesgo.HOJA.sendKeys(Keys.ENTER);
		Espera.obligatoriamente(3000);
		PageEdicionRiesgo.HOJA.sendKeys(texto);
		Espera.obligatoriamente(2000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario escribe en el editor","escribirEditorTexto");
				   }
	}
	
	@Step("el usuario pulsa el boton ACEPTAR")
	public void aceptarCambios() {
		Espera.obligatoriamente(2000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario pulsa el boton ACEPTAR","pulsarBotonAceptar");
				   }
		espera.queSeaClicable(Duration.ofSeconds(10), PageEdicionRiesgo.BOTON_ACEPTAR);
		PageEdicionRiesgo.BOTON_ACEPTAR.click();
	}
	
	@Step("el usuario guarda los cambios")
	public void guardarCambios() {
		Espera.obligatoriamente(2000);
		 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario guarda los cambios","guardarCambios");
				   }
		espera.queSeaClicable(Duration.ofSeconds(10), PageEdicionRiesgo.BOTON_GUARDAR);
		PageEdicionRiesgo.BOTON_GUARDAR.click();
	}
}

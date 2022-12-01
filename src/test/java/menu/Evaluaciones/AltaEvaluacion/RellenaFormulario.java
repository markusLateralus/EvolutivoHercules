package menu.Evaluaciones.AltaEvaluacion;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RellenaFormulario extends UIInteractionSteps {

	private PageAltaEvaluacion pageAltaEvaluacion;
	private Espera espera=new Espera();
	
	//NO ESTA USADO ESTE METODO NI LA CLASE
	@Step("El usuario rellena el formulario")
	public void conTodosLosDatos(String provincia, String modeloNegocio, String empresa, String lineaVenta, String lugarPrestacionDeServicio
			, String actividadContratada, String tecnico, String responsableDeContrato, String responsableDeControlPeriodico, String fechaInicioContrato) {
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_PROVINCIA);
	PageAltaEvaluacion.CAMPO_PROVINCIA.sendKeys(provincia + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_MODELO_NEGOCIO);
	PageAltaEvaluacion.CAMPO_MODELO_NEGOCIO.sendKeys(modeloNegocio + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_EMPRESA);
	PageAltaEvaluacion.CAMPO_EMPRESA.sendKeys(empresa + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_LINIA_VENTA);
	PageAltaEvaluacion.CAMPO_LINIA_VENTA.sendKeys(lineaVenta + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_LUGAR_DE_PRESTACION_DE_SERVICIO);
	PageAltaEvaluacion.CAMPO_LUGAR_DE_PRESTACION_DE_SERVICIO.sendKeys(lugarPrestacionDeServicio + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_ACTIVIDAD_CONTRATADA);
	PageAltaEvaluacion.CAMPO_ACTIVIDAD_CONTRATADA.sendKeys(actividadContratada + Keys.ENTER);
	Espera.obligatoriamente(3000);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_TECNICO);
	PageAltaEvaluacion.CAMPO_TECNICO.sendKeys(tecnico);
	Espera.obligatoriamente(2000);
	PageAltaEvaluacion.CAMPO_TECNICO.sendKeys(Keys.ENTER );
	Espera.obligatoriamente(3000);
//	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.DESPLEGABLE_TECNICO);
//	PageAltaEvaluacion.DESPLEGABLE_TECNICO.click();
	//Espera.obligatoriamente(3000);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_RESPONSABLE_DE_CONTRATO);
	PageAltaEvaluacion.CAMPO_RESPONSABLE_DE_CONTRATO.sendKeys(responsableDeContrato + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_RESPONSABLE_DE_CONTROL_PERIODICO);
	PageAltaEvaluacion.CAMPO_RESPONSABLE_DE_CONTROL_PERIODICO.sendKeys(responsableDeControlPeriodico + Keys.ENTER);
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_FECHA_INICIO_CONTRATO);
	PageAltaEvaluacion.CAMPO_FECHA_INICIO_CONTRATO.sendKeys(fechaInicioContrato + Keys.ENTER);
	Espera.obligatoriamente(2000);
	if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
		AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario rellena el formulario", "formularioRellenado");
	}
	Espera.obligatoriamente(7000);
	}
	
}

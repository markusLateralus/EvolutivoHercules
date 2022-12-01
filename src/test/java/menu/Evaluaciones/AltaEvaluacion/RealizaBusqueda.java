package menu.Evaluaciones.AltaEvaluacion;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import menu.Documentacion.AsociacionEmpleadoPuesto.PageAsociacionEmpleadoPuesto;
import utiles.JS.JavaS;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

	private PageAltaEvaluacion pageAltaEvaluacion;
	private Espera espera=new Espera();
	private JavaS javaS;
	private boolean esVisible;
	@Step("El usuario busca el cliente {0}")
	public void porClienteAsignado(String cliente) {
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.ICONO_LUPA);
	PageAltaEvaluacion.ICONO_LUPA.click();
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.CAMPO_CLIENTE);
	PageAltaEvaluacion.CAMPO_CLIENTE.sendKeys(cliente);
	Espera.obligatoriamente(2000);
	if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
		AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario rellena el campo cliente", "rellenarCampoCliente");
	}
	Espera.obligatoriamente(3000);
	try{
	espera.queSeaClicable(Duration.ofSeconds(5), PageAltaEvaluacion.PRIMER_RESULTADO_DESPLEGABLE);
	esVisible=PageAltaEvaluacion.PRIMER_RESULTADO_DESPLEGABLE.isDisplayed();
	if(esVisible) {

	PageAltaEvaluacion.PRIMER_RESULTADO_DESPLEGABLE.click();
	Espera.obligatoriamente(2000);
	if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
		AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona el primer resultado de la busqueda", "elegirPrimerResultadoBusqueda");
	}
	Espera.obligatoriamente(2000);
	if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
		AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario pulsa el boton guardar", "pulsarBotonGuardar");
	}
	espera.queSeaClicable(Duration.ofSeconds(10), PageAltaEvaluacion.BOTON_ACEPTAR);
	javaS.hacerClick(PageAltaEvaluacion.BOTON_ACEPTAR);
	}
	}catch(TimeoutException e) {
		System.out.println("NO HAY RESULTADOS EN LA BUSQUEDA");
		 esVisible=false;
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
			  AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario comprueba que no hay resultados en la busqueda", "sinResultadosBusqueda");
		}
	}
	
	}
	
	
	 @Step("El usuario comprueba que existen resultados de la busqueda")
	 public boolean verificaSiHayResultadoEnLaBusqueda() {
	 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
		  AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario comprueba los resultados de la busqueda", "resultadosBusqueda");
	}
		return esVisible;
		}
	 
}

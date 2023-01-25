package menu.Fichas.EditarFichas;


import utiles.JS.JavaS;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

import java.time.Duration;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
public class Edita extends UIInteractionSteps{

	PageEditarFicha editarFicha;
	private Espera espera=new Espera();
	private JavaS javaS;
	
	@Step("El usuario selecciona la opción Editar Ficha y Borrador OK")
	public void guardaCambios() {
		 espera.implicitamente(35);
		espera.queSeaVisible(Duration.ofSeconds(5), PageEditarFicha.BOTON_ACCIONES);
		PageEditarFicha.BOTON_ACCIONES.click();
		Espera.obligatoriamente(1000);
		espera.queSeaClicable(Duration.ofSeconds(5), PageEditarFicha.DESPLEGABLE_EDITAR_FICHA);
		PageEditarFicha.DESPLEGABLE_EDITAR_FICHA.click();
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario selecciona la opcion Editar Ficha" ,"opcionEditarFicha");
			}
		 Espera.obligatoriamente(40000);//35 segundoos NO QUITAR
	
		 espera.queSeaClicable(Duration.ofSeconds(10), PageEditarFicha.BOTON_ACCIONES);
		javaS.hacerClick(PageEditarFicha.BOTON_ACCIONES);	
		 //PageEditarFicha.BOTON_ACCIONES.click();
			Espera.obligatoriamente(1000);
			espera.queSeaClicable(Duration.ofSeconds(5), PageEditarFicha.DESPLEGABLE_BORRADOR_OK);
			PageEditarFicha.DESPLEGABLE_BORRADOR_OK.click();
			 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
					AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario selecciona la opcion Borrador OK" ,"opcionBorradorOK");
				}
			 espera.queSeaClicable(Duration.ofSeconds(5), PageEditarFicha.BOTON_ACEPTAR);
				PageEditarFicha.BOTON_ACEPTAR.click();
				 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
						AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario pulsa el boton ACEPTAR" ,"pulsarBotonAceptar");
					}
				// Espera.obligatoriamente(35000);//35 segundoos NO QUITAR
				 espera.implicitamente(35);
	}
}

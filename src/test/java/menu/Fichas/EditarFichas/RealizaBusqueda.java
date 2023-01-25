package menu.Fichas.EditarFichas;

import java.time.Duration;
import org.openqa.selenium.Keys;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

PageEditarFicha editarFicha;
	private Espera espera=new Espera();
	 @Step("El usuario busca en el campo ID el valor {0}")
	    public void porID(String busqueda) {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageEditarFicha.CAMPO_ID);
		 PageEditarFicha.CAMPO_ID.sendKeys(busqueda);
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario realiza la búsqueda en el buscador" ,"Escribir campo id");
			}
		 espera.queSeaClicable(Duration.ofSeconds(10), PageEditarFicha.BOTON_BUSCAR);
		 PageEditarFicha.BOTON_BUSCAR.click();
	
	 }
	 
	 @Step("El usuario selecciona el primer resultado de la busqueda y accede a la pantalla Editar Ficha")
	 public void seleccionaPrimerResultado() {
		 espera.queSeaClicable(Duration.ofSeconds(10), PageEditarFicha.PRIMER_RESULTADO_BUSQUEDA);
		 PageEditarFicha.PRIMER_RESULTADO_BUSQUEDA.click();
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario selecciona el primer resultado de la busqueda" ,"primerResultado");
			}
		// Espera.obligatoriamente(35000);  //ojo son 35 segundos, no quitarlos
	
	 }
	 
	
	
}

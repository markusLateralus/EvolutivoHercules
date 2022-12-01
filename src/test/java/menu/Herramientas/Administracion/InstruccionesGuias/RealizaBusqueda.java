package menu.Herramientas.Administracion.InstruccionesGuias;

import java.time.Duration;
import org.openqa.selenium.Keys;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

PageInstrucionesGuia instruccionesGuia;
	private Espera espera=new Espera();
	 @Step("El usuario busca el valor {0} en el buscador")
	    public void conElValor(int busqueda) {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageInstrucionesGuia.CAMPO_BUSCADOR);
		 PageInstrucionesGuia.CAMPO_BUSCADOR.sendKeys(String.valueOf(busqueda));
		 Espera.obligatoriamente(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==4) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario realiza la búsqueda en el buscador" ,"EscribirEnBuscador");
			}
		 PageInstrucionesGuia.CAMPO_BUSCADOR.sendKeys(Keys.ENTER);
			
		 Espera.obligatoriamente(2);
	//   CapturarPantalla.guardarCapturaPantalla( CapturarPantalla.RUTA_IMAGEN_HERRAMIENTAS_ADMINISTRACION_INSTRUCIONESGUIAS,"Realizamos la búsqueda" ,"EscribirEnBuscador");

	 }
	 
	
	
}

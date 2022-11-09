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
	 @Step("El usuario realiza la busqueda {busqueda} en el buscador")
	    public void conElValor(String busqueda) {
		 espera.queSeaclicable(Duration.ofSeconds(15), PageInstrucionesGuia.CAMPO_BUSCADOR);
		 PageInstrucionesGuia.CAMPO_BUSCADOR.sendKeys(busqueda);
		 Espera.espera(1500);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==6) {
				AlmacenRutasDeCapturaPantalla.guardarRuta("El ususario realiza la búsqueda en el buscador" ,"EscribirEnBuscador");
			}
		 PageInstrucionesGuia.CAMPO_BUSCADOR.sendKeys(Keys.ENTER);
			
		 Espera.espera(2);
	//   CapturarPantalla.guardarCapturaPantalla( CapturarPantalla.RUTA_IMAGEN_HERRAMIENTAS_ADMINISTRACION_INSTRUCIONESGUIAS,"Realizamos la búsqueda" ,"EscribirEnBuscador");

	 }
	 
	
	
}

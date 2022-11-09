package menu.Documentacion.CoordinacionCliente.ConsultaDocumentos;

import java.time.Duration;
import org.openqa.selenium.Keys;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

PageConsultaDocumentos consulta;
	private Espera espera=new Espera();
	
	@Step("El usuario realiza una busqueda de cliente {cliente}")
	public void buscar(String cliente) {
		this.rellenarCampoCliente(cliente);
		this.pulsarEnBuscar();
	}
	 @Step("El usuario rellena el campo cliente {cliente}")
	    public void rellenarCampoCliente(String cliente) {
		 espera.queSeaVisible(Duration.ofSeconds(15), PageConsultaDocumentos.CAMPO_CLIENTE);
		 PageConsultaDocumentos.CAMPO_CLIENTE.sendKeys(cliente);
		 Espera.espera(1500);
		 PageConsultaDocumentos.CAMPO_CLIENTE.sendKeys(Keys.ENTER);
	 }
	 
	 @Step("El usuario pulsa el boton buscar")
	    public void pulsarEnBuscar() {
		 espera.queSeaclicable(Duration.ofSeconds(15), PageConsultaDocumentos.BOTON_BUSCAR);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==1 ) {
			  AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario realiza la búsqueda del cliente", "realizarBusqueda");
		}
		 
		 PageConsultaDocumentos.BOTON_BUSCAR.click();
	 }
	
}

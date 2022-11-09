package menu.Documentacion.CoordinacionCliente.ConsultaDocumentos;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class ResultadosDeLaBusqueda extends UIInteractionSteps {

PageConsultaDocumentos consulta;
	private Espera espera=new Espera();
	 @Step("El usuario se descarga la documentacion")
	    public void descargar() {
		 Actions action=new Actions(this.getDriver());
		 espera.queSeaclicable(Duration.ofSeconds(15), PageConsultaDocumentos.RESULTADO_BUSQUEDA);
			action.doubleClick(PageConsultaDocumentos.RESULTADO_BUSQUEDA).perform();	
			 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==1 ) {
				  AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga la documentación", "descargarDocumentacion");
			}
		 Espera.espera(5000);
		 
	 }
	 

}

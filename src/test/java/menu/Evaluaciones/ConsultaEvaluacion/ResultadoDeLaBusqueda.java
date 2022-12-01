package menu.Evaluaciones.ConsultaEvaluacion;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class ResultadoDeLaBusqueda extends UIInteractionSteps {

	//private ResultadoBusqueda resultado;
	private Espera espera=new Espera();
	@Step("El usuario obtiene un resultado de la busqueda y accede a la pantalla Edicion Evaluacion")
	public void accedePantallaEdicionEvaluacion() {
		this.hacerDobleClick();
		 Espera.obligatoriamente(6000);
	}
	
	 @Step("hacemos doble click en el primer resultado de la busqueda")
	    public void hacerDobleClick() {
		 espera.queSeaVisible(Duration.ofSeconds(20), PageConsultaEvaluacion.RESULTADO_BUSQUEDA);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==4 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario obtiene un resultado de la busqueda y accede a la pantalla Edicion Evaluacion", "irPantallaEdicionEvaluacion");
		}
		 Actions action=new Actions(this.getDriver());
		 action.doubleClick(PageConsultaEvaluacion.RESULTADO_BUSQUEDA).perform();

		 
	 }
	/////////////////////////////////////////////////////////////////////////////////////////////////////// 
	 
		@Step("El usuario obtiene un resultado de la busqueda y accede a la pantalla Edicion Evaluacion")
		public void seAccedePantallaEdicionEvaluacion() {
			 if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("el usuario accede a la pantalla Edicion Evaluacion","irEdicionEvaluacion");
			   }
			this.hacerDobleClickSobreElIdDelClienteUnico();
			 Espera.obligatoriamente(6000);
		}
		
	 @Step("hacemos doble click en el primer resultado de la busqueda")
	    private void hacerDobleClickSobreElIdDelClienteUnico() {
		 espera.queSeaVisible(Duration.ofSeconds(20), PageConsultaEvaluacion.RESULTADO_BUSQUEDA_POR_ID);
		 Actions action=new Actions(this.getDriver());
		 action.doubleClick(PageConsultaEvaluacion.RESULTADO_BUSQUEDA_POR_ID).perform();

		 
	 }
///////////////////////////////////////////////////////////////////////////
	 
	 @Step("el usuario verifica que se ha realizado correctamente el cambio de responsable")
	 public boolean verificaNombreResponsableControlPeriodico(String string) {
		 espera.queSeaVisible(Duration.ofSeconds(20), PageConsultaEvaluacion.CAMPO_RESPONSABLE_CONTROL_PERIODICO);
		 String nombreCompleto= PageConsultaEvaluacion.CAMPO_RESPONSABLE_CONTROL_PERIODICO.getText();
		 String apellido=nombreCompleto.substring(6);
		 String nombre=nombreCompleto.substring(0,6);
	
		 nombreCompleto="";
		 nombreCompleto=apellido+" , " +nombre.toUpperCase();
		 System.out.println("marocsssss    "  + nombreCompleto);
		 System.out.println("marocsssss    "  + string);
		 return string.contains(apellido);
	 }
}

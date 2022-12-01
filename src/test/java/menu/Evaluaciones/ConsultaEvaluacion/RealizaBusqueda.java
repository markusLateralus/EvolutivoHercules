package menu.Evaluaciones.ConsultaEvaluacion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class RealizaBusqueda extends UIInteractionSteps {

	private PageConsultaEvaluacion pageConsultaEvaluacion;
	private Espera espera=new Espera();
	
	@Step("El usuario rellena el formulario y realiza la busqueda")
	public void rellenaFormulario(String provincia, String empresa, String modeloNegocio) {
		this.rellenarCampoProvincia(provincia);
		this.rellenarCampoEmpresa(empresa);
		this.rellenarCampoModeloNegocio(modeloNegocio);
		this.rellenarCheckBox();
		this.pulsarEnBuscar();
	}
	
	 @Step("El usuario rellena el campo provincia con la provincia de {0}")
	    private void rellenarCampoProvincia(String provincia) {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageConsultaEvaluacion.CAMPO_PROVINCIA);
	        PageConsultaEvaluacion.CAMPO_PROVINCIA.sendKeys(provincia);
	        Espera.obligatoriamente(1000);
	        PageConsultaEvaluacion.CAMPO_PROVINCIA.sendKeys(Keys.ENTER);
	 }
	 
	 @Step("El usuario rellena el campo empresa con la empresa {0}")
	 private void rellenarCampoEmpresa(String empresa) {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageConsultaEvaluacion.CAMPO_EMPRESA);
	        PageConsultaEvaluacion.CAMPO_EMPRESA.sendKeys(empresa + Keys.ENTER);
	 }
	 @Step("El usuario rellena el campo Modelos de Negocio con {0}")
	 private void rellenarCampoModeloNegocio(String modeloNegocio) {
		 espera.queSeaClicable(Duration.ofSeconds(15), PageConsultaEvaluacion.CAMPO_MODELONEGOCIO);
	        PageConsultaEvaluacion.CAMPO_MODELONEGOCIO.sendKeys(modeloNegocio + Keys.ENTER);
	 }
	 @Step("El usuario selecciona el checkbox TODOS")
	 private void rellenarCheckBox() {
	        WebElement checkBox=pageConsultaEvaluacion.MAT.findElement(By.xpath("(//div[@class=\"mat-checkbox-inner-container\"])[1]"));
	        checkBox.click();
	        if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3) {
				 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario rellena el formulario", "RellenarFormulario");
			}
	 }
	 
	 @Step("El usuario pulsa el boton buscar")
	    private void pulsarEnBuscar() {
		 Espera.obligatoriamente(2000);
	        PageConsultaEvaluacion.BOTON_BUSCAR.click();
	 }
	 
	 
	 ///////////////////////////////////
	 
	 @Step("el usuario realiza la busqueda de cliente con el id {0} ")
	 public void porId(String id) {
	   if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
		   AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario realiza la busqueda del cliente","rellenaFormulario");
	   }
		 espera.queSeaClicable(Duration.ofSeconds(5), PageConsultaEvaluacion.CAMPO_IDeVALUACION);
		 PageConsultaEvaluacion.CAMPO_IDeVALUACION.sendKeys(id);
		 this.pulsarEnBuscar();
	 }
	 
}

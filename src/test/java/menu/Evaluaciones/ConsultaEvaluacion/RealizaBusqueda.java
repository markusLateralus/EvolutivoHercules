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
	
	@Step("El usuario rellena el campo provincia {provincia}, campo empresa {empresa}, campo modelo de negocio {modeloNegocio} y realiza la busqueda")
	public void rellenaFormulario(String provincia, String empresa, String modeloNegocio) {
		this.rellenarCampoProvincia(provincia);
		this.rellenarCampoEmpresa(empresa);
		this.rellenarCampoModeloNegocio(modeloNegocio);
		this.rellenarCheckBox();
		this.pulsarEnBuscar();
	}
	
	 @Step("El usuario rellena el campo provincia {provincia}")
	    private void rellenarCampoProvincia(String provincia) {
		 espera.queSeaclicable(Duration.ofSeconds(15), PageConsultaEvaluacion.CAMPO_PROVINCIA);
	        PageConsultaEvaluacion.CAMPO_PROVINCIA.sendKeys(provincia);
	        Espera.espera(1000);
	        PageConsultaEvaluacion.CAMPO_PROVINCIA.sendKeys(Keys.ENTER);
	 }
	 
	 @Step("El usuario rellena el campo empresa {empresa}")
	 private void rellenarCampoEmpresa(String empresa) {
		 espera.queSeaclicable(Duration.ofSeconds(15), PageConsultaEvaluacion.CAMPO_EMPRESA);
	        PageConsultaEvaluacion.CAMPO_EMPRESA.sendKeys(empresa + Keys.ENTER);
	 }
	 @Step("El usuario rellena el campo Modelos de Negocio {modeloNegocio}")
	 private void rellenarCampoModeloNegocio(String modeloNegocio) {
		 espera.queSeaclicable(Duration.ofSeconds(15), PageConsultaEvaluacion.CAMPO_MODELONEGOCIO);
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
		 Espera.espera(2000);
	        PageConsultaEvaluacion.BOTON_BUSCAR.click();
	 }
	 
}

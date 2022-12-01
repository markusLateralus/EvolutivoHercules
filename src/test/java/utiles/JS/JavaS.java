package utiles.JS;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.PageConsultaDocumentos;
import net.serenitybdd.core.pages.PageObject;

public class JavaS extends PageObject{

	
	public void hacerClick(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor) getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	//Actions action=new Actions(pageAltaEvaluacion.getDriver());
			//action.moveToElement(PageAltaEvaluacion.BOTON_ACEPTAR).click().build().perform();
	
	
	
	///doble click para realizar descarga
	// Actions action=new Actions(this.getDriver());
		//action.doubleClick(PageConsultaDocumentos.RESULTADO_BUSQUEDA).perform();	
}

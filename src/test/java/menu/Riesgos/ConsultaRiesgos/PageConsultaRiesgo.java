package menu.Riesgos.ConsultaRiesgos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageConsultaRiesgo extends PageObject{

	@FindBy(css="input[placeholder='-Id de Riesgo-']")
	static WebElement CAMPO_ID;
	
	@FindBy(css="mat-accordion[class='mat-accordion consulta'] button:nth-child(1) span:nth-child(1)")
	static WebElement BOTON_BUSCAR;
	
	@FindBy(css="td[class='cell-align-right ng-star-inserted'] span[class='ng-star-inserted']")
	static WebElement PRIMER_RESULTADO_BUSQUEDA;
	
}

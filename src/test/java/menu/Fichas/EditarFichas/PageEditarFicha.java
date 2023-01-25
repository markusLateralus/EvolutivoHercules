package menu.Fichas.EditarFichas;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageEditarFicha extends PageObject{

	@FindBy(css=".form-control.ng-untouched.ng-pristine.ng-invalid")
	static WebElement  CAMPO_ID;
	@FindBy(css="mat-accordion[class='mat-accordion consulta'] button:nth-child(1) span:nth-child(1)")
	static WebElement BOTON_BUSCAR;
	@FindBy(css="td[class='cell-align-right ng-star-inserted'] span[class='ng-star-inserted']")
	static WebElement PRIMER_RESULTADO_BUSQUEDA;
	@FindBy(xpath="(//span[normalize-space()='Acciones'])[1]")
	static WebElement BOTON_ACCIONES;
	
	@FindBy(xpath="(//a[normalize-space()='Editar ficha'])[1]")
	static WebElement DESPLEGABLE_EDITAR_FICHA;
	
	@FindBy(css="app-fichas-home[class='ng-star-inserted'] a:nth-child(1)")
	static WebElement DESPLEGABLE_BORRADOR_OK;
	@FindBy(css="div[class='cdk-overlay-container'] button:nth-child(1) span:nth-child(1)")
	static WebElement BOTON_ACEPTAR;
	
}

package menu.Evaluaciones.ReemplazarResponsable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageReemplazarResponsable extends PageObject{


	@FindBy(css="input[role='combobox']")
	static WebElement CAMPO_RESPONSABLE_A_REEMPLAZAR;
	
	@FindBy(css=".col-md-4")
	static WebElement DESPLEGABLE_CAMPO_RESPONSABLE_A_REEMPLAZAR;
	
	@FindBy(css="label[for='mat-checkbox-1-input'] div[class='mat-checkbox-inner-container']")
	static WebElement CASILLA_VERIFICACION_ID;
	
	@FindBy(css="input[class='ng-star-inserted']")
	static WebElement CAMPO_RESPONSABLE_NUEVO;
	@FindBy(xpath="//span[normalize-space()='Mansilla , Jaime']")
	static WebElement DESPLEGABLE_CAMPO_RESPONSABLE_NUEVO;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-evaluaciones-home:nth-child(3) > app-reemplazar-responsabilidades:nth-child(2) > div:nth-child(2) > mat-card:nth-child(1) > mat-card-content:nth-child(2) > app-reemplazar-tecnico:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")
	static  WebElement ICONO_CON_DOS_PERSONAS;
	@FindBy(css="div[class='cdk-overlay-container'] button:nth-child(1) span:nth-child(1)")
	static WebElement BOTON_ACEPTAR;
}

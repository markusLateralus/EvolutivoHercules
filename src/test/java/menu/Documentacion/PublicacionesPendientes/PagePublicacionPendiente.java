package menu.Documentacion.PublicacionesPendientes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PagePublicacionPendiente extends PageObject{

	@FindBy(css="input[placeholder='ID']")
	static WebElement CAMPO_ID;
	
	@FindBy(css="app-fichas-home[class='ng-star-inserted'] a:nth-child(1)")
	static WebElement DESPLEGABLE_EDITAR_FICHA;
	
	@FindBy(css="div[aria-checked='false']")
	static WebElement CHECKBOX;
	@FindBy(css="button[class='mat-focus-indicator mat-button mat-raised-button mat-button-base mat-primary'] span[class='mat-button-wrapper']")
	static WebElement BOTON_PUBLICAR;
	@FindBy(css="div[class='cdk-overlay-container'] button:nth-child(1) span:nth-child(1)")
	static WebElement BOTON_ACEPTAR;
	
}

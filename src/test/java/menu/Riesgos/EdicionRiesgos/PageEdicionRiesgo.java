package menu.Riesgos.EdicionRiesgos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageEdicionRiesgo extends PageObject{


	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-riesgos-home:nth-child(3) > app-alta-riesgos:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3) > span:nth-child(1)")
	static WebElement BOTON_GUARDAR;
	
	@FindBy(css="div[class='dialog display-inline-block col-md-4 col-lg-5 col-xl-3'] span[class='material-icons']")
	static WebElement BOTON_MEDIDAS;
	
	@FindBy(css="div[class='dialog display-inline-block col-md-6 col-lg-7 col-xl-5'] span[class='material-icons']")
	static WebElement BOTON_MEDIDAS_TERCEROS;
	@FindBy(css="#angular-editor-textarea-ID")
	static WebElement HOJA;
	
	@FindBy(css="div[class='cdk-overlay-container'] div[class='mat-dialog-actions'] button:nth-child(1) span:nth-child(1)")
	static WebElement BOTON_ACEPTAR;
}

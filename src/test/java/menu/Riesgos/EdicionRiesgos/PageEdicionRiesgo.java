package menu.Riesgos.EdicionRiesgos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageEdicionRiesgo extends PageObject{


	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-riesgos-home:nth-child(3) > app-alta-riesgos:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > button:nth-child(3) > span:nth-child(1)")
	static WebElement BOTON_GUARDAR;
	
}

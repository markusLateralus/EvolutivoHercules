package menu.Documentacion.CoordinacionCliente.CoordinacionAcciones;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;



public class PageCoordinacionAcciones extends PageObject{

	 @FindBy(id="download")
	 static WebElement BOTON_DESCARGAR;
}

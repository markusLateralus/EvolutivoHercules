package menu.Documentacion.CoordinacionCliente.CoordinacionAcciones;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;



public class PageCoordinacionAcciones extends PageObject{

	 @FindBy(xpath="(//div[@class=\"span-icon\"])[2]")
	 static WebElement BOTON_DESCARGAR;
}

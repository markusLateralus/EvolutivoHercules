package menu.Herramientas.Administracion.InstruccionesGuias;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageInstrucionesGuia extends PageObject{

	@FindBy(xpath="(//input[@role='combobox'])[1]")
	static WebElement CAMPO_BUSCADOR;
	
	@FindBy(xpath="(//span[@id='download'])[1]")
	static WebElement BOTON_DESCARGAR;
}

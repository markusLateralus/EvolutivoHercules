package menu.Documentacion.CoordinacionCliente.Coordinacion;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;



public class PageCoordinacion extends PageObject{

	@FindBy(xpath="(//input[@role='combobox'])[1]")
	static WebElement CAMPO_CLIENTE;
	@FindBy(xpath="(//span[normalize-space()='Buscar'])[1]")
	static WebElement BOTON_BUSCAR;
	@FindBy(xpath="(//span[normalize-space()='36066'])[1]")
	static WebElement RESULTADO_BUSQUEDA;

}

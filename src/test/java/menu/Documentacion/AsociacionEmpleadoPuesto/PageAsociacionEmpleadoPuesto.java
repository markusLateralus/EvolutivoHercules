package menu.Documentacion.AsociacionEmpleadoPuesto;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageAsociacionEmpleadoPuesto extends PageObject{

	@FindBy(id="idEvaluacion")
	static WebElement campoBuscador;
	@FindBy(xpath="//span[normalize-space()='Buscar']")
	static WebElement botonBUSCAR;
	@FindBy(xpath="(//input[@title='Seleccione para generar documentación'])[1]")
	static WebElement checkBoxDNI;
	
	
	@FindBy(xpath="(//span[normalize-space()='Generar'])[1]")
	public static WebElement botonGenerar;
	
	@FindBy(id="loteNombre")
	static WebElement campoNombreLote;
	@FindBy(xpath="(//span[normalize-space()='Aceptar'])[1]")
	public static WebElement botonAceptar;

	
}

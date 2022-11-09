package menu.Documentacion.BandejaDeSalida;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageBandejaDeSalida extends PageObject{

	@FindBy(xpath="(//table)[2]/tbody")
	static WebElement TABLA;
	
	@FindBy(xpath="(//span[normalize-space()='Refrescar'])[1]")
	static WebElement BOTON_REFRESCAR;
	//FILAS
	//static List<WebElement> ROWS=TABLA.findElements(By.tagName("tr"));
	
	
}

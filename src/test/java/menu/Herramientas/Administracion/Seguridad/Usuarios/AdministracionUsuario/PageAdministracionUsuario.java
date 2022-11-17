package menu.Herramientas.Administracion.Seguridad.Usuarios.AdministracionUsuario;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageAdministracionUsuario extends PageObject{

	@FindBy(css="input[placeholder='Rol']")
	static WebElement CAMPO_BUSCADOR_DE_ROL;
	
	@FindBy(xpath="(//span[normalize-space()='msanchezh'])[1]")
	static WebElement PRIMER_RESULTADO_DE_LA_TABLA;
	
	@FindBy(css=".mat-select-value.ng-tns-c76-6")
	static WebElement CAMPO_ROL;
}

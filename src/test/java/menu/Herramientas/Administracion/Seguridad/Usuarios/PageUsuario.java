package menu.Herramientas.Administracion.Seguridad.Usuarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageUsuario extends PageObject{

	@FindBy(css="input[placeholder='Rol']")
	static WebElement CAMPO_BUSCADOR_DE_ROL;
	
	@FindBy(xpath="(//span[normalize-space()='msanchezh'])[1]")
	static WebElement PRIMER_RESULTADO_DE_LA_TABLA;
	
	@FindBy(css=".mat-select-value.ng-tns-c76-6")
	static WebElement CAMPO_ROL;
	@FindBy(css="mat-option[id='mat-option-3'] span[class='mat-option-text']")
	static WebElement DESPLEGABLE_CAMPO_ROL;
	
	@FindBy(css=".material-icons.ng-tns-c257-4")
	static WebElement BOTON_CLIENTES;
	
	///////////ventana emergente AÑADIR CLIENTE
	@FindBy(css="input[role='combobox']")
	static WebElement CAMPO_CLIENTE;
	@FindBy(css="div[class='col-md-4']")
	static WebElement DESPLEGABLE_CAMPO_CLIENTE;
	@FindBy(css="button[id='btn-clientes'] span[class='mat-button-wrapper']")
	static WebElement BOTON_ANADIR;
	@FindBy(css="body > div:nth-child(10) > div:nth-child(2) > div:nth-child(1) > mat-dialog-container:nth-child(2) > app-ventana-cliente:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1) > span:nth-child(1)")
	static WebElement BOTON_ACTUALIZAR;
	@FindBy(css="button[type='button'] span[class='mat-button-wrapper']")
	static WebElement BOTON_SALIR;
	
	@FindBy(css="div[class='cdk-overlay-container'] td:nth-child(2)")
	static WebElement BOTON_ELIMINAR_CLIENTE;
	//@FindBy()
}

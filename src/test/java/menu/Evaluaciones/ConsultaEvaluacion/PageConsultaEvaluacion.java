package menu.Evaluaciones.ConsultaEvaluacion;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class PageConsultaEvaluacion extends PageObject{

    @FindBy(xpath="(//input[@role='combobox'])[1]")
    static WebElement CAMPO_PROVINCIA;
	@FindBy(xpath="(//div[@class=\"ng-input\"])[2]/descendant::input")
	static WebElement CAMPO_EMPRESA;
	@FindBy(xpath="(//div[@class=\"ng-input\"])[3]/descendant::input")
	static WebElement CAMPO_MODELONEGOCIO;
	
	
	@FindBy(id="mat-checkbox-1") WebElement MAT;//de aqui se coge despues el checkbox
	@FindBy(xpath="(//button[@class=\"mat-focus-indicator mat-button mat-raised-button mat-button-base mat-primary\"])[4]")	
	static WebElement BOTON_BUSCAR;
	
	@FindBy(xpath="(//span[normalize-space()='8803'])[1]")
	static WebElement RESULTADO_BUSQUEDA;
	
	////////////////////////////////////////////////////////////////////////////
	//ESTOS 2 COMPONENTES SE los pasamos a la PageEdicionEvaluacion
	@FindBy(id="mat-tab-label-0-1")
	public static WebElement PESTANIA_PUESTOS;
	@FindBy(xpath="(//span[normalize-space()='32166'])[1]")
	public static WebElement PRIMER_VALOR_TABLA_PESTANIA_PUESTOS; //la primera celda de la tabla de puestos
	///////////////////////////////////////////////////////////////////////////////////////
	// estos 5 componentes se lo pasamos a la PageEdicionPuesto //div[contains(text(),'Ins. Guías Nacionales')]
	@FindBy(xpath="//div[contains(text(),'Ins. Guías Nacionales')]")//div[contains(text(),'Ins. Guías Nacionales')])[1]
	public	static WebElement pestaniaIGN;
	@FindBy(xpath="(//span[contains(text(),'download')])[4]")
	public static WebElement botonDESCARGAR_1;
	@FindBy(xpath="(//span[contains(text(),'download')])[8]")
	public static WebElement botonDESCARGAR_2;
	
	@FindBy(xpath="(//div[contains(text(),'Ins. Guías Cliente/Proyecto')])[1]")
	public static WebElement pestaniaIGCT;
	@FindBy(xpath="(//span[@class='material-icons search-button ng-star-inserted'][normalize-space()='download'])[1]")
	public static WebElement botonDESCARGAR_IGCT;
	
	@FindBy(id="idEvaluacion")
	public static WebElement CAMPO_ID;
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@FindBy(css=".form-control.ng-untouched.ng-pristine.ng-invalid")
	static WebElement CAMPO_IDeVALUACION;
	@FindBy(xpath="(//span[normalize-space()='5055'])[1]")
	static WebElement RESULTADO_BUSQUEDA_POR_ID;
	
	//////////////////////////////////////////////////////////////////////////////
	@FindBy(xpath="(//span[normalize-space()='Jaime Mansilla'])[1]")
	static WebElement CAMPO_RESPONSABLE_CONTROL_PERIODICO;
}

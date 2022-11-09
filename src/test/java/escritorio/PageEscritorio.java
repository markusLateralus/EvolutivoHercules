package escritorio;


import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://prehercules.eulen.com/hercules3/mi-escritorio/escritorio")
public class PageEscritorio extends PageObject{



	@FindBy(xpath="//div[@class=\"row ng-star-inserted\"]")
	public static WebElement contenedor;
	@FindBy(xpath="//div[@class=\"row ng-star-inserted\"]/descendant::div[@class=\"col-4\"]")
	public static WebElement contenedorNombreCompleto;

	@FindBy(xpath="(//span[contains(text(),'menu')])[1]")
	public static WebElement MENU;
	@FindBy(xpath="//mat-icon[@class=\"mat-icon notranslate mat-icon-rtl-mirror material-icons mat-icon-no-color\"]")
	public static WebElement EVALUACIONES;
	@FindBy(xpath="(//button[@class=\"mat-focus-indicator mat-icon-button mat-button-base\"])[1]/following-sibling::div")
	public static WebElement CONSULTA_EVALUACION;
	
	
	
	@FindBy(xpath="(//div[normalize-space()='Documentación'])[1]")
	public static WebElement DOCUMENTACION;
	@FindBy(xpath="(//div[normalize-space()='Coordinación Cliente'])[1]")
	public static WebElement COORDINACION_CLIENTE;
	 @FindBy(xpath="(//div[normalize-space()='Consulta Documentos'])[1]")
	public static WebElement CONSULTA_DOCUMENTOS;
	
	@FindBy(xpath="(//div[normalize-space()='Coordinación'])[1]")
	public static WebElement COORDINACION;
	
	
	 @FindBy(xpath="(//div[normalize-space()='Herramientas'])[1]")
	 public  static WebElement HERRAMIENTAS;
	  @FindBy(xpath="(//div[normalize-space()='Administración'])[1]")
	public static WebElement ADMINISTRACION;
	  @FindBy(xpath="//div[normalize-space()='Instrucciones-Guías']")
	  public static WebElement INSTRUCCIONES_GUIAS;
	  
	  
	  //sprint3
	  @FindBy(xpath="(//div[normalize-space()='Asociación Empleado Puesto'])[1]")
	public static WebElement ASOCIACION_EMPLEADO_PUESTO;
	  @FindBy(xpath="(//div[normalize-space()='Bandeja de Salida'])[1]")
	  public static WebElement BANDEJA_DE_SALIDA;
	  
	  public static ArrayList <WebElement>ENLACES=new ArrayList<WebElement>();
	  public static void cargarLosEnlaces() {
		  ENLACES.add(MENU);
		  ENLACES.add(DOCUMENTACION);
		  ENLACES.add(COORDINACION_CLIENTE);
		  ENLACES.add(CONSULTA_DOCUMENTOS);
		  ENLACES.add(ASOCIACION_EMPLEADO_PUESTO);
		  ENLACES.add(HERRAMIENTAS);
		  ENLACES.add(COORDINACION);
		  ENLACES.add(ADMINISTRACION);
		  ENLACES.add(INSTRUCCIONES_GUIAS);
		  ENLACES.add(BANDEJA_DE_SALIDA);
		  ENLACES.add(EVALUACIONES);
		  ENLACES.add(CONSULTA_EVALUACION);
	  }

}
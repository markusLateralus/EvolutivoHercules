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
	
	
	
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav:nth-child(3) > div:nth-child(1) > app-hercules3-menu:nth-child(2) > mat-tree:nth-child(1) > mat-tree-node:nth-child(5) > div:nth-child(2)")
	public static WebElement DOCUMENTACION;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav:nth-child(3) > div:nth-child(1) > app-hercules3-menu:nth-child(2) > app-hercules3-menu-nivel-uno:nth-child(1) > mat-tree:nth-child(3) > mat-tree-node:nth-child(1) > div:nth-child(2)")
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
	  
	  //sprint 4
	  @FindBy(xpath="(//div[normalize-space()='Seguridad'])[1]")
	  public static WebElement SEGURIDAD;
	  @FindBy(xpath="(//div[normalize-space()='Usuarios'])[1]")
	  public static WebElement USUARIOS;
	  @FindBy(xpath="(//mat-tree-node[@role='treeitem'])[3]")
	  public static WebElement REEMPLAZAR_RESPONSABLE;
	  @FindBy(xpath="(//div[normalize-space()='Fichas'])[1]")
	  public static WebElement FICHAS;
	  @FindBy(xpath="(//div[normalize-space()='Editar Ficha'])[1]")
	  public static WebElement EDITAR_FICHAS;
	  @FindBy(xpath="(//div[normalize-space()='Riesgos'])[1]")
	  public static WebElement RIESGOS;
	  @FindBy(xpath="(//div[normalize-space()='Consulta Riesgos'])[1]")
	  public static WebElement CONSULTA_RIESGOS;
	  @FindBy(xpath="(//div[normalize-space()='Publicaciones Pendientes'])[1]")
	  public static WebElement PUBLICACIONES_PENDIENTES;
	  @FindBy(xpath="(//div[normalize-space()='Alta Evaluación'])[1]")
	  public static WebElement ALTA_EVALUACION;
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
		  ENLACES.add(SEGURIDAD);
		  ENLACES.add(USUARIOS);
		  ENLACES.add(REEMPLAZAR_RESPONSABLE);
		  ENLACES.add(FICHAS);
		  ENLACES.add(EDITAR_FICHAS);
		  ENLACES.add(RIESGOS);
		  ENLACES.add(CONSULTA_RIESGOS);
		  ENLACES.add(PUBLICACIONES_PENDIENTES);
		  ENLACES.add(ALTA_EVALUACION);
	  }

}

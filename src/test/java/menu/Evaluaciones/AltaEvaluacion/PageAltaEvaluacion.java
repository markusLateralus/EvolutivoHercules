package menu.Evaluaciones.AltaEvaluacion;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import menu.Evaluaciones.ConsultaEvaluacion.PageConsultaEvaluacion;
import net.serenitybdd.core.pages.PageObject;

public class PageAltaEvaluacion extends PageObject{


	@FindBy(css="div[class='col-md-12 col-lg-10 col-xl-10'] span[class='material-icons']")
	static WebElement ICONO_LUPA;

	@FindBy(css="ng-select[placeholder='-Seleccione un Cliente-'] input[role='combobox']")
	static WebElement CAMPO_CLIENTE;
	
	@FindBy(xpath="(//div[contains(text(),'012363-AYUNTAMIENTO DE AVILA')])[1]")
	static WebElement PRIMER_RESULTADO_DESPLEGABLE;
	//(//div[@class="mat-button-focus-overlay"])[8]
	//  (//div[@class="mat-ripple mat-button-ripple"])[5]
	@FindBy(xpath="(//div[@class=\"mat-ripple mat-button-ripple\"])[5]")
	static WebElement BOTON_ACEPTAR;
	
	@FindBy(css="ng-select[placeholder=' - Provincia - '] input[role='combobox']")
	static WebElement CAMPO_PROVINCIA;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-evaluaciones-home:nth-child(3) > app-evaluaciones:nth-child(2) > app-evaluaciones-pestanas:nth-child(2) > mat-tab-group:nth-child(1) > div:nth-child(2) > mat-tab-body:nth-child(1) > div:nth-child(1) > app-evaluaciones-general:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ng-select:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	static WebElement CAMPO_MODELO_NEGOCIO;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-evaluaciones-home:nth-child(3) > app-evaluaciones:nth-child(2) > app-evaluaciones-pestanas:nth-child(2) > mat-tab-group:nth-child(1) > div:nth-child(2) > mat-tab-body:nth-child(1) > div:nth-child(1) > app-evaluaciones-general:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ng-select:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	static WebElement CAMPO_EMPRESA;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-evaluaciones-home:nth-child(3) > app-evaluaciones:nth-child(2) > app-evaluaciones-pestanas:nth-child(2) > mat-tab-group:nth-child(1) > div:nth-child(2) > mat-tab-body:nth-child(1) > div:nth-child(1) > app-evaluaciones-general:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ng-select:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	static WebElement CAMPO_LINIA_VENTA;
	@FindBy(css="#lugarPrestacion")
	static WebElement CAMPO_LUGAR_DE_PRESTACION_DE_SERVICIO;
	@FindBy(css="#actividadContratada")
	static WebElement CAMPO_ACTIVIDAD_CONTRATADA;
	@FindBy(css="ng-select[placeholder=' - Técnico - '] input[role='combobox']")
	static WebElement CAMPO_TECNICO;
	@FindBy(css="#a470c7e0fbc8-2")
	static WebElement DESPLEGABLE_TECNICO;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-evaluaciones-home:nth-child(3) > app-evaluaciones:nth-child(2) > app-evaluaciones-pestanas:nth-child(2) > mat-tab-group:nth-child(1) > div:nth-child(2) > mat-tab-body:nth-child(1) > div:nth-child(1) > app-evaluaciones-general:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > ng-select:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	static WebElement CAMPO_RESPONSABLE_DE_CONTRATO;
	@FindBy(css="body > app-root:nth-child(1) > app-hercules3-sidebar:nth-child(1) > div:nth-child(1) > mat-sidenav-container:nth-child(1) > mat-sidenav-content:nth-child(5) > app-evaluaciones-home:nth-child(3) > app-evaluaciones:nth-child(2) > app-evaluaciones-pestanas:nth-child(2) > mat-tab-group:nth-child(1) > div:nth-child(2) > mat-tab-body:nth-child(1) > div:nth-child(1) > app-evaluaciones-general:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(7) > ng-select:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	static WebElement CAMPO_RESPONSABLE_DE_CONTROL_PERIODICO;
	@FindBy(css="#fInicioContrato")
	static WebElement CAMPO_FECHA_INICIO_CONTRATO;

	
	
	
	
}

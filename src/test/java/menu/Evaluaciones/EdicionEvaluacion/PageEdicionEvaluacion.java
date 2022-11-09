package menu.Evaluaciones.EdicionEvaluacion;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import menu.Evaluaciones.ConsultaEvaluacion.PageConsultaEvaluacion;
import net.serenitybdd.core.pages.PageObject;

public class PageEdicionEvaluacion extends PageObject{


//	@FindBy(id="mat-tab-label-0-1")
	static WebElement PESTANIA_PUESTOS=PageConsultaEvaluacion.PESTANIA_PUESTOS;
	
//	@FindBy(xpath="(//span[normalize-space()='32166'])[1]")
	static WebElement PRIMER_VALOR_TABLA_PESTANIA_PUESTOS=PageConsultaEvaluacion.PRIMER_VALOR_TABLA_PESTANIA_PUESTOS; //la primera celda de la tabla de puestos
	
}

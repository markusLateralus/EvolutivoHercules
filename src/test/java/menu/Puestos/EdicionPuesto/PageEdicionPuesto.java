package menu.Puestos.EdicionPuesto;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import menu.Evaluaciones.ConsultaEvaluacion.PageConsultaEvaluacion;
import net.serenitybdd.core.pages.PageObject;

public class PageEdicionPuesto extends PageObject{

	/*
	//@FindBy(xpath="(//div[contains(text(),'Ins. Guías Nacionales')])[1]")
	static WebElement pestaniaIGN=PageConsultaEvaluacion.pestaniaIGN;
	//@FindBy(xpath="(//span[contains(text(),'download')])[4]")
	static WebElement botonDESCARGAR_1=PageConsultaEvaluacion.botonDESCARGAR_1;
	//@FindBy(xpath="(//span[contains(text(),'download')])[8]")
	static WebElement botonDESCARGAR_2=PageConsultaEvaluacion.botonDESCARGAR_2;
	
//	@FindBy(xpath="(//div[contains(text(),'Ins. Guías Cliente/Proyecto')])[1]")
	static WebElement pestaniaIGCT=PageConsultaEvaluacion.pestaniaIGCT;
	//@FindBy(xpath="(//span[@class='material-icons search-button ng-star-inserted'][normalize-space()='download'])[1]")
	static WebElement botonDESCARGAR_IGCT=PageConsultaEvaluacion.botonDESCARGAR_IGCT;
	
	*/
	
	@FindBy(xpath="(//div[contains(text(),'Ins. Guías Nacionales')])[1]")
	static WebElement pestaniaIGN;
	@FindBy(xpath="(//span[contains(text(),'download')])[4]")
	static WebElement botonDESCARGAR_1;
	@FindBy(xpath="(//span[contains(text(),'download')])[8]")
	static WebElement botonDESCARGAR_2;
	
     @FindBy(xpath="(//div[contains(text(),'Ins. Guías Cliente/Proyecto')])[1]")
	static WebElement pestaniaIGCT;
	@FindBy(xpath="(//span[@class='material-icons search-button ng-star-inserted'][normalize-space()='download'])[1]")
	static WebElement botonDESCARGAR_IGCT;
	
	
	
}

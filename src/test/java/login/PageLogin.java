package login;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://prehercules.eulen.com/hercules3/login")
public class PageLogin extends PageObject{

	@FindBy(xpath="(//div[@class=\"form-group\"])[1]/descendant::input")
	static WebElement campoUsuario;	
	
	@FindBy(xpath="(//div[@class=\"form-group\"])[2]/descendant::input")
	static WebElement campoPassword;
	@FindBy(css="button[class=\"btn btn-primary\"]")
	static WebElement botonLogin;


	
}

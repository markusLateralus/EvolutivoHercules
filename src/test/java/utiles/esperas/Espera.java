package utiles.esperas;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.steps.UIInteractionSteps;

public class Espera extends UIInteractionSteps {

	public  void implicitamente(int tiempo) {
		 this.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(tiempo));
		 }
	
	public static void espera(long tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//presente, visible y habilitado
	public void queSeaclicable(Duration tiempo, WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(),tiempo);
		wait.until(ExpectedConditions.elementToBeClickable(element));

		}
	//presente, visible, hablilitado y NO estar oculto por otro elemento
	public void queSeaVisible(Duration tiempo,WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(),tiempo);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void queSeaSeleccionado(Duration tiempo,WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(),tiempo);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	  public void dobleClick(WebElement webElement) {
			Actions action;
			try {
				action = new Actions(getDriver());
				action.doubleClick(webElement).perform();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    }
}

package login;

import net.serenitybdd.core.steps.UIInteractionSteps;
//import net.thucydides.core.annotations.Step;
import utiles.esperas.Espera;


public class Navega extends UIInteractionSteps {

	private PageLogin login;
	
	// @Step("abro la aplicacion Hercules")
	    public void aLogin() {
	    	login.open();
	    //	Espera.espera(5000);
	 }
}

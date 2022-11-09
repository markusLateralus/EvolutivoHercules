package escritorio;

import java.time.Duration;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class VerificarNombreUsuario extends UIInteractionSteps{
	
	public PageEscritorio inicio;
	Espera espera=new Espera();
	@Step("verifico  nombre usuario: {nombreCompleto}")
	public String verificarUsuario(String usuario) {
		espera.queSeaVisible(Duration.ofSeconds(15), PageEscritorio.contenedorNombreCompleto);
		//this.esperaHastaQueSeaLocalizado(Duration.ofSeconds(15), By.xpath("//div[@class=\"row ng-star-inserted\"]/descendant::div[@class=\"col-4\"]"));
		//WebElement contenedorNombreCompleto=contenedor.findElement(By.xpath("//div[@class=\"row ng-star-inserted\"]/descendant::div[@class=\"col-4\"]"));
		String todo= PageEscritorio.contenedorNombreCompleto.getText();
		String[] lista=todo.split("•");
		String nombre=lista[0];
		//elimino el último caracter
		return nombre.substring(0, nombre.length()-1);
	}

}

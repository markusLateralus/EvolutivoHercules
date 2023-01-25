package escritorio;

import java.time.Duration;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class VerificarRol extends UIInteractionSteps{
	
	public PageEscritorio inicio;
	AlmacenRutasDeCapturaPantalla almacenRutasDeCapturaPantalla;
	
	Espera espera=new Espera();
	@Step("verifico el rol {rol}")
	public String verificarRol(String rol) {
		espera.queSeaVisible(Duration.ofSeconds(15), PageEscritorio.contenedorNombreCompleto);
		String todo= PageEscritorio.contenedorNombreCompleto.getText();
		String[] lista=todo.split("•");
		String rol2=lista[1];
       Espera.obligatoriamente(2);
       almacenRutasDeCapturaPantalla.guardarRuta("Accedemos correctamente a la aplicación" ,"pantallaInicio");
		return rol2;
	}

}

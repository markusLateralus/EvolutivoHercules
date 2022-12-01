package menu.Puestos.EdicionPuesto;

import java.time.Duration;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;


public class DescargaIGN extends UIInteractionSteps {

	//private PageEdicionPuesto pageEdicionPuesto;
	private Espera espera=new Espera();
	
	@Step("El usuario se descarga la Ins Guias Nacionales")
	public void descargar(String escenario) {
		 if(escenario.equalsIgnoreCase("@ignBoton1")) {
		this.descargarIGNconBoton1(escenario);
		 }else if(escenario.equalsIgnoreCase("@ignBoton2")) {
			 this.descargarIGNconBoton2(escenario);
		 }
	}

	
	 @Step("El usuario selecciona la pestaña Ins Guias Nacionales")
	    public void seleccionarPestaniaGuiaNacionales(String escenario) {
		 if(escenario.equalsIgnoreCase("@ignBoton1") || escenario.equalsIgnoreCase("@ignBoton2")) {
		 espera.queSeaVisible(Duration.ofSeconds(30), PageEdicionPuesto.pestaniaIGN);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario selecciona la pestaña Ins Guias Nacionales", "irGuiasNacionales");
		 }
		 PageEdicionPuesto.pestaniaIGN.click();
		 }
	 }
	 
	 @Step("El usuario se descarga el documento de la tabla con el boton 1")
	 private void descargarIGNconBoton1(String escenario) {
	
		 espera.queSeaVisible(Duration.ofSeconds(10), PageEdicionPuesto.botonDESCARGAR_1);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3 && escenario.equalsIgnoreCase("@ignBoton1")) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga el documento de la tabla con el boton 1", "descargarIGNBoton1");
		 }
		 PageEdicionPuesto.botonDESCARGAR_1.click();
		 Espera.obligatoriamente(1000);
		 
	 }
	 
	 @Step("El usuario  se descarga el documento de la tabla con el boton 2")
	 private void descargarIGNconBoton2(String escenario) {
		
		 espera.queSeaVisible(Duration.ofSeconds(10), PageEdicionPuesto.botonDESCARGAR_2);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3&& escenario.equalsIgnoreCase("@ignBoton2")) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga el documento de la tabla con el boton 2", "descargarIGNBoton2");
		 }
		 PageEdicionPuesto.botonDESCARGAR_2.click();
		Espera.obligatoriamente(1000);
	 }
	 
	 
}

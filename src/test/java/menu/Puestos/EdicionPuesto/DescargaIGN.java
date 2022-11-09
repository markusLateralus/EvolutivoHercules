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
	public void descargarConBoton1() {
		//this.seleccionarPestaniaGuiaNacionales();
		this.descargarIGNconBoton1();
	}
	@Step("El usuario se descarga la Ins Guias Nacionales")
	public void descargarConBoton2() {
		this.seleccionarPestaniaGuiaNacionales();
		this.descargarIGNconBoton2();
	}
	
	 @Step("El usuario selecciona la pestaña Ins Guias Nacionales")
	    public void seleccionarPestaniaGuiaNacionales() {
		 espera.queSeaVisible(Duration.ofSeconds(30), PageEdicionPuesto.pestaniaIGN);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3 ||AlmacenRutasDeCapturaPantalla.VALOR_RUTA==4) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario selecciona la pestaña Ins Guias Nacionales", "irGuiasNacionales");
		 }
		 PageEdicionPuesto.pestaniaIGN.click();
	 }
	 
	 @Step("El usuario se descarga el documento de la tabla con el boton 1")
	 private void descargarIGNconBoton1() {
		 espera.queSeaVisible(Duration.ofSeconds(10), PageEdicionPuesto.botonDESCARGAR_1);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==3) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga el documento de la tabla con el boton 1", "descargarIGNBoton1");
		 }
		 PageEdicionPuesto.botonDESCARGAR_1.click();
		 Espera.espera(1000);
	 }
	 
	 @Step("El usuario  se descarga el documento de la tabla con el boton 2")
	 private void descargarIGNconBoton2() {
		 espera.queSeaVisible(Duration.ofSeconds(10), PageEdicionPuesto.botonDESCARGAR_2);
		 if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==4) {
			 AlmacenRutasDeCapturaPantalla.guardarRuta( "El usuario se descarga el documento de la tabla con el boton 2", "descargarIGNBoton2");
		 }
		 PageEdicionPuesto.botonDESCARGAR_2.click();
		Espera.espera(1000);
	 }
	 
}

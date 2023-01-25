package steps.Hooks;

import java.util.Collection;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;

public class Hooks {

	
	/*
	@Before()
	public void antes(Scenario escenario) {
	
		if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==5)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1;
		System.out.println("dentro before hook " + CapturaPantalla.CONTADOR_VUELTAS_APLICACION);
		
		Collection<String> etiquetas=escenario.getSourceTagNames();
		
		for(String etiqueta: etiquetas) {
			if (etiqueta.equalsIgnoreCase("@loginCorrecto") || etiqueta.equalsIgnoreCase("@loginIncorrecto")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(0);
			}else if(etiqueta.equalsIgnoreCase("@descargaConsultaDocumentos")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(1);
			}else if(etiqueta.equalsIgnoreCase("@descargaDocumentacion")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(2);
				//if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==3)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1;//son 2 usuarios
			}else if(etiqueta.equalsIgnoreCase("@ignBoton1") || etiqueta.equalsIgnoreCase("@ignBoton2") || etiqueta.equalsIgnoreCase("@igct")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(3);
			}else if(etiqueta.equalsIgnoreCase("@descargaInstruccionesGuias")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(4);
			}else if(etiqueta.equalsIgnoreCase("@descargaFormulario") || etiqueta.equalsIgnoreCase("@VerficaFormularioSinRespuesta")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(5);
			}else if(etiqueta.equalsIgnoreCase("@altaUsuario") || etiqueta.equalsIgnoreCase("@bajaUsuario")) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(6);
			}else if(etiqueta.equalsIgnoreCase("@ConsultaDeEvaluaciones") || etiqueta.equalsIgnoreCase("@AltaDeEvaluaciones") || etiqueta.equalsIgnoreCase("@ReemplazarResponsable") || etiqueta.equalsIgnoreCase("@EditarFicha") || etiqueta.equalsIgnoreCase("@ConsultaDeRiesgo") || etiqueta.equalsIgnoreCase("@ConsultaDeDocumentos") || etiqueta.equalsIgnoreCase("@Coordinacion") || etiqueta.equalsIgnoreCase("@AsociacionEmpleadoPuesto") ) {
				AlmacenRutasDeCapturaPantalla.setValorRuta(7);
				if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==2)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1; //solo es un usuario
				System.out.println("dentro CAMBIOS EN TECNICO DE ZONA");
			}
		}
	}
	

@After()
public void despues() {
	CapturaPantalla.CONTADOR_VUELTAS_APLICACION++;

	System.out.println("dentro after hook " + CapturaPantalla.CONTADOR_VUELTAS_APLICACION);
	
      
       }
*/
}

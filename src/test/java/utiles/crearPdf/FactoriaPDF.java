package utiles.crearPdf;

import java.util.Collection;

import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;

public class FactoriaPDF {

	int valor = 0;

	public static void crearPdf(int valor, int vueltaEjecucion) {
		if (valor == 1) {
			PdfConsultaDocumentos.crearPdf(vueltaEjecucion);
		}
		if (valor == 2) {
			PdfCoordinacion.crearPdf(vueltaEjecucion);
		}
		if (valor == 4) {
			PdfInstruccionesGuia.crearPdf(vueltaEjecucion);
			PdfInstruccionesGuia.fusionarPdfs();
		}
		
	}



	public static void crearPdf(int valor, int vueltaEjecucion, String rutaEscenario, TituloPortada tituloPortada,
			Descripcion descripcion, Sprint sprint) {
		if (valor == 0) {
			if (vueltaEjecucion == 1) {
				PdfLogin.crearArchvivo(rutaEscenario);
				PdfLogin.crearPdf(vueltaEjecucion, rutaEscenario,tituloPortada,descripcion,sprint);
			} else
				PdfLogin.crearPdf(vueltaEjecucion, rutaEscenario,tituloPortada,descripcion,sprint);
		}
		if (valor == 3) {
		
			if (vueltaEjecucion == 1) {
				Pdf_IGN_IGCT.crearArchvivo(rutaEscenario);
				Pdf_IGN_IGCT.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			} else
				Pdf_IGN_IGCT.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
		}
		if (valor == 5) {
			if(vueltaEjecucion==1) {
				PdfFormularioAdiestramiento.crearArchivo(rutaEscenario);
				PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion,rutaEscenario,tituloPortada,descripcion,sprint);
			}
			PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion,rutaEscenario,tituloPortada,descripcion,sprint);
		}

	}

}

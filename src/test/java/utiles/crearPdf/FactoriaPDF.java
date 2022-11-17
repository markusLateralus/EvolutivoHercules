package utiles.crearPdf;

import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;

public class FactoriaPDF {

	int valor = 0;

	public static void crearPdf(int valor, int vueltaEjecucion, String rutaEscenario, TituloPortada tituloPortada,
			Descripcion descripcion, Sprint sprint) {
		if (valor == 0) {
			if (vueltaEjecucion == 1) {
				PdfLogin.crearArchvivo(rutaEscenario);
				PdfLogin.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			} else
				PdfLogin.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
		}
		if (valor == 1) {
			if (vueltaEjecucion == 1) {
				PdfConsultaDocumentos.crearArchvivo(rutaEscenario);
				PdfConsultaDocumentos.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			} else
				PdfConsultaDocumentos.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
		}

		if (valor == 2) {
			if (vueltaEjecucion == 1) {
				PdfCoordinacion.crearArchivo(rutaEscenario);
				PdfCoordinacion.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			}
			if (vueltaEjecucion == 2) {
				PdfCoordinacion.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			}
		}

		if (valor == 3) {

			if (vueltaEjecucion == 1) {
				Pdf_IGN_IGCT.crearArchvivo(rutaEscenario);
				Pdf_IGN_IGCT.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			} else
				Pdf_IGN_IGCT.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
		}

		if (valor == 4) { // Solo ES UN USUARIO
			PdfInstruccionesGuia.crearArchvivo(rutaEscenario);
			PdfInstruccionesGuia.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
			// PdfInstruccionesGuia.fusionarPdfs();
		}

		if (valor == 5) {
			if (vueltaEjecucion == 1) {
				PdfFormularioAdiestramiento.crearArchivo(rutaEscenario);
				PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion,
						sprint);
			}
			PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
		}
		if (valor == 6) { // es un solo usuario
			if (vueltaEjecucion == 1) {
				PdfAltaDeUsuario.crearArchivo(rutaEscenario);
				PdfAltaDeUsuario.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion, sprint);
				// PdfModificacionPerfilTecnicoDeZona.fusionarPdfs();
			}
		}
		if (valor == 7) { // Solo ES UN USUARIO
			if (vueltaEjecucion == 1) {
				PdfModificacionPerfilTecnicoDeZona.crearArchivo(rutaEscenario);
				PdfModificacionPerfilTecnicoDeZona.crearPdf(vueltaEjecucion, rutaEscenario, tituloPortada, descripcion,sprint);
			}
			// PdfInstruccionesGuia.fusionarPdfs();
		}

	}

}

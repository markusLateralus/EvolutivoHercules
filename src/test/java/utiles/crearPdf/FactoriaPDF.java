package utiles.crearPdf;

import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;

public class FactoriaPDF {

	int valor = 0;

	public static void crearPdf(int valorRuta, int vueltaEjecucion, String nombreEsceneario, TituloPortada tituloPortada,
			Descripcion descripcion, Sprint sprint) {
		if (valorRuta == 0) {
			if (vueltaEjecucion == 1) {
				PdfLogin.crearArchvivo(nombreEsceneario);
				PdfLogin.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
			} else
				PdfLogin.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
		}
		
		
		
		if (valorRuta == 1) {
			if (vueltaEjecucion == 1) {
				PdfConsultaDocumentos.crearArchvivo(nombreEsceneario);
				PdfConsultaDocumentos.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
			} else
				PdfConsultaDocumentos.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
		}

		if (valorRuta == 2) {
			if (vueltaEjecucion == 1) {
				PdfCoordinacion.crearArchivo(nombreEsceneario);
				PdfCoordinacion.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
			}
			if (vueltaEjecucion == 2) {
				PdfCoordinacion.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
			}
		}

		if (valorRuta == 3) {

			if (vueltaEjecucion == 1) {
				Pdf_IGN_IGCT.crearArchvivo(nombreEsceneario);
				Pdf_IGN_IGCT.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
			} else
				Pdf_IGN_IGCT.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
		}

		if (valorRuta == 4) { // Solo ES UN USUARIO
			PdfInstruccionesGuia.crearArchvivo(nombreEsceneario);
			PdfInstruccionesGuia.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
			// PdfInstruccionesGuia.fusionarPdfs();
		}

		if (valorRuta == 5) {
			if (vueltaEjecucion == 1) {
				PdfFormularioAdiestramiento.crearArchivo(nombreEsceneario);
				PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion,
						sprint);
			}
			PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
		}
		if (valorRuta == 6) { // es un solo usuario
			if (vueltaEjecucion == 1) {
				PdfAltaDeUsuario.crearArchivo(nombreEsceneario);
				PdfAltaDeUsuario.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion, sprint);
				
			}
		}
		if (valorRuta == 7) { // Solo ES UN USUARIO
			if (vueltaEjecucion == 1) {
				PdfModificacionPerfilTecnicoDeZona.crearArchivo(nombreEsceneario);
				PdfModificacionPerfilTecnicoDeZona.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion,sprint);
			}
		
		}
		if (valorRuta == 8) { // Solo ES UN USUARIO
			if (vueltaEjecucion == 1) {
				PdfCambioDeEditorTexto.crearArchivo(nombreEsceneario);
				PdfCambioDeEditorTexto.crearPdf(vueltaEjecucion, nombreEsceneario, tituloPortada, descripcion,sprint);
			}
		
		}

	}

}

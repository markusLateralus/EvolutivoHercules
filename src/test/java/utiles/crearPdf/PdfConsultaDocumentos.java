package utiles.crearPdf;

import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.RutasPdf;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class PdfConsultaDocumentos extends FactoryMethodPdf {

														
	static String Ruta_Generica_Consulta_Documentos = "./documentos/documentacion/coordinacion_cliente/consulta_documentos/descargarConsultaDocumentos";
	static boolean Creada_Ruta_Generica_ConsultaDocumentos = CreadorPdf.crearArchivo(Ruta_Generica_Consulta_Documentos + 1 + ".pdf");
    static String plantilla="./documentos/documentacion/coordinacion_cliente/consulta_documentos/plantilla.pdf";
	static String rutas[] = {
			"./documentos/documentacion/coordinacion_cliente/consulta_documentos/plantilla.pdf", 
			"./documentos/documentacion/coordinacion_cliente/consulta_documentos/descargarConsultaDocumentos1.pdf",
			"./documentos/documentacion/coordinacion_cliente/consulta_documentos/descargarConsultaDocumentos2.pdf",
			"./documentos/documentacion/coordinacion_cliente/consulta_documentos/descargarConsultaDocumentos3.pdf",
			"./documentos/documentacion/coordinacion_cliente/consulta_documentos/descargarConsultaDocumentos4.pdf"
			};
	public static void crearPdf(int vueltaEjecucion) {
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica_ConsultaDocumentos) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_DESCARGAR_CONSULTADOCUMENTOS, Descripcion.DESCRIPCION_DESCARGAR_CONSULTA_DOCUMENTACION, Sprint.Sprint1);
				CreadorPdf.escribeDocumento(Ruta_Generica_Consulta_Documentos + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	
			} else {
				CreadorPdf.escribeDocumento(Ruta_Generica_Consulta_Documentos + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
				if (vueltaEjecucion == 4) {		
					CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_DOCUMENTACION_COORDINACIONCLIENTE_CONSULTA_DOCUMENTOS_FINAL, rutas);
				}
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
}

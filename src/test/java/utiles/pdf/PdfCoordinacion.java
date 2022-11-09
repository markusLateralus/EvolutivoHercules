package utiles.pdf;

import utiles.capturasPantallas.CapturaPantalla;

public class PdfCoordinacion extends FactoryMethodPdf {
	static String Ruta_Generica_DescargarCoordinacion = "./documentos/documentacion/coordinacion_cliente/coordinacion/descargarCoordinacion";
	static boolean Creada_Ruta_Generica_DescargarCoordinacion = CreadorPdf.crearArchivo(Ruta_Generica_DescargarCoordinacion + 1 + ".pdf");
     static String plantilla="./documentos/documentacion/coordinacion_cliente/coordinacion/plantilla.pdf";
	static String rutas[] = { "./documentos/documentacion/coordinacion_cliente/coordinacion/plantilla.pdf",
			"./documentos/documentacion/coordinacion_cliente/coordinacion/descargarCoordinacion1.pdf", 
			"./documentos/documentacion/coordinacion_cliente/coordinacion/descargarCoordinacion2.pdf" };
	public static void crearPdf(int vueltaEjecucion) {
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica_DescargarCoordinacion) {
			if (vueltaEjecucion == 1) {
			//	CreadorPdf.crearPlantilla(plantilla, CreadorPdf.TITULO_DESCARGAR_COORDINACION, CreadorPdf.DESCRIPCION_DESCARGARCOORDINACION, CreadorPdf.Sprint1);
				CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_DESCARGAR_COORDINACION, Descripcion.DESCRIPCION_DESCARGARCOORDINACION, Sprint.Sprint1);

			//	CreadorPdf.escribir(Ruta_Generica_DescargarCoordinacion + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(Ruta_Generica_DescargarCoordinacion + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

			} else if (vueltaEjecucion == 2) {
			//	CreadorPdf.escribir(Ruta_Generica_DescargarCoordinacion + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(Ruta_Generica_DescargarCoordinacion + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

					
				//	CreadorPdf.fusionarPdf(CreadorPdf.RUTA_PDF_DOCUMENTACION_COORDINACIONCLIENTE_COORDINACION_FINAL, rutas);
				CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_DOCUMENTACION_COORDINACIONCLIENTE_COORDINACION_FINAL, rutas);
				
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
		
	}
	
}

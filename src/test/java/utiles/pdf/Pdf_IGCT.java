package utiles.pdf;

import utiles.capturasPantallas.CapturaPantalla;

public class Pdf_IGCT extends FactoryMethodPdf{

	
	
	private static String RUTA = "./documentos/evaluaciones/consulta_evaluacion/igct/descargarIGCT";
	private static boolean CREADA_RUTA = CreadorPdf.crearArchivo(RUTA + 1 + ".pdf");
	private static String PLANTILLA="./documentos/evaluaciones/consulta_evaluacion/igct/plantilla.pdf";
	private static String RUTAS[] = {
			"./documentos/evaluaciones/consulta_evaluacion/igct/plantilla.pdf", 
			"./documentos/evaluaciones/consulta_evaluacion/igct/descargarIGCT1.pdf",
			"./documentos/evaluaciones/consulta_evaluacion/igct/descargarIGCT2.pdf",
			"./documentos/evaluaciones/consulta_evaluacion/igct/descargarIGCT3.pdf",
			"./documentos/evaluaciones/consulta_evaluacion/igct/descargarIGCT4.pdf"
			};
	public static void crearPdf(int vueltaEjecucion) {
		// TODO Auto-generated method stub
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (CREADA_RUTA) {
			if (vueltaEjecucion == 1) {
				//CreadorPdf.crearPlantilla(PLANTILLA, CreadorPdf.TITULO_DESCARGAR_IGCT, CreadorPdf.DESCRIPCION_DESCARGAR_IGCT, CreadorPdf.Sprint1);
				CreadorPdf.escribePlantilla(PLANTILLA, TituloPortada.TITULO_DESCARGAR_IGCT, Descripcion.DESCRIPCION_DESCARGAR_IGCT, Sprint.Sprint1);
			//	CreadorPdf.escribir(RUTA + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(RUTA + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
			} else {
			//	CreadorPdf.escribir(RUTA + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(RUTA + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
				if (vueltaEjecucion == 4) {
			
					//CreadorPdf.fusionarPdf(CreadorPdf.RUTA_PDF_EVALUACIONES_CONSULTAEVALUACION_IGCT_FINAL, RUTAS);
					CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_EVALUACIONES_CONSULTAEVALUACION_IGCT_FINAL, RUTAS);
				}
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
}

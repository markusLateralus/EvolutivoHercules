package utiles.pdf;

import utiles.capturasPantallas.CapturaPantalla;

public class Pdf_IGN_Boton2 extends FactoryMethodPdf{

	
	static String Ruta_Generica_DescargaIGN_Boton2 = "./documentos/evaluaciones/consulta_evaluacion/ign/boton2/descargarIGN";
	static boolean Creada_Ruta_Generica_DescargaIGN_Boton2 = CreadorPdf.crearArchivo(Ruta_Generica_DescargaIGN_Boton2 + 1 + ".pdf");
	static String plantilla="./documentos/evaluaciones/consulta_evaluacion/ign/boton2/plantilla.pdf";
	static String rutas[] = {
			"./documentos/evaluaciones/consulta_evaluacion/ign/boton2/plantilla.pdf", 
			"./documentos/evaluaciones/consulta_evaluacion/ign/boton2/descargarIGN1.pdf",
			"./documentos/evaluaciones/consulta_evaluacion/ign/boton2/descargarIGN2.pdf",
			"./documentos/evaluaciones/consulta_evaluacion/ign/boton2/descargarIGN3.pdf",
			"./documentos/evaluaciones/consulta_evaluacion/ign/boton2/descargarIGN4.pdf"
			};
public static void crearPdf(int vueltaEjecucion) {
CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
if (Creada_Ruta_Generica_DescargaIGN_Boton2) {
	if (vueltaEjecucion == 1) {
	//	CreadorPdf.crearPlantilla(plantilla, CreadorPdf.TITULO_DESCARGAR_IGN, CreadorPdf.DESCRIPCION_DESCARGAR_IGN_Boton2, CreadorPdf.Sprint1);
		CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_DESCARGAR_IGN, Descripcion.DESCRIPCION_DESCARGAR_IGN_Boton2, Sprint.Sprint1);

		//CreadorPdf.escribir(Ruta_Generica_DescargaIGN_Boton2 + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
		CreadorPdf.escribeDocumento(Ruta_Generica_DescargaIGN_Boton2 + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

	} else{
		//CreadorPdf.escribir(Ruta_Generica_DescargaIGN_Boton2 + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
		CreadorPdf.escribeDocumento(Ruta_Generica_DescargaIGN_Boton2 + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

		if (vueltaEjecucion == 4) {
			
			
				//String rutaFinal="./documentos/evaluaciones/consulta_evaluacion/ign/descargarIGNFinal_Boton2.pdf";
			//	CreadorPdf.fusionarPdf(CreadorPdf.RUTA_PDF_EVALUACIONES_CONSULTAEVALUACION_IGN_Boton2_FINAL, rutas);
			CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_EVALUACIONES_CONSULTAEVALUACION_IGN_Boton2_FINAL, rutas);

		}
			}
	
	
	} else {// en caso de que falle el método Pdf.crearArchivo()
		System.out.println("No se ha creado el archivo de forma correcta");
	}
	
	
}
}

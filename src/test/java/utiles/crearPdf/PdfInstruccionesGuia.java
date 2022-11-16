package utiles.crearPdf;

import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.RutasPdf;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class PdfInstruccionesGuia extends FactoryMethodPdf{

													  //./documentos/herramientas/administracion/instrucciones_guias/descargarInstruccionesGuiasFinal.pdf
	static String Ruta_Generica_InstruccionesGuias = "./documentos/Herramientas/Administracion/Instrucciones_Guias/descargarInstruccionesGuias";
	static boolean Creada_Ruta_Generica_InstruccionesGuias = CreadorPdf.crearArchivo(Ruta_Generica_InstruccionesGuias + 1 + ".pdf");
	static String plantilla="./documentos/Herramientas/Administracion/Instrucciones_Guias/plantilla.pdf";
	static String rutas[] = { "./documentos/Herramientas/Administracion/Instrucciones_Guias/plantilla.pdf",
							  "./documentos/Herramientas/Administracion/Instrucciones_Guias/descargarInstruccionesGuias1.pdf" };
	public static void crearPdf(int vueltaEjecucion) {
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica_InstruccionesGuias) {
			if (vueltaEjecucion == 1) {
			//	CreadorPdf.crearPlantilla(plantilla,CreadorPdf.TITULO_DESCARGAR_INSTRUCCIONESGUIAS, CreadorPdf.DESCRIPCION_INSTRUCCIONESGUIAS, CreadorPdf.Sprint1);
				CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_DESCARGAR_INSTRUCCIONESGUIAS, Descripcion.DESCRIPCION_INSTRUCCIONESGUIAS, Sprint.Sprint1);

				//CreadorPdf.escribir(Ruta_Generica_InstruccionesGuias + vueltaEjecucion + ".pdf", CreadorPdf.imagenes, CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(Ruta_Generica_InstruccionesGuias + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

				//	CreadorPdf.fusionarPdf(CreadorPdf.RUTA_PDF_HERRAMIENTAS_ADMINISTRACION_INSTRUCIONESGUIAS_FINAL, rutas);
				
				}
			

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
	
	
	public static void fusionarPdfs() {
		CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_HERRAMIENTAS_ADMINISTRACION_INSTRUCIONESGUIAS_FINAL, rutas);
	}
}

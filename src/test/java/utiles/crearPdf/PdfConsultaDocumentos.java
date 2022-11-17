package utiles.crearPdf;

import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.RutasPdf;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class PdfConsultaDocumentos extends FactoryMethodPdf {

														
	static String Ruta_Raiz = "./documentos/consulta_documentos/";
	static boolean Creada_Ruta_Raiz = false;
	static String Ruta_Plantilla="";
	public static String Ruta_Archivo="";
	public static String Ruta_Escenario="";
	public static String Ruta_Final="";

	
	public static boolean crearArchvivo(String rutaEscenario) {
		return  Creada_Ruta_Raiz = CreadorPdf.crearArchivo(Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+ 1+".pdf");
		
	}
	
	public static void crearPdf(int vueltaEjecucion, String rutaEscenario, TituloPortada tituloPortada, Descripcion descripcion, Sprint sprint) {
		Ruta_Escenario=rutaEscenario;
		Ruta_Final=Ruta_Raiz+Ruta_Escenario+"/"; //creamos la ruta para el escenario
		Ruta_Archivo=Ruta_Final+ rutaEscenario;//creamos la ruta para el archvivo
		Ruta_Plantilla=Ruta_Raiz+Ruta_Escenario+"/plantilla.pdf";
		
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Raiz) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(Ruta_Plantilla, TituloPortada.TITULO_DESCARGAR_CONSULTADOCUMENTOS, Descripcion.DESCRIPCION_DESCARGAR_CONSULTA_DOCUMENTACION, Sprint.Sprint1);
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	
			} else {
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
				if (vueltaEjecucion == 4) {		
					 String rutasArchivos[] = { Ruta_Plantilla, 
							 Ruta_Archivo+"1.pdf",
							 Ruta_Archivo+"2.pdf",
							 Ruta_Archivo+"3.pdf", 
							 Ruta_Archivo+"4.pdf" };
					CreadorPdf.fusionaPdfs(Ruta_Archivo+"Final.pdf", rutasArchivos);
				}
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
	
}

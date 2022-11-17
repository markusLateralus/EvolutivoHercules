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
	static String Ruta_Raiz = "./documentos/Instrucciones_Guias/";
	public static String Ruta_Archivo="";
	public static String Ruta_Escenario="";
	public static String Ruta_Final="";
	static boolean Creada_Ruta_Raiz = false;
	static String Ruta_Plantilla="";
	
	public static boolean crearArchvivo(String rutaEscenario) {
		return  Creada_Ruta_Raiz = CreadorPdf.crearArchivo(Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+ 1+".pdf");
		
	}
	
	public static void crearPdf(int vueltaEjecucion, String rutaEscenario, TituloPortada tituloPortada, Descripcion descripcion,Sprint sprint) {
		Ruta_Escenario=rutaEscenario;
		Ruta_Final=Ruta_Raiz+Ruta_Escenario+"/"; //creamos la ruta para el escenario
		Ruta_Archivo=Ruta_Final+ rutaEscenario;//creamos la ruta para el archvivo
		Ruta_Plantilla=Ruta_Raiz+Ruta_Escenario+"/plantilla.pdf";
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		Creada_Ruta_Raiz=true;
		if (Creada_Ruta_Raiz) {
			System.out.println("SÍ SE HA CREADO LA RUTA" + " vuelta ejecucion " + vueltaEjecucion);
			if (vueltaEjecucion == 1) {
				System.out.println("TITULO "+ tituloPortada.getTitulo() ); 
				CreadorPdf.escribePlantilla(Ruta_Plantilla, tituloPortada, descripcion, sprint);
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
				fusionarPdfs(Ruta_Plantilla, Ruta_Archivo);
			}
			
		}
	}
	
	public static void fusionarPdfs(String rutaPlantilla, String rutaArchivo) {
		String rutasArchivos[] = { rutaPlantilla, rutaArchivo+"1.pdf"};
		CreadorPdf.fusionaPdfs(rutaArchivo+"Final.pdf", rutasArchivos);
	}



	
}

package utiles.crearPdf;

import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class PdfCambioDeEditorTexto {

	public static String Ruta_Archivo="";
	public static String Ruta_Escenario="";
	public static String Ruta_Final="";
	static String Ruta_Raiz = "./documentos/Editor_Texto/";
	static boolean Creada_Ruta_Raiz = false;
	static String Ruta_Plantilla="";
	
	
	
	public static boolean crearArchivo(String rutaEscenario) {
		return  Creada_Ruta_Raiz = CreadorPdf.crearArchivo(Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+ 1+".pdf");
		
	}

	public static void crearPdf(int vueltaEjecucion, String rutaEscenario, TituloPortada tituloPortada,Descripcion descripcion, Sprint sprint) {
		Ruta_Escenario=rutaEscenario;
		Ruta_Final=Ruta_Raiz+Ruta_Escenario+"/"; //creamos la ruta para el escenario
		Ruta_Archivo=Ruta_Final+ rutaEscenario;//creamos la ruta para el archvivo
		Ruta_Plantilla=Ruta_Raiz+Ruta_Escenario+"/plantilla.pdf";
	/*	System.out.println(" ruta escenario: " + Ruta_Escenario );
		System.out.println("ruta Raiz: " + Ruta_Raiz );
		System.out.println("ruta Final " + Ruta_Final);
		System.out.println("archivo: " +Ruta_Archivo);
		System.out.println("ruta plantilla " + Ruta_Plantilla);
		System.out.println("archivo: " +Ruta_Archivo);*/
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		Creada_Ruta_Raiz=true;
		if (Creada_Ruta_Raiz) {
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

package utiles.crearPdf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.cucumber.java.Scenario;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class PdfLogin extends FactoryMethodPdf {

	public static String Ruta_Archivo="";
	public static final String Ruta_Raiz = "./documentos/login/";
	public static String Ruta_Escenario="";
	public static String Ruta_Final="";
	static boolean Creada_Ruta_Generica_Login =false;
	static String Ruta_Plantilla = "";
	
	//esta funcion solo debe ejecutarse la primera vez que se llama en FactoriaPDF
	public static boolean crearArchvivo(String rutaEscenario) {
	    //   System.out.println("crear ruta "  + Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+1+".pdf" );
		 Creada_Ruta_Generica_Login = CreadorPdf.crearArchivo(Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+ 1 + ".pdf");
		 return Creada_Ruta_Generica_Login;
	}
	
	public static void crearPdf(int vueltaEjecucion, String nombreEscenario, TituloPortada tituloPortada, Descripcion descripcion, Sprint sprint) {
		Ruta_Escenario=nombreEscenario;
		Ruta_Final=Ruta_Raiz+Ruta_Escenario+"/"; //creamos la ruta para el escenario
		Ruta_Archivo=Ruta_Final+ nombreEscenario;//creamos la ruta para el archvivo
		Ruta_Plantilla=Ruta_Raiz+Ruta_Escenario+"/plantilla.pdf";
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		Creada_Ruta_Generica_Login=true;
		if (Creada_Ruta_Generica_Login) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(Ruta_Plantilla, tituloPortada, descripcion,sprint);
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf",
						CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

			} else {
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf",CreadorPdf.IMAGENES_PARA_PDF, 
						Usuario.USUARIOS[vueltaEjecucion - 1]);
				if (vueltaEjecucion == 4) {
			
					 String rutasArchivos[] = {Ruta_Plantilla, 
							 Ruta_Archivo+"1.pdf",
							 Ruta_Archivo+"2.pdf",
							 Ruta_Archivo+"3.pdf", 
							 Ruta_Archivo+"4.pdf" };
					// System.out.println("RUTA FINAL ANTES DE FUSIONAR "+ RutasPdf.RUTA_PDF_LOGIN_FINAL.getTexto());
					CreadorPdf.fusionaPdfs(Ruta_Archivo+"Final.pdf", rutasArchivos);
				}
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("PdfLogin No se ha creado el archivo de forma correcta");
		}
	}
	
	
	/*
	public static void crearPdf(int vueltaEjecucion) {
	
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica_Login) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(Ruta_Plantilla, TituloPortada.TITULO_LOGIN, Descripcion.DESCRIPCION_LOGIN,
						Sprint.Sprint1);
				System.out.println("METODO " +PdfLogin.Ruta_Generica_Login);
				CreadorPdf.escribeDocumento(Ruta_Generica_Login + vueltaEjecucion + ".pdf",
						CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion - 1]);

			} else {
				CreadorPdf.escribeDocumento(Ruta_Generica_Login + vueltaEjecucion + ".pdf",
						CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion - 1]);
				if (vueltaEjecucion == 4) {
					CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_LOGIN_FINAL, rutas);
				}
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
	
	
	*/
	
	private static List<String> crearRutasParaCadaEscenario(Scenario scenario) {
		Collection<String>tags=scenario.getSourceTagNames();
		List <String> rutasEscenarios=new ArrayList<String>();
		System.out.println("dentro tamanio "  + tags.size());
		for(String tag:tags) {
			System.out.println("Estoy dentro del pdfLogin tag " + tag);
				rutasEscenarios.add("./documentos/login/login"+"/"+tag);
		}
		return rutasEscenarios;
	}









	
	
}

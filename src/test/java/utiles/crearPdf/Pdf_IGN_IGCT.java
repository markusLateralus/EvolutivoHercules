package utiles.crearPdf;

import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class Pdf_IGN_IGCT extends FactoryMethodPdf{
	public static String Ruta_Archivo="";
	public static String Ruta_Escenario="";
	public static String Ruta_Final="";
	static String Ruta_Raiz = "./documentos/evaluaciones/consulta_evaluacion/";
	static boolean Creada_Ruta_Raiz = false;
	static String Ruta_Plantilla="";

	public static boolean crearArchvivo(String rutaEscenario) {
		
		return  Creada_Ruta_Raiz = CreadorPdf.crearArchivo(Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+ 1+".pdf");
	}
	public static void crearPdf(int vueltaEjecucion,String rutaEscenario,TituloPortada titluoPortada, Descripcion descripcion, Sprint sprint) {
		Ruta_Escenario=rutaEscenario;
		Ruta_Final=Ruta_Raiz+Ruta_Escenario+"/"; //creamos la ruta para el escenario
		Ruta_Archivo=Ruta_Final+ rutaEscenario;//creamos la ruta para el archvivo
		Ruta_Plantilla=Ruta_Raiz+Ruta_Escenario+"/plantilla.pdf";
	/*	System.out.println(" ruta escenario: " + Ruta_Escenario );
		System.out.println("ruta Raiz: " + Ruta_Raiz );
		System.out.println("ruta Final " + Ruta_Final);
		System.out.println("archivo: " +Ruta_Archivo);
		System.out.println("ruta plantilla " + Ruta_Plantilla);*/
		System.out.println("archivo: " +Ruta_Archivo);
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		Creada_Ruta_Raiz=true;
		if (Creada_Ruta_Raiz) {
			System.out.println("SÍ SE HA CREADO LA RUTA" + " vuelta ejecucion " + vueltaEjecucion);
			if (vueltaEjecucion == 1) {
			
				CreadorPdf.escribePlantilla(Ruta_Plantilla, titluoPortada, descripcion, sprint);
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
			} else{
				
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);
				if (vueltaEjecucion == 4) {
					
					 String rutasArchivos[] = { Ruta_Plantilla, 
							 Ruta_Archivo+"1.pdf",
							 Ruta_Archivo+"2.pdf",
							 Ruta_Archivo+"3.pdf", 
							 Ruta_Archivo+"4.pdf" };
					 for(int i=0; i<rutasArchivos.length;i++) {
						 System.out.println("RUTA ARCHIVO " + rutasArchivos[i]);
					 }
				//	CreadorPdf.fusionarPdf(CreadorPdf.RUTA_PDF_EVALUACIONES_CONSULTAEVALUACION_IGN_Boton1_FINAL, rutas);
					CreadorPdf.fusionaPdfs(Ruta_Archivo+"Final.pdf", rutasArchivos);
				}
			}
		}else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("Desde Pdf_IGN_IGCT No se ha creado el archivo de forma correcta");
		}
	}
}

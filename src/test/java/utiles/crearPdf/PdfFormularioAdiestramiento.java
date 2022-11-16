package utiles.crearPdf;

import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.CreadorPdf;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.componentesDelPdf.Usuario;

public class PdfFormularioAdiestramiento extends FactoryMethodPdf{

	
	static String Ruta_Raiz = "./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/";
	static boolean Creada_Ruta_Generica =true;// CreadorPdf.crearArchivo(Ruta_Generica_Descarga_FormularioAdiestramiento + 1 + ".pdf");
	public static String Ruta_Archivo="";
	public static String Ruta_Escenario="";
	public static String Ruta_Final="";
	static boolean Creada_Ruta_Raiz = false;
	static String Ruta_Plantilla="";
	public static boolean crearArchivo(String rutaEscenario) {
		return  Creada_Ruta_Generica = CreadorPdf.crearArchivo(Ruta_Raiz+rutaEscenario+"/"+rutaEscenario+ 1+".pdf");
		
	}
	
	public static void crearPdf(int vueltaEjecucion,String rutaEscenario,TituloPortada tituloPortada,Descripcion descripcion,Sprint sprint) {
		// TODO Auto-generated method stub
		Ruta_Escenario=rutaEscenario;
		Ruta_Final=Ruta_Raiz+Ruta_Escenario+"/"; //creamos la ruta para el escenario
		Ruta_Archivo=Ruta_Final+ rutaEscenario;//creamos la ruta para el archvivo
		Ruta_Plantilla=Ruta_Raiz+Ruta_Escenario+"/plantilla.pdf";
		System.out.println("RUTA PLANTILLA " + Ruta_Plantilla);
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		Creada_Ruta_Generica=true;
		if (Creada_Ruta_Generica) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(Ruta_Plantilla, tituloPortada, descripcion, sprint);
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	
						
			} else{
				CreadorPdf.escribeDocumento(Ruta_Archivo + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	

				if (vueltaEjecucion == 4) {
					
					 String rutasArchivos[] = { Ruta_Plantilla, 
							 Ruta_Archivo+"1.pdf",
							 Ruta_Archivo+"2.pdf",
							 Ruta_Archivo+"3.pdf", 
							 Ruta_Archivo+"4.pdf" };
					 for(String archivo:rutasArchivos) {
						 System.out.println("ARCHIVO: " + archivo.toString());
					 }
					
					CreadorPdf.fusionaPdfs(Ruta_Archivo+"Final.pdf", rutasArchivos);
				}
			}
		}else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("PDF formularioAdiestramiento -No se ha creado el archivo de forma correcta");
		}
	}



	
	

	/*
	public static void crearPdfPara1UsuarioEnumerado(int vueltaEjecucion) {
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_DESCARGAR_FORMULARIOADIESTRAMIENTO, Descripcion.DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO, Sprint.Sprint3);
				CreadorPdf.escribeDocumento(Ruta_Generica_Descarga_FormularioAdiestramiento + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	
					
				//	CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_DOCUMENTACION_FORMULARIOADIESTRAMIENTO_FINAL, rutas);
				}
			

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
	public static void fusionarPdfs() {
		CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_DOCUMENTACION_FORMULARIOADIESTRAMIENTO_FINAL, rutas);
	}
	*/
}

package utiles.pdf;

import utiles.capturasPantallas.CapturaPantalla;

public class PdfLogin extends FactoryMethodPdf{

	static String Ruta_Generica_Login = "./documentos/login/login";
	static boolean 		Creada_Ruta_Generica_Login = CreadorPdf.crearArchivo(Ruta_Generica_Login + 1 + ".pdf");
	static String plantilla="./documentos/login/plantilla.pdf";
	static String rutas[] = { "./documentos/login/plantilla.pdf", 
								"./documentos/login/login1.pdf",
								"./documentos/login/login2.pdf", 
								"./documentos/login/login3.pdf",
								"./documentos/login/login4.pdf" };
	
	public static void crearPdf(int vueltaEjecucion) {

		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica_Login) {
			if (vueltaEjecucion == 1) {
			//	CreadorPdf.crearPlantilla(plantilla, CreadorPdf.TITULO_LOGIN, CreadorPdf.DESCRIPCION_LOGIN, CreadorPdf.Sprint1);
				CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_LOGIN, Descripcion.DESCRIPCION_LOGIN, Sprint.Sprint1);

			//	CreadorPdf.escribir(Ruta_Generica_Login + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(Ruta_Generica_Login + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

			} else {
				//CreadorPdf.escribir(Ruta_Generica_Login + vueltaEjecucion + ".pdf", CreadorPdf.imagenes,CreadorPdf.USUARIOS[vueltaEjecucion - 1]);
				CreadorPdf.escribeDocumento(Ruta_Generica_Login + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);

				if (vueltaEjecucion == 4) {
				
					//CreadorPdf.fusionarPdf(CreadorPdf.RUTA_PDF_LOGIN_FINAL, rutas);
					CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_LOGIN_FINAL, rutas);
					
				}
			}

		} else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
		}
	}
}

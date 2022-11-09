package utiles.pdf;

import utiles.capturasPantallas.CapturaPantalla;

public class PdfFormularioAdiestramiento extends FactoryMethodPdf{

	
	static String Ruta_Generica_Descarga_FormularioAdiestramiento = "./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/descargarFormulario";
	static boolean Creada_Ruta_Generica = CreadorPdf.crearArchivo(Ruta_Generica_Descarga_FormularioAdiestramiento + 1 + ".pdf");
	static String plantilla="./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/plantilla.pdf";
	static String rutas[] = {
			"./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/plantilla.pdf", 
			"./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/descargarFormulario1.pdf",
			"./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/descargarFormulario2.pdf",
			"./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/descargarFormulario3.pdf",
			"./documentos/Documentacion/Asociacion_Empleado_Puesto/FormularioAdiestramiento/descargarFormulario4.pdf"
			};
	

	public static void crearPdf(int vueltaEjecucion) {
		// TODO Auto-generated method stub
		CreadorPdf.IMAGENES_PARA_PDF = CapturaPantalla.ImagenesPNG;
		if (Creada_Ruta_Generica) {
			if (vueltaEjecucion == 1) {
				CreadorPdf.escribePlantilla(plantilla, TituloPortada.TITULO_DESCARGAR_FORMULARIOADIESTRAMIENTO, Descripcion.DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO, Sprint.Sprint3);
				CreadorPdf.escribeDocumento(Ruta_Generica_Descarga_FormularioAdiestramiento + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	
						
			} else{
				CreadorPdf.escribeDocumento(Ruta_Generica_Descarga_FormularioAdiestramiento + vueltaEjecucion + ".pdf", CreadorPdf.IMAGENES_PARA_PDF, Usuario.USUARIOS[vueltaEjecucion-1]);	

				if (vueltaEjecucion == 4) {
					
					CreadorPdf.fusionaPdfs(RutasPdf.RUTA_PDF_DOCUMENTACION_FORMULARIOADIESTRAMIENTO_FINAL, rutas);
				}
			}
		}else {// en caso de que falle el método Pdf.crearArchivo()
			System.out.println("No se ha creado el archivo de forma correcta");
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

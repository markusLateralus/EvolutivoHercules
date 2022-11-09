package utiles.pdf;

public class FactoriaPDF {

	int valor=0;
	public static void crearPdf(int valor, int vueltaEjecucion) {
		if(valor==0) {		
		PdfLogin.crearPdf(vueltaEjecucion);	
		}
		if(valor==1) {
		PdfConsultaDocumentos.crearPdf(vueltaEjecucion);
		}
		if(valor==2) {
			PdfCoordinacion.crearPdf(vueltaEjecucion);
		}
		if(valor==3) {
			Pdf_IGN_Boton1.crearPdf(vueltaEjecucion);
		}
		if(valor==4) {
			Pdf_IGN_Boton2.crearPdf(vueltaEjecucion);
		}
		if(valor==5) {
			Pdf_IGCT.crearPdf(vueltaEjecucion);
		}
		if(valor==6) {
			PdfInstruccionesGuia.crearPdf(vueltaEjecucion);
			PdfInstruccionesGuia.fusionarPdfs();
		}
		if(valor==7) {
			PdfFormularioAdiestramiento.crearPdf(vueltaEjecucion);
			
		
		}
		
		
	}
}

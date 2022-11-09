package utiles.pdf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
import com.itextpdf.layout.Document;

import net.thucydides.core.util.EnvironmentVariables;

public class LecturaPdf {

	public static PdfPage page;
	public static String RUTA;

	public static String leer(String archivo) {
		PdfReader pdfReader;
		PdfDocument pdfDocument;
		String texto = "";

		try {
			RUTA="C:/Users/mraralma/Downloads/"+archivo;
			pdfReader = new PdfReader(RUTA);
			pdfDocument = new PdfDocument(pdfReader);
			int totalPaginas = pdfDocument.getNumberOfPages();
			page = pdfDocument.getPage(1);

			for (int i = 1; i <= totalPaginas; i++) {
				texto = PdfTextExtractor.getTextFromPage(page);
			}
			pdfReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// aquí va vacío

		return texto.toString().trim();
	}

	public static boolean contieneNombreTrabajador(String texto, String nombre) {
		boolean encontrado=false; 
		if (texto.contains(nombre)) {	
			encontrado=true;
			return encontrado;
		}
		return encontrado;
	}

	public static boolean contieneDNI(String texto, String dni) {
		boolean encontrado=false; 
		if (texto.contains(dni)) {
			encontrado=true;
			return encontrado;
		}

		return encontrado;
	}
	
	public static boolean buscarOtroArchivo(String archivoOriginal, String archivoCopia) {
		boolean encontrado=false; 
		if (archivoOriginal.contains(archivoCopia)) {
			encontrado=true;
			return encontrado;
		}

		return encontrado;
	}

}

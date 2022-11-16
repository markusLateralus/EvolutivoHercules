package utiles.componentesDelPdf;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;


public class CreadorPdf {

	public static Map<String, File> IMAGENES_PARA_PDF = new LinkedHashMap<>();

	public static boolean crearArchivo(String ruta) {
		File file = new File(ruta);
		boolean creado = false;
		if (!file.exists()) {
			try {
				creado = file.createNewFile();
			//	System.out.println("primera vuelta-NO EXISTE ARCHIVO " + creado);
				return creado;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
		//	System.out.println("segunda vuelta SI EXISTE ARCHIVO " + creado);
			return creado;

		}
		return creado;
	}


	public static void fusionaPdfs(RutasPdf rutaFinal, String rutas[]) {
		PdfDocument pdf;
		PdfMerger merger;
		PdfDocument pdfDocumentPlantilla;
		try {
			pdf = new PdfDocument(new PdfWriter(rutaFinal.getTexto()));
			merger = new PdfMerger(pdf);

			for (int i = 0; i < rutas.length; i++) {
				pdfDocumentPlantilla = new PdfDocument(new PdfReader(rutas[i]));// OJO la primera ruta es el archivo
																				// PLANTILLA
				merger.merge(pdfDocumentPlantilla, 1, pdfDocumentPlantilla.getNumberOfPages());
				pdfDocumentPlantilla.close();
			}
			merger.close();
			pdf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void fusionaPdfs(String rutaFinal, String rutas[]) {
		PdfDocument pdf;
		PdfMerger merger;
		PdfDocument pdfDocumentPlantilla;
		try {
			pdf = new PdfDocument(new PdfWriter(rutaFinal));
			merger = new PdfMerger(pdf);

			for (int i = 0; i < rutas.length; i++) {
				pdfDocumentPlantilla = new PdfDocument(new PdfReader(rutas[i]));// OJO la primera ruta es el archivo
																				// PLANTILLA
				merger.merge(pdfDocumentPlantilla, 1, pdfDocumentPlantilla.getNumberOfPages());
				pdfDocumentPlantilla.close();
			}
			merger.close();
			pdf.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void agregarMarcaAgua(Document document) {
		ImageData imageDataMarcaIbermatica;
		Image imageMarcaIbermatica;
		String rutaMarcaIbermatica = "./imagenes/ibermaticaMARCAagua.png";
		try {
			imageDataMarcaIbermatica = ImageDataFactory.create(rutaMarcaIbermatica);
			imageMarcaIbermatica = new Image(imageDataMarcaIbermatica);
			imageMarcaIbermatica.setFixedPosition(document.getPdfDocument().getDefaultPageSize().getWidth() / 2 - 125,
					document.getPdfDocument().getDefaultPageSize().getHeight() / 2 - 450);
			imageMarcaIbermatica.setOpacity(0.5f);
			document.add(imageMarcaIbermatica);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void escribePlantilla(String fichero, TituloPortada tituloPortada, Descripcion descripcion, Sprint sprint) {

		PdfWriter pdfWriter;
		PdfDocument pdfDocument;
		Document document;
		try {

			pdfWriter = new PdfWriter(fichero);
			pdfDocument = new PdfDocument(pdfWriter);
			document = new Document(pdfDocument);
			agregarMarcaAgua(document);

			float col = 280f;
			float columnWidth[] = { col, col };
			Table tablaCabecera = new Table(columnWidth);
			tablaCabecera.setBackgroundColor(new DeviceRgb(63, 169, 219));
			tablaCabecera.setFontColor(Color.WHITE);
			tablaCabecera.addCell(new Cell().add("EVOLUTIVO HERCULES").setTextAlignment(TextAlignment.LEFT)
					.setVerticalAlignment(VerticalAlignment.MIDDLE).setMarginTop(20f).setMarginBottom(10f)
					.setFontSize(30f).setMarginLeft(10f).setBorder(Border.NO_BORDER));

			tablaCabecera.addCell(new Cell().add(sprint.getTexto()).setTextAlignment(TextAlignment.RIGHT).setMarginTop(20f)
					.setMarginBottom(20f).setFontSize(28f).setBorder(Border.NO_BORDER).setMarginRight(100f));
			document.add(tablaCabecera);
			///////////////// fin tabla Cabecera///////////////////////
			Calendar cal = Calendar.getInstance();
			Date fecha = new Date(cal.getTimeInMillis()); //
			// SimpleDateFormat formatoDia = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat formatoDia = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
			float columna = 840f;
			float columnWidth2[] = { columna };
			Table tablaFecha = new Table(columnWidth2);
			tablaFecha.setBackgroundColor(new DeviceRgb(63, 169, 219));
			tablaFecha.setFontColor(Color.WHITE);
			tablaFecha.addCell(
					new Cell().add("Fecha ejecucion: " + formatoDia.format(fecha)).setTextAlignment(TextAlignment.LEFT)
							.setMarginTop(0f).setMarginBottom(20f).setBorder(Border.NO_BORDER).setMarginLeft(10f));
			document.add(tablaFecha);

			///////////////// fin tabla Fecha///////////////////////
			// float columna=840f; //
			// float columnWidth2[]= {columna};
			Table tablaTitulo = new Table(columnWidth2);
			tablaTitulo.setBackgroundColor(new DeviceRgb(63, 169, 219));
			tablaTitulo.setFontColor(Color.WHITE);
			tablaTitulo.addCell(new Cell().add(tituloPortada.getTitulo()).setTextAlignment(TextAlignment.LEFT)
					.setVerticalAlignment(VerticalAlignment.MIDDLE).setMarginTop(10f).setMarginBottom(10f)
					.setFontSize(16f).setBorder(Border.NO_BORDER));
			document.add(new Paragraph("\n"));
			document.add(tablaTitulo);
			Paragraph parrafoDescripcion = new Paragraph();
			parrafoDescripcion.add(descripcion.getDescripcion());
			document.add(parrafoDescripcion);
			document.close();
		} catch (IOException e) {

		}
	}

	public static void escribeDocumento(String rutaArchivo, Map<String, File> imagenes2, Usuario usuario) {

		PdfWriter pdfWriter;
		ImageData imageData;
		Image image;
		PdfDocument pdfDocument;
		Document document;

		try {

			pdfWriter = new PdfWriter(rutaArchivo);
			pdfDocument = new PdfDocument(pdfWriter);
			document = new Document(pdfDocument);
			Calendar cal = Calendar.getInstance();
			Date fecha = new Date(cal.getTimeInMillis()); //
			// SimpleDateFormat formatoDia = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			// SimpleDateFormat formatoDia =new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

			Map<String, File> imagenesAlInverso = imagenes2;//invertirListaImagenes(imagenes2);
			Paragraph parrafoPasos;
			Paragraph parrafoNombreUsuario;
			Set<String> claves = imagenesAlInverso.keySet();
			for (String clave : claves) {
				imageData = ImageDataFactory.create(imagenesAlInverso.get(clave).getPath());
				image = new Image(imageData);
				image.setHeight(image.getImageHeight() - 160);
				image.setWidth(image.getImageWidth() - 150);
				image.setMarginLeft(-25f);
				// image.setBackgroundColor(new DeviceRgb(63,169, 219));
				image.setUnderline();
				document.add(image);
				// clave + " " + formatoHora.format(fecha) + " USUARIO: " +usuario
				parrafoNombreUsuario = new Paragraph();
				parrafoNombreUsuario.setFontSize(10f);
				parrafoNombreUsuario.add("- Rol: " + usuario.getTexto() + ".");
				document.add(parrafoNombreUsuario);
				parrafoPasos = new Paragraph();
				parrafoPasos.setFontSize(12f);
				parrafoPasos.add("- " + clave + " , Hora: " + formatoHora.format(fecha));// descripcion de los pasos
				document.add(parrafoPasos);
				agregarMarcaAgua(document);
			}
			document.close();
			// pdfDocument.close();

		} catch (MalformedURLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // TODO Auto-generated catch
			e.printStackTrace();
		}
	}	
	
	
	
	public static <K extends Comparable, V> Map<String, File> invertirListaImagenes(Map<String, File> map) {
		// crea una lista de claves de mapa y la ordena
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys, Collections.reverseOrder());
		// crea un `LinkedHashMap` vacío
		Map<String, File> linkedHashMap = new LinkedHashMap<>();
		// usa `ListIterator` para iterar la lista
		ListIterator<String> itr = keys.listIterator();
		// para cada clave en la lista ordenada, inserte el par clave-valor
		// en `LinkedHashMap`
		while (itr.hasNext()) {
			String key = itr.next();
			linkedHashMap.put(key, map.get(key));
		}

		return linkedHashMap;
	}

}
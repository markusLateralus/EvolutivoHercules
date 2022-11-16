package utiles.crearPdf;

import java.io.File;
import java.io.IOException;

public class Archivo {

	private String ruta;
	private File file; 
	public Archivo(String ruta) {
		this.file = new File(ruta);
	}
	
	public  boolean crearArchivo() {
	//this.file = new File(ruta);
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

}

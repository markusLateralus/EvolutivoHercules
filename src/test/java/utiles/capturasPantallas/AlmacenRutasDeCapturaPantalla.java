package utiles.capturasPantallas;

public class AlmacenRutasDeCapturaPantalla {

	public static int VALOR_RUTA=6;
	public static String Ruta_Escenario="";
	public static void setValorRuta(int valor) {
		VALOR_RUTA=valor;
	}
	
	public static void guardarRuta(String descripcion, String tituloImagen) {
		if(VALOR_RUTA==0) {
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[0]+Ruta_Escenario+"/",descripcion,tituloImagen);
		}else if(VALOR_RUTA==1) {
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[1]+Ruta_Escenario+"/",descripcion,tituloImagen);
		}else if(VALOR_RUTA==2) {
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[2]+Ruta_Escenario+"/",descripcion,tituloImagen);
		}else if(VALOR_RUTA==3) {
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[3]+Ruta_Escenario+"/",descripcion,tituloImagen);
		}else if(VALOR_RUTA==4) {
		CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[4]+Ruta_Escenario+"/",descripcion,tituloImagen);
		}else if(VALOR_RUTA==5) {
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[5]+Ruta_Escenario+"/",descripcion,tituloImagen);
			
		}else if(VALOR_RUTA==6) {
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[6]+Ruta_Escenario+"/",descripcion,tituloImagen);
			
		}else if(VALOR_RUTA==7){
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[7]+Ruta_Escenario+"/",descripcion,tituloImagen);
			
		}else if(VALOR_RUTA==8){
			CapturaPantalla.guardarCapturaPantalla(CapturaPantalla.RUTAS_IMAGENES[8]+Ruta_Escenario+"/",descripcion,tituloImagen);

		
		}else {
		
			System.out.println("NO HAY MAS RUTAS ESTABLECIDAS");
		}
		
	}
}

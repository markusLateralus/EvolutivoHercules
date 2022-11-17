package utiles.capturasPantallas;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class CapturaPantalla extends UIInteractionSteps{
	
//	public static List<File>ficherosPNG=new ArrayList();
	public static String RUTA_IMAGEN_LOGIN="./documentos/login/";
	public static String RUTA_IMAGEN_DOCUMENTACION_COORDINACIONCLIENTE_CONSULTADOCUMENTACION="./documentos/consulta_documentos/";
	public static String RUTA_IMAGEN_DOCUMENTACION_COORDINACIONCLIENTE_COORDINACION="./documentos/coordinacion/";
	public static String RUTA_IMAGEN_EVALUACIONES_CONSULTAEVALUACION_IGN_IGCT="./documentos/evaluaciones/consulta_evaluacion/";
	public static String RUTA_IMAGEN_HERRAMIENTAS_ADMINISTRACION_INSTRUCIONESGUIAS="./documentos/instrucciones_guias/";
	public static String RUTA_IMAGEN_DOCUMENTACION_ASOCIACIONEMPLEADOPUESTO_FORMULARIOADIESTRAMIENTO="./documentos/FormularioAdiestramiento/";
	public static String RUTA_IMAGEN_ALTA_DE_USUARIO="./documentos/AltaDeUsuario/";
	public static String RUTA_IMAGEN_MODIFICACION_PERFIL_TECNICODEZONA="./documentos/ModificacionPerfilTecnicoDeZona/";
	public static String RUTAS_IMAGENES[]= {
							RUTA_IMAGEN_LOGIN,
							RUTA_IMAGEN_DOCUMENTACION_COORDINACIONCLIENTE_CONSULTADOCUMENTACION,
			                RUTA_IMAGEN_DOCUMENTACION_COORDINACIONCLIENTE_COORDINACION,
						    RUTA_IMAGEN_EVALUACIONES_CONSULTAEVALUACION_IGN_IGCT,
						  RUTA_IMAGEN_HERRAMIENTAS_ADMINISTRACION_INSTRUCIONESGUIAS,
						  RUTA_IMAGEN_DOCUMENTACION_ASOCIACIONEMPLEADOPUESTO_FORMULARIOADIESTRAMIENTO,
						  RUTA_IMAGEN_ALTA_DE_USUARIO,
						  RUTA_IMAGEN_MODIFICACION_PERFIL_TECNICODEZONA};
	
	
	
	public static Map<String,File>ImagenesPNG=new LinkedHashMap<>();
	 //  Map<String,File> linkedHashMap = new LinkedHashMap<>();
	
	public static int CONTADOR_VUELTAS_APLICACION=1;
	
	public static void guardarCapturaPantalla(String ruta,String descripcion, String titulo) {
		 File file=((TakesScreenshot)Serenity.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(file, new File(ruta+titulo+CONTADOR_VUELTAS_APLICACION+".png"));
				file=new File(ruta+titulo+CONTADOR_VUELTAS_APLICACION+".png");
				ImagenesPNG.put(descripcion,file);
		
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	/*
	 public void hacerCapturaPantalla(String titulo) {
		  File file=((TakesScreenshot)this.getDriver()).getScreenshotAs(OutputType.FILE);
			try {
					FileUtils.copyFile(file, new File("./documentos/"+titulo+".png"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
	 
	 public static void capturaError(WebDriver driver, String filename) {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		  try {
		   FileUtils.copyFile(source, new File("./errores/"+filename+"_"+dateName+".png"));
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.getMessage();
		  }
		 }
}

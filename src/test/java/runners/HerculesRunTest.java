package runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty", "html:./documentos/resumen.html" }, monochrome = true,
		 features="src/test/resources/features/login/login.feature",//0
		// features="src/test/resources/features/Documentacion/Coordinacion_Cliente/Consulta_Documentos/DescargarConsultaDocumentos.feature",//1
		// features="src/test/resources/features/Documentacion/Coordinacion_Cliente/Coordinacion/DescargarCoordinacion.feature",//2
       //  features = "src/test/resources/features/Evaluaciones/Consulta_Evaluacion/DescargaDocumentosAsociadosIGNeIGCT.feature", //3
		// features="src/test/resources/features/Evaluaciones/Consulta_Evaluacion/DescargarIGN_boton1.feature",//
		//features = "src/test/resources/features/Evaluaciones/Consulta_Evaluacion/DescargarIGN_boton2.feature", // 
		// features="src/test/resources/features/Evaluaciones/Consulta_Evaluacion/DescargarIGCT.feature", //
	     //  features="src/test/resources/features/Herramientas/Administracion/Instrucciones_Guias/DescargarInstruccionesGuias.feature",//6
//////////////////////////////////FIN SPRINT 1////////////////////////////////////////////////////////////////////		

       //  features="src/test/resources/features/Documentacion/Asociacion_Empleado_Puesto/DescargarFormularioAdiestramientoParametrizado.feature", //7 

///////////////////////////////FIN SPRINT 3 ///////////////////////////////////////////////////////
       

    	glue = "steps")
      //   tags = ("@descargarFormulario") )
	
public class HerculesRunTest {

}

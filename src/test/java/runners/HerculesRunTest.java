package runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = { "pretty"}, monochrome = true, //salida de consola más legible
		features="src/test/resources/features/login/login.feature",//0
		// features="src/test/resources/features/Consulta_Documentos/DescargarConsultaDocumentos.feature",//1
		// features="src/test/resources/features/Coordinacion/DescargarCoordinacion.feature",//2 
        // features = "src/test/resources/features/Evaluaciones/Consulta_Evaluacion/DescargaDocumentosAsociadosIGNeIGCT.feature", //3
	    //   features="src/test/resources/features/Instrucciones_Guias/DescargarInstruccionesGuias.feature",//4

//////////////////////////////////FIN SPRINT 1////////////////////////////////////////////////////////////////////		

        // features="src/test/resources/features/FormularioAdiestramiento/DescargarFormularioAdiestramientoParametrizado.feature", //5  

///////////////////////////////FIN SPRINT 3 ///////////////////////////////////////////////////////
       
     // features="src/test/resources/features/AltaDeUsuario/altaDeUsuario.feature",   //6
     // features="src/test/resources/features/ModificacionPerfilTecnicoDeZona/ModificacionPerfilTecnicoDeZona.feature",   //7
///////////////////////////////FIN SPRINT 4 ///////////////////////////////////////////////////////
    	glue = "steps",
        tags = ("@loginCorrecto" ) )
	
public class HerculesRunTest {

}

package steps;

import java.util.Collection;
import java.util.List;

import escritorio.NavegaAadministracionUsuarios;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import login.Navega;
import menu.Herramientas.Administracion.Seguridad.Usuarios.AdministracionUsuario.ModificaRoles;
import modelo.Rol;
import modelo.Usuario;
import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;

public class ModificacionPerfilTecnicoDeZonaStep {

	
	private static int CONTADOR=1;
	private String rutaEscenario="";
	@Steps 
	Navega navega;
	
	@Steps
	Logarse logarse;
	
	@Steps
	NavegaAadministracionUsuarios rutaParaIrAdministracionUsuarios;
	@Steps
	ModificaRoles modificaRoles;
	
	

	@Before("@altaUsuario or @bajaUsuario")
	public void antes(Scenario escenario) {
		//reiniciamos los contadores
		if(CONTADOR==2)CONTADOR=1;
		if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==2)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1; //solo es un usuario
		
		Collection<String> etiquetas=escenario.getSourceTagNames();
		for(String esc: etiquetas) {
			rutaEscenario=esc;	
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		AlmacenRutasDeCapturaPantalla.setValorRuta(6);
	}
		



@After("@altaUsuario or @bajaUsuario")
public void guardar() {
	FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,	CapturaPantalla.CONTADOR_VUELTAS_APLICACION,rutaEscenario,TituloPortada.ALTA_DE_USUARIO,
			Descripcion.ALTA_DE_USUARIO,Sprint.Sprint4 );

	CONTADOR++;
	//reseteamos las rutas
	AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
	rutaEscenario="";

      
       }

}

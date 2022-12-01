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
import menu.Herramientas.Administracion.Seguridad.Usuarios.ModificaRoles;
import modelo.Rol;
import modelo.Usuario;
import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;

public class AltaDeUsuarioStep {

	
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
		
	
	
	@Given("el usuario se loga en Hercules")
	public void el_usuario_se_loga_en_hercules(io.cucumber.datatable.DataTable dataTable) {
		navega.aLogin();
		List<List<String>> rows = dataTable.asLists(String.class);
		for (List<String> row : rows) {
			Usuario.agregar(new Usuario(row.get(0), row.get(1), row.get(2)));
		}
		
	//logarse.rellenarUsuario(Usuario.usuarios.get(CONTADOR).nombre);
	//logarse.rellenarPassword(Usuario.usuarios.get(CONTADOR).password);
	//logarse.pulsarBotonLogin();
	logarse.conUsuarioYpassword(Usuario.usuarios.get(CONTADOR).nombre, Usuario.usuarios.get(CONTADOR).password);
	
	}
	@Given("el usuario se dirige a la pantalla Administracion Usuarios")
	public void el_usuario_se_dirige_a_la_pantalla_administracion_usuarios() {
		rutaParaIrAdministracionUsuarios.accede();
	}
	@Given("el usuario busca un rol y selecciona el usuario de la tabla")
	public void el_usuario_busca_un_rol_y_selecciona_el_usuario_de_la_tabla(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> rows = dataTable.asLists(String.class);
		for (List<String> row : rows) {
			Rol.agregarRol(row.get(0));
		}
		for(String r:Rol.LISTA) {
		System.out.println("rol " +r );
		}
		modificaRoles.buscaRolYseleccionalo(Rol.LISTA.get(CONTADOR));
		
	}
	@Given("el usuario cambia el rol a Tecnico de Zona")
	public void el_usuario_cambia_el_rol_a_tecnico_de_zona() {
		modificaRoles.cambiarDeRol();
	}

	@When("el usuario agrega el nuevo cliente {string}")
	public void el_usuario_agrega_el_nuevo_cliente(String string) {
		modificaRoles.agregarNuevoCliente(string);
	}
	@Then("el usuario puede comprobar que el cliente esta en la lista")
	public void el_usuario_puede_comprobar_que_el_cliente_esta_en_la_lista() {
	    modificaRoles.verificarCambios();
	}
	
	
	
	////////////////////////////
	@When("el usuario elimina el primer cliente de la lista")
	public void el_usuario_elimina_el_primer_cliente_de_la_lista() {
		modificaRoles.eliminarClienteDeLaLista();
	}

	@Then("el usuario comprueba que no está en la lista")
	public void el_usuario_comprueba_que_no_está_en_la_lista() {
		modificaRoles.verificarCambios();
	}

@After("@altaUsuario or @bajaUsuario")
public void guardar(Scenario escenario) {
	Collection<String> etiquetas = escenario.getSourceTagNames();
	for (String etiqueta : etiquetas) {
		if (etiqueta.equalsIgnoreCase("@altaUsuario")) {
			FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
					CONTADOR, rutaEscenario, TituloPortada.ALTA_DE_USUARIO,
					Descripcion.ALTA_DE_USUARIO, Sprint.Sprint4);
	    }else if (etiqueta.equalsIgnoreCase("@bajaUsuario")) {
		     FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
				CONTADOR, rutaEscenario,TituloPortada.BAJA_DE_USUARIO,
				Descripcion.BAJA_DE_USUARIO, Sprint.Sprint4);
        
	    }
	}

	CONTADOR++;
	//reseteamos las rutas
	AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
	rutaEscenario="";

      
       }

}

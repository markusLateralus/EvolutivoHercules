package menu.Herramientas.Administracion.Seguridad.Usuarios;

import java.time.Duration;

import org.openqa.selenium.Keys;

import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class ModificaRoles {

	
	PageUsuario pageAdministracionUsuario;
	Espera espera;
	AlmacenRutasDeCapturaPantalla almacenRutasDeCapturaPantalla;
	@Step("el usuario busca el rol {0}")
	public void buscaRolYseleccionalo(String rol) {
		Espera.obligatoriamente(2000);
		this.escribeRol(rol);
		Espera.obligatoriamente(1000);
		this.seleccionaResultadoTabla();
	}
	@Step("el usuario rellena el buscador con el rol {0}")
	private void escribeRol(String rol) {
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.CAMPO_BUSCADOR_DE_ROL);
	
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario realiza la busqueda", "buscarRol");
		}
		PageUsuario.CAMPO_BUSCADOR_DE_ROL.sendKeys(rol + Keys.ENTER);
	}
	@Step("el usuario selecciona el resultado de la tabla")
	private void seleccionaResultadoTabla() {
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.PRIMER_RESULTADO_DE_LA_TABLA);
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona el primer valor de la tabla", "seleccionaPrimerValorTabla");
		}
		PageUsuario.PRIMER_RESULTADO_DE_LA_TABLA.click();
		
	}
	
	@Step("el usuario selecciona del desplegable el rol tecnico de zona")
	public void cambiarDeRol() {
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.CAMPO_ROL);
		PageUsuario.CAMPO_ROL.click();
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.DESPLEGABLE_CAMPO_ROL);
		PageUsuario.DESPLEGABLE_CAMPO_ROL.click();
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_CLIENTES);
		PageUsuario.BOTON_CLIENTES.click();
		
		
	}
	
	@Step("el usuario agrega el nuevo cliente")
	public void agregarNuevoCliente(String cliente) {
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.CAMPO_CLIENTE);
		PageUsuario.CAMPO_CLIENTE.sendKeys(cliente );
		Espera.obligatoriamente(4000);
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario escribe el nuevo cliente", "escribirCliente");
		}
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.DESPLEGABLE_CAMPO_CLIENTE);
		PageUsuario.DESPLEGABLE_CAMPO_CLIENTE.click();
		Espera.obligatoriamente(3000);
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_ANADIR);
		PageUsuario.BOTON_ANADIR.click();
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario agrega el cliente a la lista", "agregarClienteAlista");
		}
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_ACTUALIZAR);
		PageUsuario.BOTON_ACTUALIZAR.click();
		Espera.obligatoriamente(3000);
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_SALIR);
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario guarda los cambios", "guardarCambios");
		}
		PageUsuario.BOTON_SALIR.click();
		
	}
	
	@Step("el usuario comprueba que los cambios se han guardado correctamente")
	public void verificarCambios() {
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_CLIENTES);
		PageUsuario.BOTON_CLIENTES.click();
		Espera.obligatoriamente(3000);
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario comprueba que los cambios se han guardado correctamente", "verificaLaAsignacion");
		}
	}
	
	@Step("el usuario elimina el cliente asignado de su lista")
	public void eliminarClienteDeLaLista() {
		Espera.obligatoriamente(2000);
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario elimina el cliente asignado de su lista", "eliminarCliente");
		}
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_ELIMINAR_CLIENTE);
		PageUsuario.BOTON_ELIMINAR_CLIENTE.click();
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_ACTUALIZAR);
		PageUsuario.BOTON_ACTUALIZAR.click();
		Espera.obligatoriamente(3000);
		espera.queSeaClicable(Duration.ofSeconds(5), PageUsuario.BOTON_SALIR);
		if ( almacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario guarda los cambios", "guardarCambios");
		}
		PageUsuario.BOTON_SALIR.click();
		
		
	}
}

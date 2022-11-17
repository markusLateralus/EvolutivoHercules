package menu.Herramientas.Administracion.Seguridad.Usuarios.AdministracionUsuario;

import java.time.Duration;

import org.openqa.selenium.Keys;

import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class ModificaRoles {

	
	PageAdministracionUsuario pageAdministracionUsuario;
	Espera espera;
	
	public void buscaRolYseleccionalo(String rol) {
		Espera.espera(2000);
		this.escribeRol(rol);
		Espera.espera(1000);
		this.seleccionaResultadoTabla();
	}
	private void escribeRol(String rol) {
		espera.queSeaclicable(Duration.ofSeconds(5), PageAdministracionUsuario.CAMPO_BUSCADOR_DE_ROL);
	
		if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario realiza la busqueda", "buscarRol");
		}
		PageAdministracionUsuario.CAMPO_BUSCADOR_DE_ROL.sendKeys(rol + Keys.ENTER);
	}
	private void seleccionaResultadoTabla() {
		espera.queSeaclicable(Duration.ofSeconds(5), PageAdministracionUsuario.PRIMER_RESULTADO_DE_LA_TABLA);
		if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona el primer valor de la tabla", "seleccionaPrimerValorTabla");
		}
		PageAdministracionUsuario.PRIMER_RESULTADO_DE_LA_TABLA.click();
		
	}
}

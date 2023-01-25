package escritorio;

import menu.Riesgos.ConsultaRiesgos.PageConsultaRiesgo;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.esperas.Espera;

public class NavegaA extends UIInteractionSteps {

	Espera espera = new Espera();
	PageEscritorio pageEscritorio;
	PageConsultaRiesgo pageConsultaRiesgo;
	@Step("El usuario accede a la Pantalla Consulta Riesgos")
	public void consultaRiesgo() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/riesgos/consulta-riesgos");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 8) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede a Consulta Riesgos", "irConsultaRiesgo");
		}
		///pageConsultaRiesgo.getDriver().getCurrentUrl();
    }
	@Step("El usuario accede a la Pantalla Reemplazar Responsables")
	public void reemplazarResponsables() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/evaluaciones/reemplazar-responsabilidades");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Reemplazar Responsables",
					"irReemplazarResponsables");
		}
	}
	@Step("El usuario accede a la Pantalla Publicaciones Pendientes")
	public void publicacionesPendientes() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/documentacion/publicaciones-pendientes");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Publicaciones Pendientes",
					"irConsultaRiesgos");
		}
	}
	@Step("El usuario accede a la pantalla Instruccciones Guias")
	public void instruccionesGuias() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/herramientas/administracion/instrucciones-guias");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 4) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Instrucciones Guias",
					"irInstruccionesGuias");
		}
	}
	@Step("El usuario accede a la Pantalla Editar Fichas")
	public void editarFichas() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/fichas/editar-fichas");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Editar Fichas",
					"irEditarFichas");
		}
	}
	@Step("El usuario accede a la Pantalla Coordinacion")
	public void coordinacion() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/documentacion/coordinacion-cliente/coordinacion");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 2 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Coordinacion",
					"irCoordinacion");
		}
	}
	@Step("El usuario accede a la Pantalla Consulta Evaluacion")
	public void consultaEvaluacion() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/evaluaciones/consulta-evaluacion");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 3 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Consulta Evaluación","irConsultaEvaluacion");
		}
	}
	@Step("El usuario accede a la Pantalla Consulta de documentos")
	public void consultaDocumentos() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/documentacion/coordinacion-cliente/consulta-documentos");
		if (AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 1 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Consulta Documentos",
					"irConsultaDocumentos");
		}
	}
	@Step("El usuario accede a la pantalla Asociacion Empleado Puesto")
	public void asociacionEmpleadoPuesto() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/documentacion/asociacion-empleado-puesto");
		if(AlmacenRutasDeCapturaPantalla.VALOR_RUTA==5 || AlmacenRutasDeCapturaPantalla.VALOR_RUTA==7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario selecciona Asociacion Empleado Puesto",
					"irAsociacionEmpleadoPuesto");
		}
	}
	@Step("El usuario accede a la Pantalla Alta Evaluacion")
	public void altaEvaluacion() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/evaluaciones/alta-evaluacion");
		if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 7) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede a Alta Evaluacion", "irAltaEvaluacion");
		}
	}
	@Step("El usuario accede a la pantalla Administracion Usuarios")
	public void administracionUsuarios() {
		pageEscritorio.getDriver().get("https://prehercules.eulen.com/hercules3/herramientas/administracion/seguridad/usuarios");
		if ( AlmacenRutasDeCapturaPantalla.VALOR_RUTA == 6) {
			AlmacenRutasDeCapturaPantalla.guardarRuta("El usuario accede a Administracion Usuarios", "irAdministracionUsuarios");
		}
	}

}
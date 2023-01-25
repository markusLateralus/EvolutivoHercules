package steps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assert;
import escritorio.NavegaAaltaEvaluacion;
import escritorio.NavegaAasociacionEmpleadoPuesto;
import escritorio.NavegaAconsultaDeDocumentos;
import escritorio.NavegaAconsultaEvaluacion;
import escritorio.NavegaAconsultaRiesgos;
import escritorio.NavegaAcoordinacion;
import escritorio.NavegaAeditarFichas;
import escritorio.NavegaAreemplazarResponsables;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import login.Logarse;
import login.Navega;
import menu.Evaluaciones.ConsultaEvaluacion.RealizaBusqueda;
import menu.Evaluaciones.ConsultaEvaluacion.ResultadoDeLaBusqueda;
import menu.Evaluaciones.EdicionEvaluacion.Verifica;
import menu.Evaluaciones.ReemplazarResponsable.IrAconsultaEvaluacion;
import menu.Evaluaciones.ReemplazarResponsable.ReemplazaResponsable;
import menu.Fichas.EditarFichas.Edita;
import menu.Riesgos.EdicionRiesgos.GuardaRiesgo;
import modelo.Trabajador;
import net.thucydides.core.annotations.Steps;
import utiles.capturasPantallas.AlmacenRutasDeCapturaPantalla;
import utiles.capturasPantallas.CapturaPantalla;
import utiles.componentesDelPdf.Descripcion;
import utiles.componentesDelPdf.Sprint;
import utiles.componentesDelPdf.TituloPortada;
import utiles.crearPdf.FactoriaPDF;
import utiles.esperas.Espera;


public class ModificacionPerfilTecnicoDeZonaStep {

	
	private static int CONTADOR=1;
	private String rutaEscenario="";
	@Steps 
	Navega navega;
	@Steps
	Logarse logarse;
	@Steps
	NavegaAconsultaEvaluacion navegaAconsultaEvaluacion;
	@Steps 
	RealizaBusqueda realizaBusqueda;
	@Steps
	ResultadoDeLaBusqueda resultadoDeLaBusqueda;
	@Steps
	Verifica verifica;
	@Steps 
	NavegaAaltaEvaluacion navegaAaltaEvaluacion;
	@Steps
	menu.Evaluaciones.AltaEvaluacion.RealizaBusqueda realizaBusquedaConAltaEvaluacion;

	@Steps
	NavegaAreemplazarResponsables navegaAreemplazarResponsables;
	@Steps
	ReemplazaResponsable reemplazaResponsable;
	@Steps
	IrAconsultaEvaluacion irAconsultaEvaluacion;
	@Steps 
	NavegaAconsultaRiesgos navegaAconsultaRiesgos;
	
	@Steps
	NavegaAconsultaDeDocumentos navegaAconsultaDeDocuemntos;
	@Steps
	menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.RealizaBusqueda realizaBusquedaConsultaDocumentos;
	@Steps
	menu.Documentacion.CoordinacionCliente.ConsultaDocumentos.ResultadosDeLaBusqueda resultadoDeLaBusquedaConsultaDocumentos;
	@Steps
	NavegaAcoordinacion navegaAcoordinacion;
	@Steps
	menu.Documentacion.CoordinacionCliente.Coordinacion.RealizaBusqueda realizaBusquedaCoordinacion;
	@Steps
	menu.Documentacion.CoordinacionCliente.Coordinacion.ResultadoDeLaBusqueda resultadoBusquedaCoordinacion;
	@Steps
	menu.Documentacion.CoordinacionCliente.CoordinacionAcciones.RealizaLaDescarga realizaDescargaCoordinacionAcciones;
	@Steps
	NavegaAasociacionEmpleadoPuesto navegaAasociacionEmpleadoPuesto;
	@Steps
	menu.Documentacion.AsociacionEmpleadoPuesto.RealizaBusqueda realizaBusquedaAsociacionEmpleadoPuesto;
	@Steps
	menu.Riesgos.ConsultaRiesgos.RealizaBusqueda realizaBusquedaConsultaRiesgo;
	@Steps
	GuardaRiesgo guardaRiesgo;
	@Steps
	NavegaAeditarFichas navegaAeditarFicha;
	@Steps 
	menu.Fichas.EditarFichas.RealizaBusqueda realizaBusquedaEditarFicha;
	@Steps
	Edita edita;
	@Steps
	menu.Fichas.EditarFichas.NavegaPublicacionesPendiente navegaPublicacionesPendiente;
	@Steps
	menu.Documentacion.PublicacionesPendientes.RealizaBusqueda realizaBusquedaPublicacionPendiente;

	
	List<TituloPortada> titulosPortada = new ArrayList<TituloPortada>();
	List<Descripcion> descripciones = new ArrayList<Descripcion>();
	List<Sprint> sprints = new ArrayList<Sprint>();

	private void llenarEnumerados() {
		titulosPortada.add(TituloPortada.CONSULTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA);//0
		descripciones.add(Descripcion.CONSULTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.ALTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA);//1
		descripciones.add(Descripcion.ALTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.REEMPLAZAR_RESPONSABLES_CON_TECNICO_DE_ZONA);//2
		descripciones.add(Descripcion.REEMPLAZAR_RESPONSABLES_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.EDITAR_FICHAS_CON_TECNICO_DE_ZONA);//3
		descripciones.add(Descripcion.EDITAR_FICHAS_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.CONSULTA_DE_RIESGOS_CON_TECNICO_DE_ZONA);//4
		descripciones.add(Descripcion.CONSULTA_DE_RIESGOS_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.CONSULTA_DE_DOCUMENTOS_CON_TECNICO_DE_ZONA);//5
		descripciones.add(Descripcion.CONSULTA_DE_DOCUMENTOS_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.COORDINACION_CON_TECNICO_DE_ZONA);//6
		descripciones.add(Descripcion.COORDINACION_CON_TECNICO_DE_ZONA);
		titulosPortada.add(TituloPortada.ASOCIACION_EMPLEADO_PUESTO_CON_TECNICO_DE_ZONA);//7
		descripciones.add(Descripcion.ASOCIACION_EMPLEADO_PUESTO_CON_TECNICO_DE_ZONA);
		sprints.add(Sprint.Sprint4);

	}

	@Before("@ConsultaDeEvaluaciones or @AltaDeEvaluaciones or @ReemplazarResponsable or @EditarFicha or @ConsultaDeRiesgo or @ConsultaDeDocumentos or  @Coordinacion or @AsociacionEmpleadoPuesto")
	public void antes(Scenario escenario) {
		//reiniciamos los contadores
		if(CONTADOR==2)CONTADOR=1;
		//if(	CapturaPantalla.CONTADOR_VUELTAS_APLICACION==2)CapturaPantalla.CONTADOR_VUELTAS_APLICACION=1; //solo es un usuario
		this.llenarEnumerados();
		Collection<String> etiquetas=escenario.getSourceTagNames();
		for(String esc: etiquetas) {
			rutaEscenario=esc;	
		}
		AlmacenRutasDeCapturaPantalla.Ruta_Escenario=rutaEscenario;
		AlmacenRutasDeCapturaPantalla.setValorRuta(7);
	}
	
	
	//ConsultaDeEvaluaciones	
	@Given("el usuario se logea como Tecnico de Central")
	public void el_usuario_se_logea_como_tecnico_de_central(io.cucumber.datatable.DataTable table) {
		navega.aLogin();
		List<List<String>> rows = table.asLists(String.class);
		for (List<String> row : rows) {
			Trabajador.agregar(new Trabajador(row.get(0), row.get(1), row.get(2)));
		}
		logarse.conUsuarioYpassword(Trabajador.trabajadores.get(CONTADOR).nombre,
				Trabajador.trabajadores.get(CONTADOR).dni);
	}
	@When("el usuario se dirige a la pantalla Consulta de Evaluaciones")
	public void el_usuario_se_dirige_a_la_pantalla_consulta_de_evaluaciones() {
		navegaAconsultaEvaluacion.accede();
	}
	
	
	@When("el usario realiza una busqueda con el cliente {string} en la pantalla Consulta de Evaluaciones")
	public void el_usario_realiza_una_busqueda_con_el_cliente_en_la_pantalla_consulta_de_evaluaciones(String id) {
		realizaBusqueda.porId(id);
	}
	@When("selecciona el primer resultado de la busqueda en la pantalla Consulta de Evaluaciones")
	public void selecciona_el_primer_resultado_de_la_busqueda_en_la_pantalla_consulta_de_evaluaciones() {
		resultadoDeLaBusqueda.seAccedePantallaEdicionEvaluacion();
	}
	@Then("el usuario verifica que el codigo {string} es cliente suyo")
	public void el_usuario_verifica_que_el_codigo_es_cliente_suyo(String cliente) {
		 Assert.assertTrue(verifica.queElClienteEsDelUsuario(cliente));
	}


	
	//AltaDeEvaluaciones
	@When("el usuario se dirige a la pantalla Alta de Evaluaciones")
	public void el_usuario_se_dirige_a_la_pantalla_alta_de_evaluaciones() {
	  navegaAaltaEvaluacion.accede();
	}
	@When("el usario realiza una busqueda con el cliente {string} asignado a el")
	public void el_usario_realiza_una_busqueda_con_el_cliente_asignado_a_el(String string) {
		realizaBusquedaConAltaEvaluacion.porClienteAsignado(string);
	}
	@Then("el usuario comprueba que hay resultados de busqueda")
	public void el_usuario_comprueba_que_hay_resultados_de_busqueda() {
		Assert.assertTrue("el tecnico de zona no tiene ese cliente asignado" ,realizaBusquedaConAltaEvaluacion.verificaSiHayResultadoEnLaBusqueda());
	}
	//ReemplazarResponasable
	@When("el usuario se dirige a la pantalla Reemplazar Responsables")
	public void el_usuario_se_dirige_a_la_pantalla_reemplazar_responsables() {
		navegaAreemplazarResponsables.accede();
	}
	@When("el usuario cambia el responsable {string}")
	public void el_usuario_cambia_el_responsable(String string) {
		reemplazaResponsable.seleccionaResponsableAreemplazar(string);
	}
	@When("el usuario selecciona una evaluacion con id {string}")
	public void el_usuario_selecciona_una_evaluacion_con_id(String string) {
		reemplazaResponsable.seleccionaID(string);
	}
	@When("el usuario elige  el responsable nuevo {string}")
	public void el_usuario_elige_el_responsable_nuevo(String string) {
	   reemplazaResponsable.seleccionaResponsableNuevo(string);
	   reemplazaResponsable.guardarCambios();
	}
	@When("el usuario accede a la pantalla Consulta Evaluacion")
	public void el_usuario_accede_a_la_pantalla_consulta_evaluacion() {
	  irAconsultaEvaluacion.accede();
	}
	@Then("el usuario realiza la busqueda por id {string}")
	public void el_usuario_realiza_la_busqueda_por_id(String string) {
	    realizaBusqueda.porId(string);
	}
	@Then("el responsable es {string}")
	public void el_responsable_es(String string) {
		 Assert.assertTrue(resultadoDeLaBusqueda.verificaNombreResponsableControlPeriodico(string));
	    
	}

	
	//EditarFicha
	@When("el usuario se dirige a la pantalla de Editar Ficha")
	public void el_usuario_se_dirige_a_la_pantalla_de_editar_ficha() {
		navegaAeditarFicha.accede();
	}
	@When("el usuario realiza la busqueda por id {string} en la pantalla Editar Ficha")
	public void el_usuario_realiza_la_busqueda_por_id_en_la_pantalla_editar_ficha(String string) {
		realizaBusquedaEditarFicha.porID(string);
	}
	@When("el usuario accede a la pantalla Editar Ficha")
	public void el_usuario_accede_a_la_pantalla_editar_ficha() {
		realizaBusquedaEditarFicha.seleccionaPrimerResultado();
	}
	@When("el usuario guarda los cambios")
	public void el_usuario_guarda_los_cambios() {
				edita.guardaCambios();
	}
	@Then("el usuario se dirige a la pantalla Publicaciones Pendientes")
	public void el_usuario_se_dirige_a_la_pantalla_publicaciones_pendientes() {
		navegaPublicacionesPendiente.accede();
	}
	@Then("el usuario busca por id {string}")
	public void el_usuario_busca_por_id(String string) {
		realizaBusquedaPublicacionPendiente.porID(string);
	}
	@Then("comprueba que ha sido modificada.")
	public void comprueba_que_ha_sido_modificada() {
		realizaBusquedaPublicacionPendiente.guardarCambios();
	}
	
	

	
	//ConsultaDeRiesgo
	@When("el usuario se dirige a la pantalla Consulta de Riesgo")
	public void el_usuario_se_dirige_a_la_pantalla_consulta_de_riesgo() {
		navegaAconsultaRiesgos.accede();
	}
	@When("el usuario realiza la busqueda por id  {string} de un cliente asignado en la pantalla Consulta de Riesgo")
	public void el_usuario_realiza_la_busqueda_por_id_de_un_cliente_asignado_en_la_pantalla_consulta_de_riesgo(String string) {
		realizaBusquedaConsultaRiesgo.porID(string);
	}
	@When("el usuario accede a la pantalla edicion riesgos")
	public void el_usuario_accede_a_la_pantalla_edicion_riesgos() {
		realizaBusquedaConsultaRiesgo.seleccionaResultadoBusqueda();
	}
	@Then("el usuario comprueba el boton Guardar esta habilitado")
	public void el_usuario_comprueba_el_boton_guardar_esta_habilitado() {
		Assert.assertTrue("el estado del boton guardar debe estar habilitado", guardaRiesgo.verificaElEstadoDelBotonGuardar());
	}

	
	//ConsultaDeDocumentos
	@When("el usuario se dirige a la pantalla Consulta de Documentos")
	public void el_usuario_se_dirige_a_la_pantalla_consulta_de_documentos() {
		navegaAconsultaDeDocuemntos.accede();
	}
	@When("el usuario realiza la busqueda por cliente {string} en la pantalla Consulta de Documentos")
	public void el_usuario_realiza_la_busqueda_por_cliente_en_la_pantalla_consulta_de_documentos(String string) {
		realizaBusquedaConsultaDocumentos.buscar(string);
	}
	@Then("el usuario puede descargarse la documentacion asociada")
	public void el_usuario_puede_descargarse_la_documentacion_asociada() {
		resultadoDeLaBusquedaConsultaDocumentos.descargar();
	}
	
	//Coordinacion
	@When("el usuario accede a la pantalla Coordinacion")
	public void el_usuario_accede_a_la_pantalla_coordinacion() {
		navegaAcoordinacion.accede();
	}
	@When("el usuario realiza la busqueda por cliente {string} en la pantalla Coordinacion")
	public void el_usuario_realiza_la_busqueda_por_cliente_en_la_pantalla_coordinacion(String string) {
		realizaBusquedaCoordinacion.porCliente(string);
	}
	@When("el usuario selecciona una coordinacion con ese cliente asociado para acceder a la pantalla Coordinacion Acciones")
	public void el_usuario_selecciona_una_coordinacion_con_ese_cliente_asociado_para_acceder_a_la_pantalla_coordinacion_acciones() {
	   resultadoBusquedaCoordinacion.accedePantallaCoordinacionAcciones();
	}
	@Then("el usuario se puede descargar la documentacion de coordinacion")
	public void el_usuario_se_puede_descargar_la_documentacion_de_coordinacion() {
		realizaDescargaCoordinacionAcciones.alPulsarBotonDescargar();
	}


     //AsociacionEmpleadoPuesto
	@When("el usuario se dirige a la pantalla Asociacion Empleado Puesto")
	public void el_usuario_se_dirige_a_la_pantalla_asociacion_empleado_puesto() {
		navegaAasociacionEmpleadoPuesto.accede();
	}
	@When("el usuario realiza la busqueda por evaluacion {string}")
	public void el_usuario_realiza_la_busqueda_por_evaluacion(String string) {
		realizaBusquedaAsociacionEmpleadoPuesto.porEvaluacion(string);
		 
	}
	@Then("el usuario comprueba que los datos pertenece a una evaluacion asociada")
	public void el_usuario_comprueba_que_los_datos_pertenece_a_una_evaluacion_asociada() {
	 Assert.assertTrue(realizaBusquedaAsociacionEmpleadoPuesto.verificaSiHayResultadoEnLaBusqueda());
	}

@After("@ConsultaDeEvaluaciones or @AltaDeEvaluaciones or @ReemplazarResponsable or @EditarFicha or @ConsultaDeRiesgo or @ConsultaDeDocumentos or @Coordinacion or @AsociacionEmpleadoPuesto")
public void guardar(Scenario escenario) {
	Collection<String> etiquetas = escenario.getSourceTagNames();
	for (String etiqueta : etiquetas) {
		if (etiqueta.equalsIgnoreCase("@ConsultaDeEvaluaciones")) {
			FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
					CONTADOR, rutaEscenario, titulosPortada.get(0),
					descripciones.get(0), sprints.get(0));
	    }else if (etiqueta.equalsIgnoreCase("@AltaDeEvaluaciones")) {
		     FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
				CONTADOR, rutaEscenario, titulosPortada.get(1),
				descripciones.get(1), sprints.get(0));
        
	    }else if (etiqueta.equalsIgnoreCase("@ReemplazarResponsable")) {
	         FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
			CONTADOR, rutaEscenario, titulosPortada.get(2),
			descripciones.get(2), sprints.get(0));
	    }else if (etiqueta.equalsIgnoreCase("@EditarFicha")) {
	         FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
			CONTADOR, rutaEscenario, titulosPortada.get(3),
			descripciones.get(3), sprints.get(0));
	    }else if (etiqueta.equalsIgnoreCase("@ConsultaDeRiesgo")) {
	         FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
			CONTADOR, rutaEscenario, titulosPortada.get(4),
			descripciones.get(4), sprints.get(0));         
	    }else if (etiqueta.equalsIgnoreCase("@ConsultaDeDocumentos")) {
	         FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
			CONTADOR, rutaEscenario, titulosPortada.get(5),
			descripciones.get(5), sprints.get(0));
      
        }else if (etiqueta.equalsIgnoreCase("@Coordinacion")) {
	         FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
			CONTADOR, rutaEscenario, titulosPortada.get(6),
			descripciones.get(6), sprints.get(0));
       }else if (etiqueta.equalsIgnoreCase("@AsociacionEmpleadoPuesto")) {
	         FactoriaPDF.crearPdf(AlmacenRutasDeCapturaPantalla.VALOR_RUTA,
			CONTADOR, rutaEscenario, titulosPortada.get(7),
			descripciones.get(7), sprints.get(0));
     }
		
	}
	
	CONTADOR++;
	//reseteamos las rutas
	AlmacenRutasDeCapturaPantalla.Ruta_Escenario="";
	rutaEscenario="";

      
       }

}

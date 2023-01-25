package utiles.componentesDelPdf;

public enum TituloPortada {

	 TITULO_LOGIN_CORRECTO ("VERIFICACIÓN DEL LOGIN CORRECTO"),
	 TITULO_LOGIN_INCORRECTO ("VERIFICACIÓN DEL LOGIN INCORRECTO"),
	 TITULO_DESCARGAR_IGN ("VERIFICACIÓN DE LA DESCARGA GUÍA IGN"),
	 TITULO_DESCARGAR_IGCT ("VERIFICACIÓN DE LA DESCARGA GUÍA IGCT"),
	 TITULO_DESCARGAR_CONSULTADOCUMENTOS ("VERIFICACIÓN DE LA DESCARGA EN LA PANTALLA EN CONSULTA DE DOCUMENTOS"),
     TITULO_DESCARGAR_COORDINACION ("VERIFICACIÓN DE LA DESCARGA EN LA PANTALLA COORDINACIÓN"),
	 TITULO_DESCARGAR_INSTRUCCIONESGUIAS ("VERIFICACIÓN DE LA DESCARGA EN LA PANTALLA INSTURCCIONES GUÍAS"),
	 TITULO_DESCARGAR_FORMULARIOADIESTRAMIENTO("DESCARGA DEL FORMULARIO DE ADIESTRAMIENTO"),
	 TITULO_DESCARGAR_FORMULARIOADIESTRAMIENTO_SIN_RESPUESTA("ELIMINACION DEL CUR EN EL FORMULARIO"),
	 ALTA_DE_USUARIO("ALTA EN LA ASIGNACION DE USUARIOS"),
	 BAJA_DE_USUARIO("BAJA EN LA ASIGNACION DE USUARIOS"),
	////////todos estos pertenencen a modificacion perfil tecnico de zona
	CONSULTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA("CONSULTA DE EVALUACION CON TECNICO DE ZONA"),
	ALTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA("ALTA DE EVALUACIONES CON TECNINCO DE ZONA"),
	REEMPLAZAR_RESPONSABLES_CON_TECNICO_DE_ZONA("REEMPLAZAR RESPONSABLES CON TECNICO DE ZONA"),
	EDITAR_FICHAS_CON_TECNICO_DE_ZONA("EDITAR FICHAS CON TECNICO DE ZONA"),
	CONSULTA_DE_RIESGOS_CON_TECNICO_DE_ZONA("CONSULTA DE RIESGOS CON TECNICO DE ZONA"),
	CONSULTA_DE_DOCUMENTOS_CON_TECNICO_DE_ZONA("CONSULTA DE DOCUMENTOS CON TECNICO DE ZONA"),
	COORDINACION_CON_TECNICO_DE_ZONA("COORIDNACION CON TECNICO DE ZONA"),
	PUBLICACIONES_PENDIENTES_CON_TECNICO_DE_ZONA("PUBLICACIONES PENDIENTES CON TECNICO DE ZONA"),
	ASOCIACION_EMPLEADO_PUESTO_CON_TECNICO_DE_ZONA("ASIGNACION EMPLEADO PUESTO CON TECNICO DE ZONA"),
	  //////////////////////////////////////////////////////////////
	EDITOR_MEDIDAS("EDITAR CON MEDIDAS"),
	EDITOR_MEDIDAS_A_TERCERCEROS("EDITAR CON MEDIDAS A TERCEROS");
private String titulo;
TituloPortada(String titulo) {
	// TODO Auto-generated constructor stub
	this.titulo=titulo;
}

public String getTitulo() {
	return titulo;
}

}

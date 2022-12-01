package utiles.componentesDelPdf;

public enum Descripcion {

	
	DESCRIPCION_LOGIN("mostramos los pasos para verificar la prueba de Login"),
	DESCRIPCION_INSTRUCCIONESGUIAS("df"),
	DESCRIPCION_DESCARGARCOORDINACION("pasos para descargar coordinación"),
	DESCRIPCION_DESCARGAR_CONSULTA_DOCUMENTACION("pasos para descargar Consulta documentacion"),
	DESCRIPCION_DESCARGAR_IGCT("pasos para descargar las consultas sobre Ins. Guias Cliente_Proyecto "),
	DESCRIPCION_DESCARGAR_IGN_Boton1("pasos para descargar las consultas sobre Ins. Guias Nacionales con el boton 1"),
	DESCRIPCION_DESCARGAR_IGN_Boton2("pasos para descargar las consultas sobre Ins. Guias Nacionales con el boton 2"),
	DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO("Pasos para verificar el correcto funcionamiento de la descarga del formulario de adiestramiento y la implementación adecuada tanto del nombre del trabajador como de su dni"),
	DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO_SIN_RESPUESTAS("Pasos para verificar que no contiene las respuestas el formulario de adiestramiento"),
	ALTA_DE_USUARIO("Pasos para verificar que el se puede realizar altas en la asignacion de usuarios"),
	BAJA_DE_USUARIO("Pasos para verificar que el se puede realizar bajas en la asignacion de usuarios"),
	//////todas son para modifciacion perfil de tecnico de zona
	CONSULTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA("En el proceso de Consulta de Evaluaciones, las búsquedas se realizarán sobre los clientes asignados al Técnico de Zona y sus ofertas, desapareciendo el parámetro Empresa / Oficina."),
	ALTA_DE_EVALUACIONES_CON_TECNICO_DE_ZONA("El alta de evaluaciones sólo se permitirá sobre aquellos clientes que tenga asignado el Técnico de PRL, pudiéndose seleccionar únicamente como “Tipo” las opciones de “Cliente” y “Oferta”. La posibilidad de dar de alta evaluaciones de tipo “Centro” no estará habilitada"),
	REEMPLAZAR_RESPONSABLES_CON_TECNICO_DE_ZONA("Desde la opción de “Reemplazar responsables” se podrán realizar cambios ágiles de responsable de las evaluaciones sobre los clientes que el Técnico PRL tenga asignados, sin necesidad de entrar en el detalle de cada una de ellas. "),
	EDITAR_FICHAS_CON_TECNICO_DE_ZONA("El Técnico de Zona sólo podrá editar, a través de esta opción, las fichas asociadas a las evaluaciones u ofertas de los clientes que tenga asociados, sin que pueda realizar búsquedas a través de  opción tipo de centro (Empresa / Oficina)"),
	CONSULTA_DE_RIESGOS_CON_TECNICO_DE_ZONA("El Técnico de Zona podrá consultar todos los riesgos existentes, si bien sólo podrá editar los riesgos asociados a las evaluaciones u ofertas que los clientes tengan asignados. Por este motivo, no será necesario contar con la opción de búsqueda por Centro (Empresa / Oficina)"),
	CONSULTA_DE_DOCUMENTOS_CON_TECNICO_DE_ZONA("El nuevo Rol TPRL sólo podrá consultar los documentos de aquellos clientes que tenga asignados."),
	COORDINACION_CON_TECNICO_DE_ZONA("Con el nuevo rol TPRL en la pantalla de Coordinación, el Técnico de Zona podrá gestionar, subir y consultar los documentos aportados por los clientes que tenga asociados. \r\n"
			+ "Pantalla que facilita la gestión de los documentos aportados por el cliente y su consulta, tiene dos zonas diferenciadas, la superior donde se ponen los criterios de selección de la consulta de los documentos, y la inferior para gestión y visionado de los datos de los documentos hallados en la consulta.\r\n"
			+ ""),
	PUBLICACIONES_PENDIENTES_CON_TECNICO_DE_ZONA("En la pantalla de publicaciones pendientes, sólo se mostrarán aquellas relacionadas con las evaluaciones o fichas de los clientes asignados al Técnico de Zona, por lo que no se le mostrará la opción “Mostrar todos”."),
	ASOCIACION_EMPLEADO_PUESTO_CON_TECNICO_DE_ZONA("En la asociación del empleado al puesto, el Técnico de Zona sólo podrá asociar empleados a las evaluaciones de los clientes asignados, no siendo posible realizar búsquedas a través de la opción Centro.");
;

private String descripcion;

Descripcion(String descripcion) {
	// TODO Auto-generated constructor stub
	this.descripcion=descripcion;

}

public String getDescripcion() {
	return descripcion;
}
}

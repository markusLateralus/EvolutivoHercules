package utiles.pdf;

public enum Descripcion {

	
	DESCRIPCION_LOGIN("mostramos los pasos para verificar la prueba de Login"),
	DESCRIPCION_INSTRUCCIONESGUIAS("df"),
	DESCRIPCION_DESCARGARCOORDINACION("pasos para descargar coordinación"),
	DESCRIPCION_DESCARGAR_CONSULTA_DOCUMENTACION("pasos para descargar Consulta documentacion"),
	DESCRIPCION_DESCARGAR_IGCT("pasos para descargar las consultas sobre Ins. Guias Cliente_Proyecto "),
	DESCRIPCION_DESCARGAR_IGN_Boton1("pasos para descargar las consultas sobre Ins. Guias Nacionales con el boton 1"),
	DESCRIPCION_DESCARGAR_IGN_Boton2("pasos para descargar las consultas sobre Ins. Guias Nacionales con el boton 2"),
	DESCRIPCION_DESCARGAR_FORMULARIOADIESTRAMIENTO("Pasos para verificar el correcto funcionamiento de la descarga del formulario de adiestramiento y la implementación adecuada tanto del nombre del trabajador como de su dni");
	
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

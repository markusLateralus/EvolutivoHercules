

Feature: Modificacion Perfil Tecnico De Zona

escenario Consulta de evaluaciones:
 En el proceso de Consulta de Evaluaciones, las búsquedas se realizarán sobre los clientes asignados
 al Técnico de Zona y sus ofertas, desapareciendo el parámetro Empresa / Oficina.
 
escenario Alta evaluaciones:
El alta de evaluaciones sólo se permitirá sobre aquellos clientes que tenga asignado el Técnico de PRL, 
pudiéndose seleccionar únicamente como “Tipo” las opciones de “Cliente” y “Oferta”. 
La posibilidad de dar de alta evaluaciones de tipo “Centro” no estará habilitada. 
 
 escnario reemplazar responsables:
 Desde la opción de “Reemplazar responsables” se podrán realizar cambios ágiles de responsable
  de las evaluaciones sobre los clientes que el Técnico PRL tenga asignados, sin necesidad de entrar en el detalle de cada una de ellas

escenario editar fichas:
 El Técnico de Zona sólo podrá editar, a través de esta opción, las fichas asociadas a las evaluaciones u 
ofertas de los clientes que tenga asociados, sin que pueda realizar búsquedas a través de  opción tipo de centro (Empresa / Oficina)

escenario consulta riesgos: 
El Técnico de Zona podrá consultar todos los riesgos existentes, si bien sólo podrá editar los riesgos asociados 
a las evaluaciones u ofertas que los clientes tengan asignados.

escenario consulta documentos: 
El nuevo Rol TPRL sólo podrá consultar los documentos de aquellos clientes que tenga asignados.

Escenario coordinacion: 
Con el nuevo rol TPRL en la pantalla de Coordinación, el Técnico de Zona podrá gestionar, 
subir y consultar los documentos aportados por los clientes que tenga asociados. Pantalla que facilita la gestión 
de los documentos aportados por el cliente y su consulta, tiene dos zonas diferenciadas, 
la superior donde se ponen los criterios de selección de la consulta de los documentos, y la inferior para gestión 
y visionado de los datos de los documentos hallados en la consulta.

Escenario publicaciones pendientes: 
En la pantalla de publicaciones pendientes, sólo se mostrarán aquellas relacionadas con las evaluaciones 
o fichas de los clientes asignados al Técnico de Zona, por lo que no se le mostrará la opción “Mostrar todos”.
Escenario asociacion empleado puesto: En la asociación del empleado al puesto, el Técnico de Zona sólo podrá asociar empleados
 a las evaluaciones de los clientes asignados, no siendo posible realizar búsquedas a través de la opción Centro.
 
 Escenario asociacion empleado puesto:
  En la asociación del empleado al puesto, el Técnico de Zona sólo podrá asociar empleados a las evaluaciones 
 de los clientes asignados, no siendo posible realizar búsquedas a través de la opción Centro.
Background:
Given el usuario se logea como Tecnico de Central
| usuario       | password   |   rol             |    
| prl1          | Primera08   | Tecnico de Zona   |

@ConsultaDeEvaluaciones
Scenario Outline: Consulta de Evaluaciones
When el usuario se dirige a la pantalla Consulta de Evaluaciones
And  el usario realiza una busqueda con el cliente "<id>" en la pantalla Consulta de Evaluaciones 
And  selecciona el primer resultado de la busqueda en la pantalla Consulta de Evaluaciones
Then el usuario verifica que el codigo "<codigo>" es cliente suyo
Examples:
|   id    | codigo  |
| 5055    |  012363 | 

@AltaDeEvaluaciones
Scenario Outline: Alta de Evaluaciones
When el usuario se dirige a la pantalla Alta de Evaluaciones
And el usario realiza una busqueda con el cliente "<cliente>" asignado a el
Then el usuario comprueba que hay resultados de busqueda
Examples:
|   cliente | 
| 012363   |

@ReemplazarResponsable
Scenario Outline: Reemplazar Responasbles Control Periodico #cada vez que ejecute este escenario debo volver a cambiarlo 	
When el usuario se dirige a la pantalla Reemplazar Responsables
And el usuario cambia el responsable "<responsableViejo>"
And el usuario selecciona una evaluacion con id "<id>"
And el usuario elige  el responsable nuevo "<responsableNuevo>"
And el usuario accede a la pantalla Consulta Evaluacion
Then el usuario realiza la busqueda por id "<id>"
And  el responsable es "<responsableNuevo>"
Examples:
| responsableViejo    |   id     |  responsableNuevo   |   
|   Fernandez Casado  |   60428  | Mansilla , jaime    |    

@EditarFicha
Scenario Outline: Editar Ficha
When el usuario se dirige a la pantalla de Editar Ficha
And el usuario realiza la busqueda por cliente "<cliente>" en la pantalla Editar Ficha
And el usuario selecciona la primera ficha del cliente seleccionado
And se carga la pantalla Edicion Ficha         #perdinente de termiar
Examples:
|  cliente     |
|   012363     |

@ConsultaDeRiesgo
Scenario Outline: Consulta de Riesgo 
When el usuario se dirige a la pantalla Consulta de Riesgo
And el usuario realiza la busqueda por id  "<cliente>" de un cliente asignado en la pantalla Consulta de Riesgo
And el usuario accede a la pantalla edicion riesgos
Then el usuario comprueba el boton Guardar esta habilitado
Examples:
|   cliente  |
|14721      | #si  esta asociado a un cl     15010
#| 15601     |#no esta asociado y me sale un mensaje emergente, y boton GUARDAR esta inhabilitado


@ConsultaDeDocumentos
Scenario Outline: Consulta de Documentos
When el usuario se dirige a la pantalla Consulta de Documentos
And el usuario realiza la busqueda por cliente "<cliente>" en la pantalla Consulta de Documentos 
Then el usuario puede descargarse la documentacion asociada
Examples:
|   cliente |
|  097810   |   

@Coordinacion
Scenario Outline: Coordinacion
When el usuario accede a la pantalla Coordinacion
And el usuario realiza la busqueda por cliente "<cliente>" en la pantalla Coordinacion
And el usuario selecciona una coordinacion con ese cliente asociado para acceder a la pantalla Coordinacion Acciones
Then el usuario se puede descargar la documentacion de coordinacion
Examples:
|   cliente  |
|  097810    |

@AsociacionEmpleadoPuesto
Scenario Outline: Asociacion Empleado Puesto
When el usuario se dirige a la pantalla Asociacion Empleado Puesto    
And el usuario realiza la busqueda por evaluacion "<evaluacion>"
Then el usuario comprueba que los datos pertenece a una evaluacion asociada

Examples:
|evaluacion   |
|   11525     |
#|   525       |
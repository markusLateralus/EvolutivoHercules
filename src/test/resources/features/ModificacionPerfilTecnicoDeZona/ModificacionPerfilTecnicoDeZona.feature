

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
| usuario       | password   |   rol                |    
| prl1     | Primera08  | Tecnico de Zona   |

@ConsultaDeEvaluaciones
Scenario Outline: Consulta de Evaluaciones
When el usuario se dirige a la pantalla Consulta de Evaluaciones
Then asdfasd

@AltaDeEvaluaciones
Scenario Outline: Alta de Evaluaciones
When el usuario se dirige a la pantalla Alta de Evaluaciones
Then asdfasd


@ReemplazarResponasable
Scenario Outline: Reemplazar Responasbles
When el usuario se dirige a la pantalla Reemplazar Responsables
And el usuario cambia el responsable "<responsableViejo>" por el responsable "<responsableNuevo>"
Then el usuario puede comprobar que se ha realizado el cambio de responsable correctamente

Examples:
| responsableViejo            |       responsableNuevo          |
|   un usuario existente      | un nuevo cliente                |

@EditarFicha
Scenario Outline: Editar Ficha
When el usuario se dirige a la pantalla de Editar Ficha
And el usuario realiza la busqueda por dddddddddddddd
Then el usuario comprueba que no está en la lista

@ConsultaDeRiesgo
Scenario Outline: Consulta de Riesgo
When el usuario se dirige a la pantalla Consulta de Riesgo
And el usuario realiza la busqueda por dddddddddddddd

@ConsultaDeDocumentos
Scenario Outline: Consulta de Documentos
When el usuario se dirige a la pantalla Consulta de Documentos
And el usuario realiza la busqueda por dddddddddddddd

@Coordinacion
Scenario Outline: Coordinacion
When el usuario se dirige a la pantalla Coordinacion
And el usuario realiza la busqueda por dddddddddddddd

@PublicacionesPendientes
Scenario Outline: Publicaciones Pendientes
When el usuario se dirige a la pantalla Publicaciones Pendientes
And el usuario realiza la busqueda por dddddddddddddd

@AsociacionEmpleadoPuesto
Scenario Outline: Asociacion Empleado Puesto
When el usuario se dirige a la pantalla Asociacion Empleado Puesto
And el usuario realiza la busqueda por dddddddddddddd
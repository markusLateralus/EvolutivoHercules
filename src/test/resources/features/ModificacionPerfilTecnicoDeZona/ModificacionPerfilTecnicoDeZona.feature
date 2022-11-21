

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
And  el usario realiza una busqueda con el cliente "<cliente>" en la pantalla Consulta de Evaluaciones 
Then el usuario puede verificar que la aplicacion realiza la busqueda correctamente
Examples:
|   cliente  |
| 012363     |   #ayuntamiento de avila

@AltaDeEvaluaciones
Scenario Outline: Alta de Evaluaciones
When el usuario se dirige a la pantalla Alta de Evaluaciones
And el usario realiza una busqueda con el cliente "<cliente>" en la pantalla Alta de Evaluaciones
And rellenamos el formulario campo provincia "<provincia>", modelo de negocio "<modeloNegocio>", empresa "<empresa>" , linea de venta "<lineaVenta>", lugar prestacion servicio "<lugarPrestacionServicio>", actividad contratada "<actividadContratada>", tecnico "<tecnico>", responsable de contrato "<responsableContrato>", responsable control periodico "<responsableControlPeriodico>" y fecha inicio contrato "<fechaInicioContrato>"
And el usuario selecciona un proyecto y lo Guarda
Then el usuario obtiene un idEvaluacion nuevo
Examples:
|   cliente | provincia  | modeloNegocio   | empresa   |  lineaVenta |  lugarPrestacionServicio  | actividadContratada  |  tecnico   |  responsableContrato      | responsableControlPeriodico  |  fechaInicioContrato | 
| 012363    |  05 - Avila|   910-Limpieza  |  25       |   01        |        AVILA              |     Prueba           |    prl1    | Fernandez Casado, Ainhoa  |   Fernandez Casado, Ainhoa   |      21/11/2022      |

@ReemplazarResponasable
Scenario Outline: Reemplazar Responasbles
When el usuario se dirige a la pantalla Reemplazar Responsables
And el usuario cambia el responsable "<responsableViejo>"
And el usuario selecciona una evaluacion con id "<id>"
And el usuario elige  el responsable nuevo "<responsableNuevo>"
And el usuario se dirige a la pantalla Consulta Evaluacion
Then el usuario realiza la busqueda por id "<id>"
And  el responsable es "responsableNuevo"
Examples:
| responsableViejo               |   id       |     responsableNuevo          |   
|   Fernandez Casado, Ainhoa     |   E-60428  |  Guerra Lopez, Lucas Armando     |    

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
And el usuario realiza la busqueda por cliente "<cliente>" en la pantalla Consulta de Riesgo
Then el usuario comprueba que los riesgos son todos con el mismo cliente
Examples:
|   cliente  |
| 012363     |

@ConsultaDeDocumentos
Scenario Outline: Consulta de Documentos
When el usuario se dirige a la pantalla Consulta de Documentos
And el usuario realiza la busqueda por cliente "<cliente>" en la pantalla Consulta de Documentos     #pendiente terminar
Then el usuario comprueba que hay consultas con ese cliente asociado
Examples:
|   cliente      |
|  Guadalajara   |

@Coordinacion
Scenario Outline: Coordinacion
When el usuario se dirige a la pantalla Coordinacion
And el usuario realiza la busqueda por cliente "<cliente>" en la pantalla Coordinacion
And el usuario selecciona una coordinacion con ese cliente asociado
And la aplicacion carga la pantalla Coordinacion Acciones
And el usuario pulsa acciones y editar
And el usuario rellena un cuestionario
And el usuario genera nuevo CP y RAP
Then el usuario guarda los cambios
And el estado cambia a publicado
Examples:
|   cliente      |
|  Guadalajara   |
@PublicacionesPendientes
Scenario: Publicaciones Pendientes
When el usuario se dirige a la pantalla Publicaciones Pendientes
Then el usuario verifica que la tabla con resultados son todos con el mismo usuario

@AsociacionEmpleadoPuesto
Scenario Outline: Asociacion Empleado Puesto
When el usuario se dirige a la pantalla Asociacion Empleado Puesto    #pendiente de terminar
And el usuario realiza la busqueda por dddddddddddddd
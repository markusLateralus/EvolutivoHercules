
Feature: Descargar Guias 
Como usuario quiero poder descargar correctamente documentacion sobre Ins. Guias Nacionales con el boton1 y el boton2
	Además, quiero poder descargar la documentacion asociada a Ins  Guias Cliente Proyecto.

Background: 
Given el usuario entra en Hercules 
And el usuario se logea correctamente 
| usuario   | password   |     rol                   | 
| maarrones | Primera08  | Tecnico de central        |
| prl1      | Primera08  | Tecnico de zona           |
| prl2      | Primera08  | Generico Responsable      |
| prl3      | Primera08  | Responsable de impresion  |

And el usuario se dirige a la pantalla Consulta Evaluacion
And el usuario realiza la busqueda correctamente con la provincia, empresa y modelo de negocio 
| provincia  |      empresa        |       modeloNegocio          |
|   33       | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
|   33       | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
|   33       | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
|   33       | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
And el usuario accede a la pantalla Edicion Evalucion
And el usuario accede a la la pantalla Edicion Puesto


@boton1
Scenario Outline: Descargar consultas sobre Ins. Guias Nacioales boton1
When el usuario selecciona la pestania Ins Guias Nacionales
Then el usuario pulsa el boton "<boton>" y se descarga la documentacion Ins Guias Nacionales correctamente
Examples:
| boton  |
|boton1  |
|boton1  |
|boton1  |
|boton1  |

@boton2
Scenario Outline: Descargar consultas sobre Ins. Guias Nacioales boton2
When el usuario selecciona la pestania Ins Guias Nacionales
Then el usuario pulsa el boton "<boton>" y se descarga la documentacion Ins Guias Nacionales correctamente
Examples:
| boton    |
|  boton2  |
|  boton2  |
|  boton2  |
|  boton2  |

@igct
Scenario: Descargar consultas sobre Ins. Guias Cliente_Proyecto
When el usuario selecciona la pestania Ins Guias Cliente Proyecto
Then el usuario se descarga la documentacion Ins.Guias Cliente Proyecto correctamente

Examples:

| usuario   | password   |     rol                   | provincia       |      empresa        |       modeloNegocio          | 
| maarrones | Primera08  | Tecnico de central        |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
| prl1      | Primera08  | Tecnico de zona           |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   | 
| prl2      | Primera08  | Generico Responsable      |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   | 
| prl3      | Primera08  | Responsable de impresion  |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
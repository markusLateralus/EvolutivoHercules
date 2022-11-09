
Feature: Descargar Guias IGCN
Como usuario quiero poder descargar correctamente documentacion sobre Ins. Guias Nacionales con el boton1

Scenario Outline: Descargar consultas sobre Ins. Guias Nacioales boton1
Given el usuario1 entra en Hercules
And el usuario1 se logea correctamente "<usuario>" "<password>"
When el usuario1 se dirige a la pantalla Consulta Evaluacion
And el usuario1 realiza la busqueda correctamente con la provincia "<provincia>", empresa "<empresa>"  y modelo de negocio "<modeloNegocio>" 
And el usuario1 accede a la pantalla Edicion Evalucion
And el usuario1 accede a la la pantalla Edicion Puesto
Then el usuario1 se descarga la documentacion Ins Guias Nacionales correctamente
Examples:

| usuario   | password   |     rol                   | provincia       |      empresa        |       modeloNegocio          |
| maarrones | Primera08  | Tecnico de central        |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
#| prl1      | Primera08  | Tecnico de zona           |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
#| prl2      | Primera08  | Generico Responsable      |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
#| prl3      | Primera08  | Responsable de impresion  |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |



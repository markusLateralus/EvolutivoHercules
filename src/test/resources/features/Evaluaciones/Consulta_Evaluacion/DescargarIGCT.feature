@descargaIGCT
Feature: Descargar Guias IGCT
Como usuario quiero poder descargar correctamente documentacion sobre Ins. Cliente Proyecto
Scenario Outline: Descargar consultas sobre Ins. Guias Cliente_Proyecto
Given el usuario entra en Hercules
And el usuario se logea correctamente "<usuario>" "<password>"
When el usuario se dirige a la pantalla Consulta Evaluacion
And el usuario realiza la busqueda correctamente con la provincia "<provincia>", empresa "<empresa>"  y modelo de negocio "<modeloNegocio>" 
And el usuario accede a la pantalla Edicion Evalucion
And el usuario accede a la la pantalla Edicion Puesto
Then el usuario se descarga la documentacion Ins.Guias Cliente Proyecto correctamente

Examples:

| usuario   | password   |     rol                   | provincia       |      empresa        |       modeloNegocio          | 
| maarrones | Primera08  | Tecnico de central        |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |
| prl1      | Primera08  | Tecnico de zona           |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   | 
| prl2      | Primera08  | Generico Responsable      |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   | 
| prl3      | Primera08  | Responsable de impresion  |  33             | 25 - EULEN, S. A.   | 960 - Servicios Auxiliares   |

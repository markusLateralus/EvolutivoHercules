

Feature: Descargar en Instrucciones-Guias
Como usuario quiero poder descargar correctamente documentacion en Instrucciones-Guias
Background:
Given el usuairo entra en Hercules estando logado 
| usuario   | password   |     rol                  |
| maarrones | Primera08  | Tecnico de central       |
And se dirige a la pantlla Instrucciones Guias

@descargaInstruccionesGuias
Scenario: Descargar archivos en Instrucciones-Guias
When el usuario realiza una busqueda por "<busqueda>"
Then se descarga la documentacion Instrucciones Guias

Examples:
| usuario   | password   |     rol                  |   busqueda   | 
| maarrones | Primera08  | Tecnico de central       |     1        |




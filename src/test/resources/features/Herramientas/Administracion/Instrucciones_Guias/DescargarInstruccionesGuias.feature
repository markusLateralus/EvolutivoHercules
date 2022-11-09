

Feature: Descargar en Instrucciones-Guias
Como usuario quiero poder descargar correctamente documentacion en Instrucciones-Guias
Scenario: Descargar archivos en Instrucciones-Guias
Given el usuario se logea en Hercules con usuario: "<usuario>", password: "<password>" y con el rol: "<rol>"
When el usuario se dirige a la pantalla Instrucciones Guias
And el usuario realiza una busqueda por "<busqueda>"
Then se descarga la documentacion Instrucciones Guias

Examples:
| usuario   | password   |     rol                  |   busqueda   | 
| maarrones | Primera08  | Tecnico de central       |     1        |




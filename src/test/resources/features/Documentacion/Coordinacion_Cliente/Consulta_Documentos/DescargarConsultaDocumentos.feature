

Feature: Descargar consultas Coordinacion cliente
Como usuario quiero poder descargar correctamente documentacion sobre la Coordinacion del Cliente
Scenario: Descargar archivos en Documentacion
Given el usuario se logea de forma correcta con usuario: "<usuario>", password: "<password>" y con el rol: "<rol>"
When el usuario se dirige a la pantalla Documentacion->Coordiancion cliente->Consulta de Documentos
And el usuario realiza una busqueda con el cliente: "<cliente>"
Then se descarga la documentacion de consultas


Examples:
| usuario   | password   |     rol                  |   cliente   | 
| maarrones | Primera08  | Tecnico de central       |  097810     |
| prl1      | Primera08  | Tecnico de zona          |  097810     |
| prl2      | Primera08  | Generico Responsable     |  097810     |
| prl3      | Primera08  | Responsable de impresion |  097810     |



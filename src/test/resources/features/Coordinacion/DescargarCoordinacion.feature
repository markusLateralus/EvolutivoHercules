

Feature: Descargar Coordinacion
Como usuario quiero poder descargar correctamente documentacion sobre la Coordinacion
@descargaDocumentacion
Scenario: Descargar archivos en Coordinacion
Given el usuario entra en Hercules y se logea correctamente con usuario: "<usuario>", password: "<password>" y con el rol: "<rol>"
When el usuario se dirige a la pantalla Coordinacion
And el usuario realiza la busqueda con el cliente: "<cliente>"
Then el usuario accede a la pantalla Coordinacion Acciones
Then el usuiario se descarga la documentacion de coordinacion


Examples:
| usuario   | password   |     rol                  |   cliente   | 
| maarrones | Primera08  | Tecnico de central       |  097810     |
| prl1      | Primera08  | Tecnico de zona          |  097810     |




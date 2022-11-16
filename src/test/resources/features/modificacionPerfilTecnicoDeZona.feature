

Feature: Modificacion perfil de Tecnico de zona
Modificación del perfil de “Técnico de zona” para que tenga acceso al cliente o clientes de su competencia. 

Background:
Given el usuario se loga en Hercules
| usuario   | password   |   rol          |    
| prl1      | Primera08  | Tecnico Zona   |
And el usuario se dirige a la pantalla Administracion Usuarios
And el usuario selecciona el usuario <"usuario"> de la tabla
| usuario                        |
|   un usuario existente         |
And el usuario pulsa el boton Clientes para seleccionar clientes
|       cliente                   |
| un nuevo cliente                |
@altaUsuario
Scenario Outline: Alta de Usuario
When el usuario agrega el nuevo cliente <"cliente">
And el usuario puede agregar el nuevo cliente <"cliente">

Examples:
| usuario                        |       cliente                   |
|   un usuario existente         | un nuevo cliente                |

@bajaUsuario
Scenario Outline: Baja de Usuario
When el usuario elimina el cliente <"cliente"> de la lista
And el usuario comprueba que no está en la lista

Examples:
| usuario                        |       cliente                   |
|   un usuario existente         | un nuevo cliente                |

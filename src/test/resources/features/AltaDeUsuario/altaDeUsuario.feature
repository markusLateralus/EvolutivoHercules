

Feature: Alta y Baja de usuario
Modificación del perfil de “Técnico de zona” para que tenga acceso al cliente o clientes de su competencia. 

Background:
Given el usuario se loga en Hercules
| usuario       | password   |   rol                |    
| maarrones     | Primera09  | Tecnico de Central   |
And el usuario se dirige a la pantalla Administracion Usuarios
And el usuario busca un rol y selecciona el usuario de la tabla
|       rol       |
|   Responsable   |  
And el usuario cambia el rol a Tecnico de Zona 

@altaUsuario
Scenario Outline: Alta de Usuario
When el usuario agrega el nuevo cliente "<cliente>"
Then el usuario puede comprobar que el cliente esta en la lista

Examples:
|  cliente |
| 071844   | 

@bajaUsuario
Scenario: Baja de Usuario
When el usuario elimina el primer cliente de la lista
Then el usuario comprueba que no está en la lista



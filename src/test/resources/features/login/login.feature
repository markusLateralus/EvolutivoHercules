
Feature: Logarse con diferentes Roles
El usuario quiere logarse en la aplicacion HERCULES de forma correcta

Background:
Given el usuario ingresa en la aplicacion Hercules
And  escribe el nombre y escribe el password
| nombre   | password    |         rol              |
| maarrones | Primera09  |  Técnico de central      |
| prl1      | Primera08  |  Tecnico de zona          |   
| prl2      | Primera08  |  Generico Responsable     | 
| prl3      | Primera08  |  Responsable de impresion | 
And hace click en el boton Login

@loginCorrecto
Scenario: Login correcto
When el usuario verifica su nombre
Then el usuario verifica su rol

Examples:
| nombre   | password   | boton | nombreCompleto                   |          rol              |
| maarrones | Primera09  | login | Arrones Alcañiz, Marcos Antonio  |  Técnico de central       |
| prl1      | Primera08  | login |    prl1                          |  Tecnico de zona          |   
| prl2      | Primera08  | login |    prl2                          |  Generico Responsable      | 
| prl3      | Primera08  | login |    prl3                          |   Responsable de impresion | 


@loginIncorrecto
Scenario: Login Incorrecto
When el usuario introduce mal los datos
Then el usuario no accede a Hercules

Examples:
| nombre   | password   | boton | nombreCompleto                   |          rol              |
| maarrones | Primera09  | login | Arrones Alcañiz, Marcos Antonio  |  Técnico de central       |
| prl1      | Primera08  | login |    prl1                          |  Tecnico de zona          |   
| prl2      | Primera08  | login |    prl2                          |  Generico Responsable      | 
| prl3      | Primera08  | login |    prl3                          |   Responsable de impresion | 

